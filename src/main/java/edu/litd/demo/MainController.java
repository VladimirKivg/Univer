package edu.litd.demo;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class MainController {
   @RequestMapping("/test")
   public String root(Locale locale, ModelMap model) {
       model.addAttribute("content", "helloWorldView");
       return "index";
   }
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name,
                        @RequestParam(value = "surname", defaultValue = "World") String surname)
    {
        return String.format("Hello %s!", name);
    }
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {

        String value=name+name+123;

        model.addAttribute("name", value);
        return "greeting";
    }


}
