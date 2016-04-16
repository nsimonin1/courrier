package org.courrier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by SimonPascal on 04/16/2016.
 */
@Controller
@RequestMapping
public class HomeView {

    @RequestMapping(path = {"/","/index.html"},method = RequestMethod.GET)
    public String home(){
        return "index";
    }
    @RequestMapping(path = {"/blank.html"},method = RequestMethod.GET)
    public String blank(){
        return "blank";
    }
    @RequestMapping(path = {"/buttons.html"},method = RequestMethod.GET)
    public String buttons(){
        return "buttons";
    }
    @RequestMapping(path = {"/flot.html"},method = RequestMethod.GET)
    public String flot(){
        return "flot";
    }
    @RequestMapping(path = {"/forms.html"},method = RequestMethod.GET)
    public String forms(){
        return "forms";
    }
    @RequestMapping(path = {"/grid.html"},method = RequestMethod.GET)
    public String grid(){
        return "grid";
    }
    @RequestMapping(path = {"/icons.html"},method = RequestMethod.GET)
    public String icons(){
        return "icons";
    }
    @RequestMapping(path = {"/login.html"},method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    @RequestMapping(path = {"/morris.html"},method = RequestMethod.GET)
    public String morris(){
        return "morris";
    }
    @RequestMapping(path = {"/notifications.html"},method = RequestMethod.GET)
    public String notifications(){
        return "notifications";
    }
    @RequestMapping(path = {"/panels.html"},method = RequestMethod.GET)
    public String panels(){
        return "panels";
    }
    @RequestMapping(path = {"/tables.html"},method = RequestMethod.GET)
    public String tables(){
        return "tables";
    }
    @RequestMapping(path = {"/typography.html"},method = RequestMethod.GET)
    public String typography(){
        return "typography";
    }

    @RequestMapping(path = {"/panels-wells.html"},method = RequestMethod.GET)
    public String panelsWells(){
        return "panels-wells";
    }
}
