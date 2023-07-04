package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataHelper;
import data.SQLHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import page.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreditPageTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());

    }
    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");

    }
    @BeforeEach
    void setUp() {
        open("http://localhost:8080/");
    }
    @AfterEach
    void cleanBase() {
        SQLHelper.cleanDatabase();
    }

    @Test
    void shouldMakePaymentWithApprovedCard() {
        var mainPage = new MainPage();
        var credit = mainPage.goToCreditPage();
        credit.fillData(DataHelper.getApprovedCard());
        credit.notificationSuccessIsVisible();
        assertEquals("APPROVED", SQLHelper.getCreditStatus());
    }
    @Test
    void shouldMakePaymentWithDeclinedCard() {
        var mainPage = new MainPage();
        var credit = mainPage.goToCreditPage();
        credit.fillData(DataHelper.getDeclinedCard());
        credit.notificationErrorIsVisible();
        assertEquals("DECLINED", SQLHelper.getCreditStatus());

    }
    @Test
    void shouldMakePaymentWithInvalidCardNumber() {
        var mainPage = new MainPage();
        var credit = mainPage.goToCreditPage();
        credit.fillData(DataHelper.getInvalidCardNumber());
        credit.getWrongFormatMessage();

    }
    @Test
    void shouldMakePaymentWithEmptyCardNumber() {
        var mainPage = new MainPage();
        var credit = mainPage.goToCreditPage();
        credit.fillData(DataHelper.getEmptyCardNumber());
        credit.getValidationFieldMessage();
    }
    @Test
    void shouldMakePaymentWithAllZeroCardNumber() {
        var mainPage = new MainPage();
        var credit = mainPage.goToCreditPage();
        credit.fillData(DataHelper.getAllZeroCardNumber());
        credit.getWrongFormatMessage();
    }
//    @Test
//    void shouldMakePaymentWithNonExistCardNumber() {
//        var mainPage = new MainPage();
//        var credit = mainPage.goToCreditPage();
//        credit.fillData(DataHelper.getNonExistCardNumber());
//        credit.setNotificationErrorIsVisible();
//        assertEquals(null, SQLHelper.getCreditStatus());
//    }
    @Test
    void shouldMakePaymentWithInvalidMonth() {
        var mainPage = new MainPage();
        var credit = mainPage.goToCreditPage();
        credit.fillData(DataHelper.getInvalidMonth());
        credit.getValidationFieldMessage();
    }
    @Test
    void shouldMakePaymentWithEmptyMonth() {
        var mainPage = new MainPage();
        var credit = mainPage.goToCreditPage();
        credit.fillData(DataHelper.getEmptyMonth());
        credit.getValidationFieldMessage();

        boolean isDisplayed = credit.isValidationFieldMessageDisplayed();
        assertTrue(isDisplayed);

    }
    @Test
    void shouldMakePaymentWithAllZeroMonth() {
        var mainPage = new MainPage();
        var credit = mainPage.goToCreditPage();
        credit.fillData(DataHelper.getAllZeroMonth());
        credit.getWrongFormatMessage();
    }
    @Test
    void shouldMakePaymentWithMonthOver12() {
        var mainPage = new MainPage();
        var credit = mainPage.goToCreditPage();
        credit.fillData(DataHelper.getMonthOver12());
        credit.getWrongCardExpirationMessage();
    }

    @Test
    void shouldMakePaymentWithLastYear() {
        var mainPage = new MainPage();
        var credit = mainPage.goToCreditPage();
        credit.fillData(DataHelper.getLastYear());
        credit.getCardExpiredMessage();
    }
    @Test
    void shouldMakePaymentWithEmptyFieldYear() {
        var mainPage = new MainPage();
        var credit = mainPage.goToCreditPage();
        credit.fillData(DataHelper.getEmptyYear());
        credit.getWrongFormatMessage();
    }
    @Test
    void shouldMakePaymentWithFieldOwnerOnlyName() {
        var mainPage = new MainPage();
        var credit = mainPage.goToCreditPage();
        credit.fillData(DataHelper.getInvalidOwner());
        credit.getWrongFormatMessage();
    }
    @Test
    void shouldMakePaymentWithEmptyFieldOwner() {
        var mainPage = new MainPage();
        var credit = mainPage.goToCreditPage();
        credit.fillData(DataHelper.getEmptyOwner());
        credit.getValidationFieldMessage();
    }
    @Test
    void shouldMakePaymentWithInvalidFieldOwnerBySymbol() {
        var mainPage = new MainPage();
        var credit = mainPage.goToCreditPage();
        credit.fillData(DataHelper.getInvalidSymbolOwner());
        credit.getWrongFormatMessage();
    }
    @Test
    void shouldMakePaymentWithAllZeroCVC() {
        var mainPage = new MainPage();
        var credit = mainPage.goToCreditPage();
        credit.fillData(DataHelper.getAllZeroCVC());
        credit.getWrongFormatMessage();
    }
    @Test
    void shouldMakePaymentWithEmptyCVC() {
        var mainPage = new MainPage();
        var credit = mainPage.goToCreditPage();
        credit.fillData(DataHelper.getEmptyCVC());
        credit.getValidationFieldMessage();
    }
    @Test
    void shouldMakePaymentWithLessNumbersOfCVC() {
        var mainPage = new MainPage();
        var credit = mainPage.goToCreditPage();
        credit.fillData(DataHelper.getLessNumbers());
        credit.getWrongFormatMessage();
    }
    @Test
    void shouldMakePaymentWithMoreNumbersOfCVC() {
        var mainPage = new MainPage();
        var credit = mainPage.goToCreditPage();
        credit.fillData(DataHelper.getMoreNumbers());
        credit.getWrongFormatMessage();
    }

}

