package com.cours.clientleger.Controller.Sign_in;

import com.cours.clientleger.Application.Internautes.Get.InternauteGetHandler;
import com.cours.clientleger.Model.AccessingDataJPA.InternauteRepository;
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
@RequestMapping("/sign_in")
public class Sign_inController {
    @Autowired
    InternauteRepository internauteRepository;
    @Autowired
    InternauteGetHandler internauteGetHandler;
    IndexController indexController = new IndexController();

    @GetMapping()
    public ModelAndView Sign_in(HttpSession httpSession) {
        Page page = new Page()
                .setTitle("Sign in")
                .setPagePath("page/sign in/Sign in");

        return refresh(page);
    }


    @PostMapping("/return")
    public ModelAndView ReturnFromSign_in(@RequestParam Map<String, String> data, HttpSession httpSession) throws Exception {
        ModelAndView modelReturn;
        if (internauteGetHandler.GetInternautes(data, httpSession)) {
            modelReturn = indexController.Index(httpSession);
        } else {
            modelReturn = Sign_in(httpSession);
        }

        return modelReturn;
    }
}
