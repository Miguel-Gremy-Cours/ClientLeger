package com.cours.clientleger.Controller.Login;

import com.cours.clientleger.Model.Page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import javax.servlet.http.HttpSession;

import static com.cours.clientleger.Controller.RefreshController.refresh;

import com.cours.clientleger.Controller.IndexController;


@Controller
@RequestMapping("/login")
public class LoginController {
    IndexController indexController = new IndexController();

    @GetMapping()
    public ModelAndView Login(HttpSession httpSession) {
        Page page = new Page();
        page.setTitle("Login");
        page.setPagePath("page/login/Login");

        return refresh(page);
    }

    @GetMapping("/new")
    public ModelAndView Register(HttpSession httpSession) {
        Page page = new Page();
        page.setTitle("Login");
        page.setPagePath("page/login/Registration");

        return refresh(page);
    }

    @PostMapping("/return")
    public ModelAndView ReturnFromLogin(HttpSession httpSession) {
        //TODO get the payload of post request to add new user
        return indexController.Index(httpSession);
    }

    @PostMapping("/registration/return")
    public ModelAndView ReturnFromRegistration(@RequestParam Map<String, String> data, HttpSession httpSession) {
        System.out.println("data = " + data);
        return indexController.Index(httpSession);
    }
}
