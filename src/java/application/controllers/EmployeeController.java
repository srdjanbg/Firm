package application.controllers;

import application.models.EmployeeModel;
import application.services.EmployeeService;
import application.*;
import application.domains.Employee;
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
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    

   
    @RequestMapping(value = "/dodaj-zaposlenog", method = RequestMethod.GET)
    public String vratiStranicuZaDodavanjeZaposlenog(Model model) {

        model.addAttribute("noviZaposleni", new EmployeeModel());

        return "dodaj-zaposlenog";
    }

    @RequestMapping(value = "/dodaj-zaposlenog", method = RequestMethod.POST)
    public String dodajZaposlenog(@Valid @ModelAttribute("noviZaposleni") EmployeeModel noviZaposleni,
            BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("hasErrors", true);
            //model.addAttribute("noviZaposleni", employeeModel);

            return "dodaj-zaposlenog";
        } else {
            employeeService.dodajZaposlenog(noviZaposleni);

            return "redirect:/lista-zaposlenih";
        }

    }
    
     @RequestMapping(value = "/lista-zaposlenih", method = RequestMethod.GET)
    public String listajZaposlene(Model model) {

        model.addAttribute("listaZaposlenih", employeeService.listaZaposlenih());

        return "lista-zaposlenih";
    }

    
     @RequestMapping("/promena")
    public String promena(Model model, @RequestParam(required = true) Integer id) {
        
        model.addAttribute("promenjenZaposleni", employeeService.pronadjiZaposlenog(id));
        
        return "promeni-zaposlenog";
        
    }
    
    @RequestMapping(value = "/menjaj-zaposlenog", method = RequestMethod.POST)
   public String menjajZaposlenog(
            @Valid @ModelAttribute("promenjenZaposleni") EmployeeModel promenjenZaposleni,
            BindingResult bindingResult, Model model) {
       
        if (bindingResult.hasErrors()) {
            model.addAttribute("hasErrors", true);
            
            return "promeni-zaposlenog";
        } else {
            employeeService.promeniZaposlenog(promenjenZaposleni);
            
            return "redirect:/lista-zaposlenih";
        }
    }
    
    @RequestMapping("/brisanje")
    public String brisanje(Model model, @RequestParam(required = true) Integer id) {
        
        model.addAttribute("obrisanZaposleni", employeeService.pronadjiZaposlenog(id));
        
        return "obrisi-zaposlenog";
        
    }
    
    @RequestMapping(value = "/brisi-zaposlenog", method = RequestMethod.POST)
   public String obrisiZaposlenog(
            @Valid @ModelAttribute("obrisanZaposleni") EmployeeModel obrisanZaposleni) {
       
            employeeService.obrisiZaposlenog(obrisanZaposleni);
            
            return "redirect:/lista-zaposlenih";
    }
   
   @RequestMapping(value = "/trazi-zaposlenog", method = RequestMethod.POST)
    public String traziZaposlene(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {

        
       
        List<Employee> theEmployees = employeeService.traziZaposlene(theSearchName);
       
        theModel.addAttribute("listaZaposlenih", theEmployees);

        return "lista-zaposlenih";        
    }
   
}
