package com.cours.clientleger.Application.Internautes.LogOut;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class InternautesLogOutHandler {
    public void LogOut(HttpSession httpSession) {
        httpSession.removeAttribute("data");
        httpSession.removeAttribute("isLoged");
    }
}
