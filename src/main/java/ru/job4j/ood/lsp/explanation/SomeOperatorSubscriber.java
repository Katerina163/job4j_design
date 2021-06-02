package ru.job4j.ood.lsp.explanation;

public class SomeOperatorSubscriber extends Subscriber {

    public SomeOperatorSubscriber(PhoneNumber phoneNumber) {
        super(phoneNumber);
    }

    @Override
    public void setPhoneNumber(PhoneNumber phoneNumber) {
        // some specific logic;
        // Забыли сделать проверку. Возможно не валидное состояние
        phoneNumber = phoneNumber;
    }
}
