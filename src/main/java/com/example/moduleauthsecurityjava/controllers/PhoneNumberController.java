package com.example.moduleauthsecurityjava.controllers;

import com.example.moduleauthsecurityjava.exceptions.PhoneNumberException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.moduleauthsecurityjava.models.PhoneNumberRequest;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneNumberController {
    @PostMapping("/phone-number")
    @ExceptionHandler(PhoneNumberException.class)
    public String phoneNumberSubmit(@ModelAttribute PhoneNumberRequest request, HttpServletResponse response) throws PhoneNumberException {
        System.out.println("\033[96mThe user submitted the phone number: " + request.getPhone() + "\033[0m");

        if (request.isPhoneNumberCorrect()) {
            response.setStatus(HttpServletResponse.SC_OK);
            return "Successful!";
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            throw new PhoneNumberException();
        }
    }
}
