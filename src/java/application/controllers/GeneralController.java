package application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Srdjan
 */

  
@Controller
public class GeneralController {
    
    @RequestMapping({"/home", "/"})
    public String home() {
        return "index";
    }
    
    @RequestMapping("/about")
    public String about() {
        return "about";
    }
    
    @RequestMapping("/lista-zaposlenih")
    public String listaZaposlenih() {
        return "lista-zaposlenih";
    }
    
    @RequestMapping("/timeClock")
    public String timeClock() {
        return "timeClock";
    }
}
