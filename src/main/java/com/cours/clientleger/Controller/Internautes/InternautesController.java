package com.cours.clientleger.Controller.Internautes;

import com.cours.clientleger.Controller.Utils.DatabaseUtils;
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
    DatabaseUtils databaseUtils;

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
    public ModelAndView ReturnFromModify(@RequestParam Map<String, String> data, HttpSession httpSession) {
        ModelAndView modelReturn;
        if (databaseUtils.updateInDatabase(data, httpSession) != null) {
            modelReturn = Profile(httpSession);
        } else {
            modelReturn = Modify(httpSession);
        }

        return modelReturn;
    }
}
