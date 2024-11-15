package com.example.moduleauthsecurityjava.models;

public class PhoneNumberRequest {
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isPhoneNumberCorrect() {
        final String REGEX = "^(?:0|\\+?44)(?:\\d\\s?){9,10}$";
        return phone.matches(REGEX);
    }
}
