package org.courrier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by SimonPascal on 04/16/2016.
 */
@Controller
@RequestMapping(path = "/demo")
public class DemoView {
    public static final String PREFIX_FOLDER="demo/";
    @RequestMapping(path = {"/","/index.html"},method = RequestMethod.GET)
    public String home(){
        return PREFIX_FOLDER+"index";
    }
    @RequestMapping(path = {"/blank.html"},method = RequestMethod.GET)
    public String blank(){
        return PREFIX_FOLDER+"blank";
    }
    @RequestMapping(path = {"/buttons.html"},method = RequestMethod.GET)
    public String buttons(){
        return PREFIX_FOLDER+"buttons";
    }
    @RequestMapping(path = {"/flot.html"},method = RequestMethod.GET)
    public String flot(){
        return PREFIX_FOLDER+"flot";
    }
    @RequestMapping(path = {"/forms.html"},method = RequestMethod.GET)
    public String forms(){
        return PREFIX_FOLDER+"forms";
    }
    @RequestMapping(path = {"/grid.html"},method = RequestMethod.GET)
    public String grid(){
        return PREFIX_FOLDER+"grid";
    }
    @RequestMapping(path = {"/icons.html"},method = RequestMethod.GET)
    public String icons(){
        return PREFIX_FOLDER+"icons";
    }
    @RequestMapping(path = {"/login.html"},method = RequestMethod.GET)
    public String login(){
        return PREFIX_FOLDER+"login";
    }
    @RequestMapping(path = {"/morris.html"},method = RequestMethod.GET)
    public String morris(){
        return PREFIX_FOLDER+"morris";
    }
    @RequestMapping(path = {"/notifications.html"},method = RequestMethod.GET)
    public String notifications(){
        return PREFIX_FOLDER+"notifications";
    }
    @RequestMapping(path = {"/panels.html"},method = RequestMethod.GET)
    public String panels(){
        return PREFIX_FOLDER+"panels";
    }
    @RequestMapping(path = {"/tables.html"},method = RequestMethod.GET)
    public String tables(){
        return PREFIX_FOLDER+"tables";
    }
    @RequestMapping(path = {"/typography.html"},method = RequestMethod.GET)
    public String typography(){
        return PREFIX_FOLDER+"typography";
    }

    @RequestMapping(path = {"/panels-wells.html"},method = RequestMethod.GET)
    public String panelsWells(){
        return PREFIX_FOLDER+"panels-wells";
    }
}
