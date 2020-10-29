package com.cours.clientleger.Controller.Offre;

import com.cours.clientleger.Application.Offres.Get.OffreGetHandler;
import com.cours.clientleger.Model.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.cours.clientleger.Controller.RefreshController.refresh;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/offre")
public class OffreController {
    @Autowired
    OffreGetHandler offreGetHandler;

    @GetMapping("")
    public ModelAndView Offres(HttpSession httpSession) {
        Page page = new Page()
                .setPagePath("page/offre/Offres")
                .setTitle("Offres");

        offreGetHandler.GetOffresList(httpSession);

        return refresh(page);
    }
}
