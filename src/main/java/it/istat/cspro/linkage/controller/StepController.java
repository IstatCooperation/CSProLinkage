package it.istat.cspro.linkage.controller;

import it.istat.cspro.linkage.AppStatus;
import it.istat.cspro.linkage.forms.IndivToBeLinkedForm;
import it.istat.cspro.linkage.service.LinkageInfoService;
import it.istat.cspro.linkage.service.LinkageStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class StepController extends BaseController {  
    
    @Autowired
    LinkageStepService linkageStepService;
    
    @Autowired
    private LinkageInfoService linkageInfoService;       
    
    
    @PreAuthorize("hasRole('ADMIN', 'OPERATOR')")
    @RequestMapping(value = "/initStep1")
    public String initLinkageStep1(@ModelAttribute("appStatus") AppStatus appStatus) {
        this.linkageStepService.initStep(appStatus.getUserName(), appStatus.getSelEaCod(), "1");
        return "linkage/step_1";
    }    

    @PreAuthorize("hasRole('ADMIN', 'OPERATOR')")
    @RequestMapping(value = "/initStep2")
    public String initLinkageStep2(@ModelAttribute("appStatus") AppStatus appStatus) {
        this.linkageStepService.initStep(appStatus.getUserName(), appStatus.getSelEaCod(), "2");
        return "linkage/step_2";
    }

    @PreAuthorize("hasRole('ADMIN', 'OPERATOR')")
    @RequestMapping(value = "/initStep3")
    public String initLinkageStep3(@ModelAttribute("appStatus") AppStatus appStatus) {
        this.linkageStepService.initStep(appStatus.getUserName(), appStatus.getSelEaCod(), "3");
        return "linkage/step_3";
    }     

    @PreAuthorize("hasRole('ADMIN', 'OPERATOR')")
    @RequestMapping(value = "/initStep4")
    public String initLinkageStep4(@ModelAttribute("appStatus") AppStatus appStatus) {
        this.linkageStepService.initStep(appStatus.getUserName(), appStatus.getSelEaCod(), "4");
        return "linkage/step_4";
    }  

    @PreAuthorize("hasRole('ADMIN', 'OPERATOR')")
    @RequestMapping(value = "/initStep5")
    public String initLinkageStep5(@ModelAttribute("appStatus") AppStatus appStatus) {
        this.linkageStepService.initStep(appStatus.getUserName(), appStatus.getSelEaCod(), "5");
        return "linkage/step_5";
    }   

    @PreAuthorize("hasRole('ADMIN', 'OPERATOR')")
    @RequestMapping(value = "/initStep6")
    public String initLinkageStep6(@ModelAttribute("appStatus") AppStatus appStatus) {
        this.linkageStepService.initStep(appStatus.getUserName(), appStatus.getSelEaCod(), "6");
        return "linkage/step_6";
    }
    
    @PreAuthorize("hasRole('ADMIN', 'OPERATOR')")
    @RequestMapping(value = "/initStep7")
    public String initLinkageStep7(@ModelAttribute("appStatus") AppStatus appStatus) {
        this.linkageStepService.initStep(appStatus.getUserName(), appStatus.getSelEaCod(), "7");
        return "linkage/step_7";
    }
    
    @PreAuthorize("hasRole('ADMIN', 'OPERATOR')")
    @RequestMapping(value = "/initStep8")
    public String initLinkageStep8(@ModelAttribute("appStatus") AppStatus appStatus) {
        this.linkageStepService.initStep(appStatus.getUserName(), appStatus.getSelEaCod(), "8");
        return "linkage/step_8";
    } 
    
    @PreAuthorize("hasRole('ADMIN', 'OPERATOR')")
    @RequestMapping(value = "/initStep9")
    public String initLinkageStep9(@ModelAttribute("appStatus") AppStatus appStatus) {
        this.linkageStepService.initStep(appStatus.getUserName(), appStatus.getSelEaCod(), "9");
        return "linkage/step_9";
    }   
    
    @PreAuthorize("hasRole('ADMIN', 'OPERATOR')")
    @RequestMapping(value = "/initStep10")
    public String initLinkageStep10(@ModelAttribute("appStatus") AppStatus appStatus) {
        this.linkageStepService.initStep(appStatus.getUserName(), appStatus.getSelEaCod(), "10");
        return "linkage/step_10";
    }     

    @PreAuthorize("hasRole('ADMIN', 'OPERATOR')")
    @RequestMapping(value = "/step1")
    public String manLinkageStep1(@ModelAttribute("appStatus") AppStatus appStatus) {
        return "linkage/step_1";
    }
    
    @PreAuthorize("hasRole('ADMIN', 'OPERATOR')")    
    @RequestMapping(value = "/step2")
    public String manLinkageStep2(Model model) {
        return "linkage/step_2";
    }    

    @PreAuthorize("hasRole('ADMIN', 'OPERATOR')")
    @RequestMapping(value = "/step3")
    public String manLinkageStep3(Model model) {
        return "linkage/step_3";
    }    

    
    @PreAuthorize("hasRole('ADMIN', 'OPERATOR')")
    @RequestMapping(value = "/step4")
    public String manLinkageStep4(Model model) {
        return "linkage/step_4";
    }      

    @PreAuthorize("hasRole('ADMIN', 'OPERATOR')")
    @RequestMapping(value = "/step5", method=RequestMethod.GET)
    public String manLinkageStep5(Model model) {
        return "linkage/step_5";
    }    

    @PreAuthorize("hasRole('ADMIN', 'OPERATOR')")    
    @RequestMapping(value = "/step6", method=RequestMethod.GET)
    public String manLinkageStep6(@ModelAttribute IndivToBeLinkedForm indToBeLinked, Model model) {
        return "linkage/step_6";
    } 
    
    @PreAuthorize("hasRole('ADMIN', 'OPERATOR')")    
    @RequestMapping(value = "/step7", method=RequestMethod.GET)
    public String manLinkageStep7(@ModelAttribute IndivToBeLinkedForm indToBeLinked, Model model) {
        return "linkage/step_7";
    } 
    
    @PreAuthorize("hasRole('ADMIN', 'OPERATOR')")    
    @RequestMapping(value = "/step8", method=RequestMethod.GET)
    public String manLinkageStep8(@ModelAttribute IndivToBeLinkedForm indToBeLinked, Model model) {
        return "linkage/step_8";
    }  
    
    @PreAuthorize("hasRole('ADMIN', 'OPERATOR')")    
    @RequestMapping(value = "/step9", method=RequestMethod.GET)
    public String manLinkageStep9(@ModelAttribute IndivToBeLinkedForm indToBeLinked, Model model) {
        return "linkage/step_9";
    } 
    
    @PreAuthorize("hasRole('ADMIN', 'OPERATOR')")    
    @RequestMapping(value = "/step10", method=RequestMethod.GET)
    public String manLinkageStep10(@ModelAttribute IndivToBeLinkedForm indToBeLinked, Model model) {
        return "linkage/step_10";
    }    
    
    @PreAuthorize("hasRole('ADMIN', 'OPERATOR')")
    @RequestMapping(value = "/start")
    public String initLinkageLinkage(Model model, 
            @ModelAttribute("appStatus") AppStatus appStatus) {
        String last_step = this.linkageInfoService.getInfoLastStep(appStatus.getSelEaCod()).getValue();
        model.addAttribute("codEA", appStatus.getSelEaCod());
        if (last_step.trim().equals("0"))
            //return "/initStep1";
            return "linkage/step_1";
        else
            return "linkage/step_" + last_step;
    }      
}
