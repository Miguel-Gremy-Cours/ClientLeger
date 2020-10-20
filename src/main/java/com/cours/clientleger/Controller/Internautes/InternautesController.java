package com.cours.clientleger.Controller.Internautes;

import com.cours.clientleger.Application.Internautes.LogOut.InternauteLogOutHandler;
import com.cours.clientleger.Application.Internautes.Update.InternauteUpdateHandler;
import com.cours.clientleger.Controller.IndexController;
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
@RequestMapping("/profile")
public class InternautesController {
    @Autowired
    InternauteUpdateHandler internauteUpdateHandler;
    @Autowired
    InternauteLogOutHandler internauteLogOutHandler;
    IndexController indexController = new IndexController();

    @GetMapping("")
    public ModelAndView Profile(HttpSession httpSession) {
        Page page = new Page();
        page.setTitle("Profile");
        page.setPagePath("page/profile/Profile");

        return refresh(page);
    }

    @GetMapping("/modify")
    public ModelAndView Modify(HttpSession httpSession) {
        Page page = new Page();
        page.setTitle("Modify");
        page.setPagePath("page/profile/Modify");

        return refresh(page);
    }

    @PostMapping("/modify/return")
    public ModelAndView ReturnFromModify(@RequestParam Map<String, String> data, HttpSession httpSession) throws Exception {
        ModelAndView modelReturn;
        if (internauteUpdateHandler.UpdateInternautes(data, httpSession)) {
            modelReturn = Profile(httpSession);
        } else {
            modelReturn = Modify(httpSession);
        }

        return modelReturn;
    }

    @PostMapping("/logout")
    public ModelAndView LogOut(HttpSession httpSession) {
        internauteLogOutHandler.LogOut(httpSession);
        ModelAndView modelReturn = indexController.Index(httpSession);

        return modelReturn;
    }
}
