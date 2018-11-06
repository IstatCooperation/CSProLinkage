package it.istat.cspro.linkage.controller;

import it.istat.cspro.linkage.AppStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LinkageController extends BaseController {  
    
    @RequestMapping(value = "/duplicate")
    public String duplicate(Model model) {
        return "linkage/duplicate";
    }    
    
    @RequestMapping(value = "/linkedIndiv")
    public String linkedIndiv(@ModelAttribute("appStatus") AppStatus appStatus) {
        return "linkage/linkedIndiv";
    }               
    
    @RequestMapping(value = "/unlinkedPes")
    public String unlinkedPes() {
        return "linkage/unlinkedPes";
    } 
    
    @RequestMapping(value = "/unlinkedCens")
    public String unlinkedCens() {
        return "linkage/unlinkedCens";
    }      
    
    @RequestMapping(value = "/ea_list")
    public String EASelection() {
        return "linkage/ea_list";
    }          
}
