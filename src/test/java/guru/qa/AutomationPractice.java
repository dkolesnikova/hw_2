package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPractice {

    @BeforeAll
    static void configure() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void checkTheFormCanBeFilledInWithAllFields() {
        //Arrange
        String firstName = "Ilya";
        String secondName = "Ivanov";
        String mail = "mail@mail.ru";
        String number = "8800555353";
        String address = "Smolensk";
        String subject = "English";
        String state = "NCR";
        String city = "Delhi";
        //Act
        open("https://demoqa.com/automation-practice-form");
        $x("//input[@id='firstName']").setValue(firstName);
        $x("//input[@id='lastName']").setValue(secondName);
        $x("//input[@id='userEmail']").setValue(mail);
        $x("//label[contains(text(),'Male')]").click();
        $x("//input[@id='userNumber']").setValue(number);
        $x("//input[@id='dateOfBirthInput']").click();
        $x("//select[contains(@class,'react-datepicker__year-select')]").click();
        $x("//option[@value='2012']").click();
        $x("//option[@value='2012']").click();
        $x("//select[contains(@class,'react-datepicker__month-select')]").click();
        $x("//option[@value='0']").click();
        $x("//div[@aria-label='Choose Sunday, January 8th, 2012']").click();
        $x("//input[@id='subjectsInput']").setValue(subject);
        $x("//input[@id='subjectsInput']").pressEnter();
        $x("//label[contains(text(),'Sports')]").click();
        $x("//label[contains(text(),'Reading')]").click();
        $x("//label[contains(text(),'Music')]").click();
        $x("//input[@id='uploadPicture']").uploadFile(new File("src/test/resources/images.jfif"));
        $x("//textarea[@id='currentAddress']").setValue(address);
        $x("//input[@id='react-select-3-input']").setValue(state);
        $x("//input[@id='react-select-3-input']").pressEnter();
        $x("//input[@id='react-select-4-input']").setValue(city);
        $x("//input[@id='react-select-4-input']").pressEnter();
        $x("//div[contains(@class,'text-right col-md-2 col-sm-12')]").click();
        //Assert
        $x("//*[contains(text(),'Student Name')]//following-sibling::td").shouldHave(text(firstName + " " + secondName));
        $x("//*[contains(text(),'Student Email')]//following-sibling::td").shouldHave(text(mail));
        $x("//*[contains(text(),'Gender')]//following-sibling::td").shouldHave(text("Male"));
        $x("//*[contains(text(),'Mobile')]//following-sibling::td").shouldHave(text(number));
        $x("//*[contains(text(),'Date of Birth')]//following-sibling::td").shouldHave(text("08 January,2012"));
        $x("//*[contains(text(),'Subjects')]//following-sibling::td").shouldHave(text(subject));
        $x("//*[contains(text(),'Hobbies')]//following-sibling::td").shouldHave(text("Sports, Reading, Music"));
        $x("//*[contains(text(),'Picture')]//following-sibling::td").shouldHave(text("images.jfif"));
        $x("//*[contains(text(),'Address')]//following-sibling::td").shouldHave(text("Smolensk"));
        $x("//*[contains(text(),'State and City')]//following-sibling::td").shouldHave(text(state + " " + city));
    }
}
