package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class DemoqaTest {

    @BeforeAll
    static void setupSelenideEnv() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");

        $("#firstName").setValue("Timur");
        $("#lastName").setValue("Dasaev");
        $("#userEmail").setValue("email@example.ru");
        $("#genterWrapper .custom-control-label").click();
        $("#userNumber").setValue("8800555353");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("January")).click();
        $(".react-datepicker__year-select").$(byText("1997")).click();
        $(".react-datepicker__month").$(byText("8")).click();
        $("#subjectsContainer input").setValue("English").pressEnter();
        $("#hobbiesWrapper .custom-control-label").click();
        $("#uploadPicture").uploadFromClasspath("artworks.jpg");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#currentAddress").setValue("Shicago");
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Timur Dasaev"));
        $(".table-responsive").shouldHave(text("email@example.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("8800555353"));
        $(".table-responsive").shouldHave(text("08 January,1997"));
        $(".table-responsive").shouldHave(text("English"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("artworks.jpg"));
        $(".table-responsive").shouldHave(text("Shicago"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));
    }
}