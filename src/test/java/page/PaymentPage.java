package page;

import com.codeborne.selenide.SelenideElement;
import data.CardInfo;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PaymentPage {
    private SelenideElement heading = $$("h3").find(text("Оплата по карте"));
    private SelenideElement cardNumberField =  $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement monthField = $("[placeholder='08']");
    private SelenideElement yearField = $("[placeholder='22']");
    private SelenideElement ownerField = $(byText("Владелец")).parent().$(".input__control");
    private SelenideElement cvcField = $("[placeholder='999']");

    private SelenideElement continueButton = $$("button").find(exactText("Продолжить"));

    private SelenideElement notificationSuccess = $(".notification_status_ok");
    private SelenideElement notificationError = $(".notification_status_error");

    private SelenideElement validationFieldMessage = $(byText("Поле обязательно для заполнения"));

    private SelenideElement wrongFormatMessage = $(byText("Неверный формат"));

    private SelenideElement wrongExpirationMessage = $(byText("Неверно указан срок действия карты"));

    private SelenideElement cardExpiredMessage = $(byText("Истёк срок действия карты"));

    public PaymentPage() {
        heading.shouldBe(visible);
    }

    public void fillData(CardInfo cardInfo) {
        cardNumberField.setValue(cardInfo.getNumber());
        monthField.setValue(cardInfo.getMonth());
        yearField.setValue(cardInfo.getYear());
        ownerField.setValue(cardInfo.getOwner());
        cvcField.setValue(cardInfo.getCvc());
        continueButton.click();

    }

    public void clearFields() {
        cardNumberField.doubleClick().sendKeys(Keys.BACK_SPACE);
        monthField.doubleClick().sendKeys(Keys.BACK_SPACE);
        yearField.doubleClick().sendKeys(Keys.BACK_SPACE);
        ownerField.doubleClick().sendKeys(Keys.BACK_SPACE);
        cvcField.doubleClick().sendKeys(Keys.BACK_SPACE);

    }

    public PaymentPage clear() {
        clearFields();
        return new PaymentPage();

    }

    public boolean isCardExpiredMessageDisplayed() {
        return cardExpiredMessage.isDisplayed();
    }



    public void notificationSuccessIsVisible() {
        notificationSuccess.shouldBe(visible, Duration.ofSeconds(11));

    }

    public void notificationErrorIsVisible() {
        notificationError.shouldBe(visible, Duration.ofSeconds(11));

    }

    public void getValidationFieldMessage() {
        validationFieldMessage.shouldBe(visible, Duration.ofSeconds(15));

    }

    public void getWrongFormatMessage() {
        wrongFormatMessage.shouldBe(visible, Duration.ofSeconds(15));

    }

    public void getWrongCardExpirationMessage() {
        wrongExpirationMessage.shouldBe(visible, Duration.ofSeconds(15));

    }

    public void getCardExpiredMessage() {
        cardExpiredMessage.shouldBe(visible, Duration.ofSeconds(15));
    }

}