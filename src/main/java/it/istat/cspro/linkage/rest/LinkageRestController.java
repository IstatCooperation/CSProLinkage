package it.istat.cspro.linkage.rest;

import it.istat.cspro.linkage.AppStatus;
import it.istat.cspro.linkage.bean.IndividualsToBeLinked;
import it.istat.cspro.linkage.controller.BaseController;
import it.istat.cspro.linkage.domain.LinkageStep;
import it.istat.cspro.linkage.domain.LinkedIndividuals;
import it.istat.cspro.linkage.domain.PESDuplicate;
import it.istat.cspro.linkage.domain.LinkedRecordKey;
import it.istat.cspro.linkage.domain.MatchingVarCens;
import it.istat.cspro.linkage.domain.MatchingVarPes;
import it.istat.cspro.linkage.domain.UserEA;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.istat.cspro.linkage.service.LinkageChecksService;
import it.istat.cspro.linkage.service.LinkageService;
import it.istat.cspro.linkage.service.LinkageStepService;
import it.istat.cspro.linkage.service.UserEaService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class LinkageRestController extends BaseController { 
    @Autowired
    private LinkageStepService linkageStepService;

    @Autowired
    private LinkageChecksService pesChecksService;        
    
    @Autowired
    private LinkageService linkageService;
    
    @Autowired
    private UserEaService userEaService;            

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/linkage/duplicateRecs")
    public List <PESDuplicate> duplicateRecList() {
        return pesChecksService.findAllDuplicate();
    } 

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/linkage/linkedIndQuestAQuestB")
    public Iterable <LinkedIndividuals> allLinkedIndivQuestAQuestB(@RequestParam("idQuestA") String idQuestA, 
            @RequestParam("idQuestB") String idQuestB) {
        return linkageService.findAllLinkedQuestAQuestB(idQuestA, idQuestB);
    }    
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/linkage/allLinkedIndiv")
    public Iterable <LinkedIndividuals> allLinkedIndiv(@ModelAttribute("appStatus") AppStatus appStatus) {
        return linkageService.findLinkedIndivByEaCode(appStatus.getSelEaCod());
    }
    
    @PreAuthorize("hasRole('ADMIN', 'OPERATOR')")
    @RequestMapping(value = "/linkage/allRecStep", method = RequestMethod.POST)
    public Iterable <LinkageStep> allRecStep(@RequestParam("codEA") String codEA, 
            @RequestParam("step") String step) {
        return linkageStepService.findByCodEaAndStep(codEA, step);
    }      
    
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/linkage/unlinkedIndivPes")
    public Iterable <MatchingVarPes> unlinkedIndivPES(@ModelAttribute("appStatus") AppStatus appStatus) {      
        return linkageService.findUnlinkedPes(appStatus.getSelEaCod());
    } 

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/linkage/unlinkedIndivCens")
    public Iterable <MatchingVarCens> unlinkedIndivCENS(@ModelAttribute("appStatus") AppStatus appStatus) {      
        return linkageService.findUnlinkedCens(appStatus.getSelEaCod());
    }     

    
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/linkage/allMatchingVarPesQuest", method = RequestMethod.POST)
    public Iterable <MatchingVarPes> matchingVarPesQuest(@RequestParam("idq") String idQuest) {      
        return linkageService.findMatchingVarPesQuest(idQuest);
    }  
    
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/linkage/allMatchingVarCensQuest", method = RequestMethod.POST)
    public Iterable <MatchingVarCens> matchingVarCensQuest(@RequestParam("idq") String idQuest) {
        return linkageService.findMatchingVarCensQuest(idQuest);
    }
    
    @RequestMapping(value = "/linkage/linkHHIndiv", method = RequestMethod.GET, produces = "application/json")
    public String manLinkageHHIndiv(@ModelAttribute("appStatus") AppStatus appStatus,
            @RequestParam("indiv_quest_A") String idA,
            @RequestParam("indiv_quest_B") String idB,
            @RequestParam("step") String step) {
        this.linkageService.linkIndividuals(new IndividualsToBeLinked (idA, idB, step), appStatus.getSelEaCod());
        return "true";
    }        
    
    @PreAuthorize("hasRole('ADMIN', 'OPERATOR')")
    @RequestMapping(value = "/linkage/refreshEATable")
    public String refreshEATable(@ModelAttribute("appStatus") AppStatus appStatus) {
        this.linkageStepService.refreshEATable(appStatus.getSelEaCod());
        return "true";
    }    
    
    @RequestMapping(value = "/linkage/delLinkedIndiv", method = RequestMethod.GET, produces = "application/json")
    public String delLinkedIndividuals(@RequestParam("idA") String idA,
            @RequestParam("idB") String idB) {
        this.linkageService.deleteLinkedRecord(new LinkedRecordKey(idA, idB));
        return "true";
    }    
    
    @PreAuthorize("hasRole('ADMIN', 'OPERATOR')")
    @RequestMapping(value = "/linkage/ea_list_user", method = RequestMethod.POST, produces = "application/json")
    public Iterable <UserEA> userEaList(@ModelAttribute("appStatus") AppStatus appStatus) {
        return userEaService.findByUserName(appStatus.getUserName());
    }
    
    @PreAuthorize("hasRole('ADMIN', 'OPERATOR')")
    @RequestMapping(value = "/linkage/setEaUser", method = RequestMethod.POST)
    public UserEA setEaUser(@ModelAttribute("appStatus") AppStatus appStatus, 
            @RequestParam("eaCode") String eaCode, 
            @RequestParam("userName") String userName) {
        appStatus.setSelEaCod(eaCode);
        return userEaService.setEaUser(eaCode, userName);
    }
}