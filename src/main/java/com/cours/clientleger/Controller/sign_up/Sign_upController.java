package com.cours.clientleger.Controller.sign_up;

import com.cours.clientleger.Controller.IndexController;
import com.cours.clientleger.Model.AccessingDataJPA.InternautesRepository;
import com.cours.clientleger.Model.Database.Internautes;
import com.cours.clientleger.Model.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import static com.cours.clientleger.Controller.RefreshController.refresh;

@Controller
@RequestMapping("/sign_up")
public class Sign_upController {
    @Autowired
    InternautesRepository internautesRepository;
    IndexController indexController = new IndexController();

    @GetMapping("/new")
    public ModelAndView Register(HttpSession httpSession) {
        Page page = new Page();
        page.setTitle("Sign up");
        page.setPagePath("page/sign up/Sign up");

        return refresh(page);
    }

    @PostMapping("/return")
    public ModelAndView ReturnFromRegistration(@RequestParam Map<String, String> data, HttpSession httpSession) {
        System.out.println(data);
        ModelAndView modelReturn;
        Internautes internautes = new Internautes();
        internautes.setNom(data.get("nom"));
        internautes.setPrenom(data.get("prenom"));
        //TODO Find solution for date_naissance VERY URGENT
        internautes.setDate_naissance(Date.valueOf(data.get("date_naissance")));
        if (data.get("civility").equals("male")) {
            internautes.setCivilite(1);
        } else if (data.get("civility").equals("female")) {
            internautes.setCivilite(2);
        }
        internautes.setLogin(data.get("login"));
        internautes.setPassword(String.valueOf(data.get("password").hashCode()));
        internautes.setEmail(data.get("email"));

//EmailValidator.getInstance().isValid(internautes.getEmail())

        return indexController.Index(httpSession);
    }
}
