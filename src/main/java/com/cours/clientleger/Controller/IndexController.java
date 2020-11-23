package com.cours.clientleger.Controller;

import com.cours.clientleger.Model.Page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpSession;

import static com.cours.clientleger.Controller.RefreshController.*;

@Controller
public class IndexController {

    /**
     * Main controller of the application
     *
     * @param httpSession Data in Http session
     * @return Index ModelAndView
     */
    @GetMapping()
    public ModelAndView Index(HttpSession httpSession) {
        Page page = new Page()
                .setTitle("Home")
                .setPagePath("page/home/Home");

        return refresh(page);
    }
}
