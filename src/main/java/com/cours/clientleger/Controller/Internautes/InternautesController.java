package com.cours.clientleger.Controller.Internautes;

import com.cours.clientleger.Application.Internautes.InternauteFunc;
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
    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    InternauteFunc internauteFunc;

    /**
     * Controller to view the profile information
     *
     * @param httpSession Data in Http session
     * @return Profile ModelAndView
     */
    @GetMapping("")
    public ModelAndView Profile(HttpSession httpSession) {
        Page page = new Page().
                setTitle("Profile")
                .setPagePath("page/profile/Profile");
        httpSession.setAttribute("data", internauteFunc.get(Integer.parseInt(httpSession.getAttribute("id").toString())));

        return refresh(page);
    }

    /**
     * Controller to view the update profile information page
     *
     * @param httpSession Data in Http session
     * @return Modify ModelAndView
     */
    @GetMapping("/modify")
    public ModelAndView Modify(HttpSession httpSession) {
        Page page = new Page().
                setTitle("Modify")
                .setPagePath("page/profile/Modify");

        return refresh(page);
    }

    /**
     * Controller to check if modified information are correct
     * And do the redirection if the informations are good or not
     *
     * @param data        Data from HTML with values of the Internaute get
     * @param httpSession Data in Http session
     * @return The correct ModelAndView if there are errors or not
     */
    @PostMapping("/modify/return")
    public ModelAndView ReturnFromModify(@RequestParam Map<String, String> data, HttpSession httpSession) {
        Page page = new Page();
        try {
            internauteFunc.update(data, httpSession);
            page.setPagePath("page/profile/Profile");
            page.setTitle("Profile");
            httpSession.setAttribute("data", internauteFunc.get(Integer.parseInt(httpSession.getAttribute("id").toString())));
            httpSession.removeAttribute("problems");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            page.setPagePath("page/profile/Modify")
                    .setTitle("Modify");
            httpSession.setAttribute("problems", "Invalid input");
        }

        return refresh(page);
    }

    /**
     * Controller that log out the user by deleting it's session information
     *
     * @param httpSession Data in Http session
     * @return Index ModelAndView
     */
    @PostMapping("/logout")
    public ModelAndView LogOut(HttpSession httpSession) {
        Page page = new Page()
                .setPagePath("page/home/Home")
                .setTitle("Home");
        internauteFunc.logOut(httpSession);
        return refresh(page);
    }
}
