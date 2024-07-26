package com.in28minutes.springboot.myfirstwebapplication.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
    //You can autowire or use Constructor
    //@Autowired
    private AuthenticationService authenticateService;

    //Constructor based dependency injection
    public LoginController(AuthenticationService authenticateService) {
        super();
        this.authenticateService = authenticateService;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String gotoLoginJSP() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String gotoWelcomeJSP(@RequestParam String name, @RequestParam String password, ModelMap model) {

        //Authentication
        //name: aravind
        //password: password
        //If the input matches these values
        if(authenticateService.authenticate(name, password)){
            model.put("name", name);
            //model.put("password", password);
            return "welcome";
        }
        model.put("errorMessage", "Invalid Credentials! Try Again");
        return "login";

    }
}
