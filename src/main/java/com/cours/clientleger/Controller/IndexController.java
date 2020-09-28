package com.cours.clientleger.Controller;

import com.cours.clientleger.Model.Page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @GetMapping()
    public ModelAndView Index(HttpSession httpSession) {
        Page page = new Page();
        page.setTitle("Home");
        page.setPagePath("page/home/Home");

        return refresh(page);
    }

    private ModelAndView refresh(Page page) {
        ModelAndView model = new ModelAndView("fragment/mainBody");
        model.addObject(page);

        return model;
    }
}
