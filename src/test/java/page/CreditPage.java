package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.CardInfo;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CreditPage {
    private SelenideElement heading = $$("h3").find(Condition.text("Кредит по данным карты"));
    private SelenideElement cardNumberField = $(".input__control[placeholder='0000 0000 0000 0000']");
    private SelenideElement monthField = $(".input__control[placeholder='08']");
    private SelenideElement yearField = $(".input__control[placeholder='22']");
    private SelenideElement ownerField = $$(".input").find(Condition.exactText("Владелец")).$(".input__control");
    private SelenideElement cvcField = $(".input__control[placeholder='999']");
    private SelenideElement continueButton = $$("button").find(Condition.exactText("Продолжить"));
    private SelenideElement notificationSuccess = $(".notification_status_ok");
    private SelenideElement notificationError = $(".notification_status_error");

    private SelenideElement validationFieldMessage = $(byText("Поле обязательно для заполнения"));
    private SelenideElement wrongFormatMessage = $(byText("Неверный формат"));
    private SelenideElement wrongExpirationMessage = $(byText("Неверно указан срок действия карты"));
    private SelenideElement cardExpiredMessage = $(byText("Истёк срок действия карты"));

    public CreditPage() {
        heading.shouldBe(Condition.visible);
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

    public CreditPage clear() {
        clearFields();
        return new CreditPage();

    }

    public boolean isCardExpiredMessageDisplayed() {
        return cardExpiredMessage.isDisplayed();
    }

    public void someOtherMethod() {
        CreditPage creditPage = new CreditPage();
        boolean isDisplayed = creditPage.isCardExpiredMessageDisplayed();

    }


    public void notificationSuccessIsVisible() {
        notificationSuccess.shouldBe(visible, Duration.ofSeconds(11));

    }

    public void notificationErrorIsVisible() {
        notificationError.shouldBe(visible, Duration.ofSeconds(15));

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
    public boolean isValidationFieldMessageDisplayed() {
        return validationFieldMessage.isDisplayed();
    }

}
