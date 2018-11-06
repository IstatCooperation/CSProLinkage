/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.istat.cspro.linkage.service;

import it.istat.cspro.linkage.dao.LinkageStepDao;
import it.istat.cspro.linkage.domain.LinkageStep;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Paolo Giacomi
 */
@Service
public class LinkageStepService {

    @Autowired
    LinkageStepDao linkageStepDao;

    public LinkageStepService() {}
                
    public List <LinkageStep> findByCodEaAndStep(String codEa, String step) {
        return (List <LinkageStep>) linkageStepDao.findByCodEaAndStep(codEa, step);
    }
    
    public void initStep(String userName, String eaCode, String step) {
        linkageStepDao.initializeStep(userName, eaCode, step);
    }
    
    public void refreshEATable(String eaCode) {
        linkageStepDao.refreshNumUnlinked(eaCode);
    }    
    
    public void createTableEA(String eaCode) {
        linkageStepDao.createTableEA(eaCode);
    }
}
