package org.courrier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by SimonPascal on 04/17/2016.
 */
@Controller
public class CourrierController {

    @RequestMapping(path = {"/login"},method = RequestMethod.GET)
    public String home(){

        return "login";
    }

    @RequestMapping(path = {"/","/index.html"},method = RequestMethod.GET)
    public String blank(){
        return "index";
    }
}
