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

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import static com.cours.clientleger.Controller.RefreshController.refresh;
import static com.cours.clientleger.Controller.Utils.DateUtils.stringToLocalDate;

@Controller
@RequestMapping("/sign_up")
public class Sign_upController {
    @Autowired
    InternautesRepository internautesRepository;
    IndexController indexController = new IndexController();

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
        int civilite = 0;
        if (data.get("civility").equals("male")) {
            civilite = 1;
        } else if (data.get("civility").equals("female")) {
            civilite = 2;
        }
        Internautes internautes = new Internautes(
                data.get("nom"),
                data.get("prenom"),
                stringToLocalDate(data.get("date_naissance")),
                civilite,
                null,
                data.get("login"),
                String.valueOf(data.get("password").hashCode()),
                null,
                data.get("email")
        );

        System.out.println(internautes.toString());

        if (internautes.isSet()) {
            internautesRepository.save(internautes);
            modelReturn = indexController.Index(httpSession);
        } else {
            List<String> problems = internautes.getProblem();
            httpSession.setAttribute("problems", problems);
            modelReturn = Sing_up(httpSession);
        }


        return modelReturn;
    }
}
