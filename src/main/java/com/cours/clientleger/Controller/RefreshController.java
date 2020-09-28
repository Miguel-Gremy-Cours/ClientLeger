package com.cours.clientleger.Controller;

import com.cours.clientleger.Model.Page;

import org.springframework.web.servlet.ModelAndView;

public class RefreshController {
    public static ModelAndView refresh(Page page) {
        ModelAndView model = new ModelAndView("fragment/mainBody");
        model.addObject(page);

        return model;
    }
}
