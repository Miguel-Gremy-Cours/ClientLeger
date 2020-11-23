package com.cours.clientleger.Controller.Offre;

import com.cours.clientleger.Application.Offres.Get.OffreGetHandler;
import com.cours.clientleger.Controller.IndexController;
import com.cours.clientleger.Model.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import static com.cours.clientleger.Controller.RefreshController.refresh;

@Controller
@RequestMapping("/offre")
public class OffreController {
    @Autowired
    OffreGetHandler offreGetHandler;
    @Autowired
    IndexController indexController;

    /**
     * Controller to view the Offres list
     *
     * @param httpSession Data in Http session
     * @return Offres ModelAndView
     */
    @GetMapping("")
    public ModelAndView Offres(HttpSession httpSession) {
        Page page = new Page()
                .setPagePath("page/offre/Offres")
                .setTitle("Offres");

        offreGetHandler.GetOffresList(httpSession);

        return refresh(page);
    }

    /**
     * Controller to view details of selected offre
     *
     * @param Id          Selected Offre's Id
     * @param httpSession Data in Http session
     * @return Offre ModelAndView
     */
    @GetMapping("/{Id}")
    public ModelAndView OffreDetail(@PathVariable int Id, HttpSession httpSession) {
        Page page = new Page()
                .setPagePath("page/offre/Offre")
                .setTitle("Offre " + Id);

        offreGetHandler.GetOffre(Id, httpSession);

        return refresh(page);
    }

    /**
     * Controller to postulate to an offer
     *
     * @param IdOffre     Selected Offre's Id
     * @param httpSession Data in Http session
     * @return Index ModelAndView
     */
    @GetMapping("/postulate/{IdOffre}")
    public ModelAndView OffrePostulate(@PathVariable int IdOffre, HttpSession httpSession) {
        return indexController.Index(httpSession);
    }
}
