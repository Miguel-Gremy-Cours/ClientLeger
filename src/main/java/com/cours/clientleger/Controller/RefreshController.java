package com.cours.clientleger.Controller;

import com.cours.clientleger.Model.Page;

import org.springframework.web.servlet.ModelAndView;

public class RefreshController {
    /**
     * Function to create and link the good view with the Objects
     *
     * @param page Object that contain Title and Path to the HTML file
     * @return The model of the page
     */
    public static ModelAndView refresh(Page page) {
        ModelAndView model = new ModelAndView("fragment/mainBody");
        model.addObject(page);

        return model;
    }
}
