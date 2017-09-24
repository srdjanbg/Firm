package application.controllers;

import application.domains.Duties;
import application.models.DutiesModel;
import application.services.DutiesService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Srdjan
 */
@Controller
public class DutiesController {

    @Autowired
    private DutiesService dutiesService;

    public DutiesService getDutiesService() {
        return dutiesService;
    }

    public void setDutiesService(DutiesService dutiesService) {
        this.dutiesService = dutiesService;
    }
    

    @RequestMapping(value = "/dodaj-zaduzenje", method = RequestMethod.GET)
    public String vratiStranicuZaDodavanjeZaduzenja(Model model) {

        model.addAttribute("novoZaduzenje", new DutiesModel());

        return "dodaj-zaduzenje";
    }

    @RequestMapping(value = "/dodaj-zaduzenje", method = RequestMethod.POST)
    public String dodajZaduzenje(@Valid @ModelAttribute("novoZaduzenje") DutiesModel novoZaduzenje,
            BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("hasErrors", true);
           

            return "dodaj-zaduzenje";
        } else {
            dutiesService.dodajZaduzenje(novoZaduzenje);

            return "redirect:/lista-zaduzenja";
        }

    }

    @RequestMapping(value = "/lista-zaduzenja", method = RequestMethod.GET)
    public String listajZaduzenja(Model model) {

        model.addAttribute("listaZaduzenja", dutiesService.listaZaduzenja());

        return "lista-zaduzenja";
    }

    @RequestMapping("/promenazad")
    public String promena(Model model, @RequestParam(required = true) Integer id) {

        model.addAttribute("promenjenoZaduzenje", dutiesService.pronadjiZaduzenje(id));

        return "promeni-zaduzenje";

    }

    @RequestMapping(value = "/menjaj-zaduzenje", method = RequestMethod.POST)
    public String menjajZaduzenje(
            @Valid @ModelAttribute("promenjenoZaduzenje") DutiesModel promenjenoZaduzenje,
            BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("hasErrors", true);

            return "promeni-zaduzenje";
        } else {
            dutiesService.promeniZaduzenje(promenjenoZaduzenje);

            return "redirect:/lista-zaduzenja";
        }
    }

    
    @RequestMapping("/brisanjezad")
    public String brisanje(Model model, @RequestParam(required = true) Integer id) {
        
        model.addAttribute("obrisanoZaduzenje", dutiesService.pronadjiZaduzenje(id));
        
        return "obrisi-zaduzenje";
        
    }
    
    @RequestMapping(value = "/brisi-zaduzenje", method = RequestMethod.POST)
   public String obrisiZaduzenje(
            @Valid @ModelAttribute("obrisanoZaduzenje") DutiesModel obrisanoZaduzenje) {
       
            dutiesService.obrisiZaduzenje(obrisanoZaduzenje);
            
            return "redirect:/lista-zaduzenja";
    }
   
   @RequestMapping(value = "/trazi-zaduzenje", method = RequestMethod.POST)
    public String traziZaduzenja(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {

        
       
        List<Duties> theDuties = dutiesService.traziZaduzenja(theSearchName);
       
        theModel.addAttribute("listaZaduzenja", theDuties);

        return "lista-zaduzenja";        
    }
    
    
}
