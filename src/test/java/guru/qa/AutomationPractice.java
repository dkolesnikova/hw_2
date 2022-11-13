package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPractice {

    @BeforeAll
    static void configure() {
        Configuration.browserSize = "700x400";
    }

    @Test
    void checkTheFormCanBeFilledInWithAllFields() {
        open("https://demoqa.com/automation-practice-form");
        $x("//input[@id='firstName']").setValue("Ilya");
        $x("//input[@id='lastName']").setValue("Ivanov");
        $x("//input[@id='userEmail']").setValue("mail@mail.ru");
        $x("//label[@for='gender-radio-1']").click();
        $x("//input[@id='userNumber']").setValue("88005553535");
        $x("//input[@id='dateOfBirthInput']").click();
        $x("//select[contains(@class,'react-datepicker__year-select')]").click();
        $x("//option[@value='2012']").click();
        $x("//option[@value='2012']").click();
        $x("//select[contains(@class,'react-datepicker__month-select')]").click();
        $x("//option[@value='0']").click();
        $x("//div[@aria-label='Choose Sunday, January 8th, 2012']").click();
        $x("//div[contains(@class,'text-right col-md-2 col-sm-12')]").click();

        $x("//*[contains(text(),'Student Name')]//following-sibling::td").shouldHave(text("Ilya Ivanov"));
        $x("//*[contains(text(),'Student Email')]//following-sibling::td").shouldHave(text("mail@mail.ru"));
        $x("//*[contains(text(),'Gender')]//following-sibling::td").shouldHave(text("Male"));
        $x("//*[contains(text(),'Mobile')]//following-sibling::td").shouldHave(text("8800555353"));
        $x("//*[contains(text(),'Date of Birth')]//following-sibling::td").shouldHave(text("08 January,2012"));

    }

}
