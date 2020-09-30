package com.cours.clientleger.Controller.Login;

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

import java.util.Map;

import javax.servlet.http.HttpSession;

import static com.cours.clientleger.Controller.RefreshController.refresh;

import com.cours.clientleger.Controller.IndexController;


@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    InternautesRepository internautesRepository;
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
    public ModelAndView ReturnFromLogin(@RequestParam Map<String, String> data, HttpSession httpSession) {
        //TODO Password must be hash
        ModelAndView modelReturn;
        Internautes internautes = null;
        //Check if user account exists in database
        if (internautesRepository.existsByLoginAndPassword(data.get("login"), data.get("password"))) {
            //Internautes object define on database return
            internautes = internautesRepository.getByLoginAndPassword(data.get("login"), data.get("password"));
            //Set session information internautes to get in web page
            httpSession.setAttribute("Internautes", internautes);
            modelReturn = indexController.Index(httpSession);
        } else {
            //Set session error login to get in web page
            httpSession.setAttribute("ErrorLogin", "Login or password incorrect.");
            modelReturn = Login(httpSession);
        }
        return modelReturn;
    }

    @PostMapping("/registration/return")
    public ModelAndView ReturnFromRegistration(@RequestParam Map<String, String> data, HttpSession httpSession) {
        //TODO Password must be hash

        return indexController.Index(httpSession);
    }

    //TODO Profile settings controller and web page
}
