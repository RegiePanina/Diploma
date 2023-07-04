package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private SelenideElement heading = $$("h2").find(Condition.text("Путешествие дня"));
    private SelenideElement paymentButton = $$("button").find(Condition.exactText("Купить"));
    private SelenideElement creditButton = $$("button").find(Condition.exactText("Купить в кредит"));

    public MainPage() {
        heading.shouldBe(visible);
    }
    public PaymentPage goToPaymentPage() {
        paymentButton.click();
        return new PaymentPage();
    }
    public CreditPage goToCreditPage() {
        creditButton.click();
        return new CreditPage();
    }
}
