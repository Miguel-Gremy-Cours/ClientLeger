package com.cours.clientleger.Controller.Sign_up;

import com.cours.clientleger.Controller.Sign_in.Sign_inController;
import com.cours.clientleger.Model.Page;
import com.cours.clientleger.Application.Internautes.Create.InternauteCreateHandler;

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
    InternauteCreateHandler internauteCreateHandler;
    Sign_inController sign_inController = new Sign_inController();

    @GetMapping("/new")
    public ModelAndView Sign_up(HttpSession httpSession) {
        Page page = new Page()
                .setTitle("Sign up")
                .setPagePath("page/sign up/Sign up");

        return refresh(page);
    }

    @PostMapping("/return")
    public ModelAndView ReturnFromSign_up(@RequestParam Map<String, String> data, HttpSession httpSession) throws Exception {
        ModelAndView modelReturn;
        if (internauteCreateHandler.CreateInternautes(data, httpSession)) {
            modelReturn = sign_inController.Sign_in(httpSession);
        } else {
            modelReturn = Sign_up(httpSession);
        }

        return modelReturn;
    }
}
