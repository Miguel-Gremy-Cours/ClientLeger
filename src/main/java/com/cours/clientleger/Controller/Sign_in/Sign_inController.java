package com.cours.clientleger.Controller.Sign_in;

import com.cours.clientleger.Controller.IndexController;
import com.cours.clientleger.Model.AccessingDataJPA.InternauteRepository;
import com.cours.clientleger.Model.DatabaseEntities.InternauteEntity;
import com.cours.clientleger.Model.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cours.clientleger.Application.Internautes.InternauteFunc;

import java.util.Map;

import javax.servlet.http.HttpSession;

import static com.cours.clientleger.Controller.RefreshController.refresh;


@Controller
@RequestMapping("/sign_in")
public class Sign_inController {
    @Autowired
    InternauteFunc internauteFunc;
    @Autowired
    InternauteRepository internauteRepository;

    IndexController indexController = new IndexController();

    /**
     * Controller to view the Sign in page
     *
     * @param httpSession Data in Http session
     * @return Sign in ModelAndView
     */
    @GetMapping()
    public ModelAndView Sign_in(HttpSession httpSession) {
        Page page = new Page()
                .setTitle("Sign in")
                .setPagePath("page/sign in/Sign in");

        return refresh(page);
    }

    /**
     * Controller to connect the user from Sign in page
     * And check if user entered good login password
     *
     * @param data        Data from HTML with values of the Internaute sign in
     * @param httpSession Data in Http session
     * @return The good controller if the user entered good login and password
     */
    @PostMapping("/return")
    public ModelAndView ReturnFromSign_in(@RequestParam Map<String, String> data, HttpSession httpSession) {
        ModelAndView modelReturn;

        InternauteEntity internauteEntity = internauteFunc.get(data.get("login"), data.get("password"));

        if (internauteEntity != null) {
            modelReturn = indexController.Index(httpSession);

            // Set internaute id
            httpSession.setAttribute("id", internauteEntity.getId());
            // Set isLoged to true
            httpSession.setAttribute("isLoged", true);
            // Remove all connection problems if exists
            httpSession.removeAttribute("problems");
        } else {
            httpSession.setAttribute("problems", "Login or password incorect");
            modelReturn = Sign_in(httpSession);
        }

        return modelReturn;
    }
}
