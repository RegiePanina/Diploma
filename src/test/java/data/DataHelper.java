package data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {
    private DataHelper() {
    }

    private static Faker fakerEn = new Faker(new Locale("en"));
    private static Faker fakerRu = new Faker(new Locale("ru"));

    //positive scenarios
    public static CardInfo getApprovedCard() {
        return new CardInfo("4444 4444 4444 4441", getMonth(), getYear(), getOwner(), getCvc());
    }

    public static CardInfo getDeclinedCard() {
        return new CardInfo("4444 4444 4444 4442", getMonth(), getYear(), getOwner(), getCvc());
    }

    //negative scenarios
    //field card number
    public static CardInfo getInvalidCardNumber() {
        return new CardInfo("4444 4444", getMonth(), getYear(), getOwner(), getCvc());
    }

    public static CardInfo getEmptyCardNumber() {
        return new CardInfo("", getMonth(), getYear(), getOwner(), getCvc());
    }

    public static CardInfo getAllZeroCardNumber() {
        return new CardInfo("0000 0000 0000 0000", getMonth(), getYear(), getOwner(), getCvc());
    }

    public static CardInfo getNonExistCardNumber() {
        return new CardInfo(getRandomCardNumber(), getMonth(), getYear(), getOwner(), getCvc());
    }

    //field month
    public static CardInfo getInvalidMonth() {
        return new CardInfo("4444 4444 4444 4441", "15", getYear(), getOwner(), getCvc());
    }

    public static CardInfo getAllZeroMonth() {
        return new CardInfo("4444 4444 4444 4441", "00", getYear(), getOwner(), getCvc());
    }

    public static CardInfo getEmptyMonth() {
        return new CardInfo("4444 4444 4444 4441", "", getYear(), getOwner(), getCvc());
    }
    public static CardInfo getMonthOver12() {
        return new CardInfo("4444 4444 4444 4441", "13", getYear(), getOwner(), getCvc());
    }

    //field year
    public static CardInfo getLastYear() {
        return new CardInfo("4444 4444 4444 4441", getMonth(), getPastYear(), getOwner(), getCvc());
    }

    public static CardInfo getEmptyYear() {
        return new CardInfo("4444 4444 4444 4441", getMonth(), "", getOwner(), getCvc());
    }

    //field owner
    public static CardInfo getInvalidOwner() {
        return new CardInfo("4444 4444 4444 4441", getMonth(), getYear(), "Regina", getCvc());
    }

    public static CardInfo getEmptyOwner() {
        return new CardInfo("4444 4444 4444 4441", getMonth(), getYear(), "", getCvc());
    }

    public static CardInfo getInvalidSymbolOwner() {
        return new CardInfo("4444 4444 4444 4441", getMonth(), getYear(), "@#$^", getCvc());
    }

    //field CVC/CVV
    public static CardInfo getAllZeroCVC() {
        return new CardInfo("4444 4444 4444 4441", getMonth(), getYear(), getOwner(), "000");
    }

    public static CardInfo getEmptyCVC() {
        return new CardInfo("4444 4444 4444 4441", getMonth(), getYear(), getOwner(), "");
    }

    public static CardInfo getLessNumbers() {
        return new CardInfo("4444 4444 4444 4441", getMonth(), getYear(), getOwner(), "1");
    }

    public static CardInfo getMoreNumbers() {
        return new CardInfo("4444 4444 4444 4441", getMonth(), getYear(), getOwner(), "1234");
    }

    //generate data
    public static String getMonth() {
        String month = LocalDate.now().format(DateTimeFormatter.ofPattern("ММ"));
        return month;
    }

    public static String getYear() {
        String year = LocalDate.now().format(DateTimeFormatter.ofPattern("уу"));
        return year;
    }

    public static String getPastYear() {
        String pastYear = LocalDate.now().minusYears(1).format(DateTimeFormatter.ofPattern("yy"));
        return pastYear;
    }

    public static String getOwner() {
        return fakerEn.name().firstName() + " " + fakerEn.name().lastName();
    }

    public static String getCvc() {
        return fakerEn.number().digits(3);
    }

    public static String getRandomCardNumber() {
        return fakerEn.business().creditCardNumber();
    }
}


