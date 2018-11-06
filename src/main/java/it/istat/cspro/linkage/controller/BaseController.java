package it.istat.cspro.linkage.controller;

import it.istat.cspro.linkage.AppStatus;
import it.istat.cspro.linkage.domain.UserEA;
import it.istat.cspro.linkage.service.UserEaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("appStatus")
public class BaseController {    
    @Autowired UserEaService userEaService;
    
    @ModelAttribute("appStatus")
    public AppStatus getAppStatus() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();
        UserEA userEA = userEaService.findSelectedEA(userDetail.getUsername());
        String selEaCode = (userEA != null ? userEA.getEaCod() : "");
        return new AppStatus(selEaCode, userDetail.getUsername());
    }           
}
