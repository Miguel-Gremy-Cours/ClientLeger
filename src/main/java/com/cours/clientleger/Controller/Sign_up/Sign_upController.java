package com.cours.clientleger.Controller.Sign_up;

import com.cours.clientleger.Controller.Sign_in.Sign_inController;
import com.cours.clientleger.Controller.Utils.DatabaseUtils;
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
    DatabaseUtils databaseUtils;
    Sign_inController sign_inController = new Sign_inController();

    @GetMapping("/new")
    public ModelAndView Sing_up(HttpSession httpSession) {
        Page page = new Page();
        page.setTitle("Sign up");
        page.setPagePath("page/sign up/Sign up");

        return refresh(page);
    }

    @PostMapping("/return")
    public ModelAndView ReturnFromSign_up(@RequestParam Map<String, String> data, HttpSession httpSession) {
        ModelAndView modelReturn;

        if (databaseUtils.insertInDatabase(data, httpSession) != null) {
            modelReturn = sign_inController.Login(httpSession);
        } else {
            modelReturn = Sing_up(httpSession);
        }


        return modelReturn;
    }
}
