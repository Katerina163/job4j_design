package ru.job4j.ood.lsp.explanation;

public class PhoneNumber {
    private int countryCode;

    private int cityCode;

    private int number;

    public PhoneNumber(int countryCode, int cityCode, int number) {
        this.countryCode = countryCode;
        this.cityCode = cityCode;
        this.number = number;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public int getCityCode() {
        return cityCode;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
