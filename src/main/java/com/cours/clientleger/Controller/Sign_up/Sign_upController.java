package com.cours.clientleger.Controller.Sign_up;

import com.cours.clientleger.Application.Internautes.InternauteFunc;
import com.cours.clientleger.Controller.Sign_in.Sign_inController;
import com.cours.clientleger.Model.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import javax.servlet.http.HttpSession;

import static com.cours.clientleger.Controller.RefreshController.refresh;

@Controller
@RequestMapping("/sign_up")
public class Sign_upController {
    @Autowired
    InternauteFunc internauteFunc;

    Sign_inController sign_inController = new Sign_inController();

    /**
     * Controller to view the sign up page
     *
     * @param httpSession Data in Http session
     * @return Sign up ModelAndView
     */
    @GetMapping("/new")
    public ModelAndView Sign_up(HttpSession httpSession) {
        Page page = new Page()
                .setTitle("Sign up")
                .setPagePath("page/sign up/Sign up");

        return refresh(page);
    }

    /**
     * Controller to connect and create the user from the Sign up page
     * And check if user entered good login and password
     *
     * @param data        Data from HTML with values of the Internaute sign up
     * @param httpSession Data in Http session
     * @return The correct ModelAndView if there are errors or not
     */
    @PostMapping("/return")
    public ModelAndView ReturnFromSign_up(@RequestParam Map<String, String> data, HttpSession httpSession) {
        ModelAndView modelReturn;

        try {
            internauteFunc.create(data);
            modelReturn = sign_inController.Sign_in(httpSession);
            httpSession.removeAttribute("problems");
        } catch (Exception ignore) {
            modelReturn = Sign_up(httpSession);
            httpSession.setAttribute("problems", "Please fill all fields");
        }

        return modelReturn;
    }
}
