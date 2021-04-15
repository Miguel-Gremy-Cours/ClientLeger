package com.cours.clientleger.Controller.Offre;

import com.cours.clientleger.Model.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cours.clientleger.Application.Offres.OffresFunc;

import javax.servlet.http.HttpSession;

import static com.cours.clientleger.Controller.RefreshController.refresh;

@Controller
@RequestMapping("/offre")
public class OffreController {
    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    OffresFunc offresFunc;

    /**
     * Controller to view the Offres list
     *
     * @param httpSession Data in Http session
     * @return Offres ModelAndView
     */
    @GetMapping("")
    public ModelAndView Offres(HttpSession httpSession, String searchString) {
        Page page = new Page()
                .setPagePath("page/offre/Offres")
                .setTitle("Offres");
        try {
            httpSession.setAttribute("offres", offresFunc.search(searchString));
        } catch (Exception ignore) {
            httpSession.setAttribute("offres", offresFunc.getOffres());
        }

        return refresh(page);
    }

    /**
     * Controller to view details of selected offre
     *
     * @param Id          Selected Offre's Id
     * @param httpSession Data in Http session
     * @return Offre ModelAndView
     */
    @GetMapping("/detail/{Id}")
    public ModelAndView OffreDetail(@PathVariable int Id, HttpSession httpSession) {
        Page page = new Page()
                .setPagePath("page/offre/Offre")
                .setTitle("Offre " + Id);

        httpSession.setAttribute("offre", offresFunc.getOffre(Id));

        httpSession.removeAttribute("problems");

        return refresh(page);
    }

    /**
     * Controller to postulate to an offer
     *
     * @param idOffre     Selected Offre's Id
     * @param httpSession Data in Http session
     * @return Index ModelAndView
     */
    @GetMapping("/postulate/{idOffre}")
    public ModelAndView OffrePostulate(@PathVariable int idOffre, HttpSession httpSession) {
        Page page = new Page();

        if (offresFunc.createOffreInternaute(httpSession, idOffre)) {
            page.setPagePath("page/home/Home")
                    .setTitle("Home");
        } else {
            page.setPagePath("page/offre/Offre")
                    .setTitle("Offre " + idOffre);
            httpSession.setAttribute("problems", "You already apply to this offer");
        }

        return refresh(page);
    }
}
