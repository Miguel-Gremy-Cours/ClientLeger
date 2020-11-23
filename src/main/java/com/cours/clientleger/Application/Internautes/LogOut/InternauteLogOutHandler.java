package com.cours.clientleger.Application.Internautes.LogOut;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class InternauteLogOutHandler {
    /**
     * Function that disconnect the user by deleting data from it's session and deleting isLoged variable in session
     *
     * @param httpSession Data in Http session
     */
    public void LogOut(HttpSession httpSession) {
        httpSession.removeAttribute("data");
        httpSession.removeAttribute("isLoged");
    }
}
