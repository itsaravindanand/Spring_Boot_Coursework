package com.in28minutes.springboot.myfirstwebapplication.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
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
    public String gotoWelcomeJSP(@RequestParam String name, @RequestParam String password, ModelMap modelMap) {

        //Authentication
        //name: aravind
        //password: password
        //If the input matches these values
        if(authenticateService.authenticate(name, password)){
            modelMap.put("name", name);
            modelMap.put("password", password);
            return "welcome";
        }
        modelMap.put("errorMessage", "Invalid Credentials! Try Again");
        return "login";

    }
}