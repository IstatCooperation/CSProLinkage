package it.istat.cspro.linkage.service;

import it.istat.cspro.linkage.bean.IndividualsToBeLinked;
import it.istat.cspro.linkage.dao.LinkedIndividualsDao;
import it.istat.cspro.linkage.dao.LinkedRecordDao;
import it.istat.cspro.linkage.dao.MatchingVarCensDao;
import it.istat.cspro.linkage.dao.MatchingVarPesDao;
import it.istat.cspro.linkage.domain.LinkedIndividuals;
import org.springframework.stereotype.Service;
import it.istat.cspro.linkage.domain.LinkedRecord;
import it.istat.cspro.linkage.domain.LinkedRecordKey;
import it.istat.cspro.linkage.domain.MatchingVarCens;
import it.istat.cspro.linkage.domain.MatchingVarPes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LinkageService {       

    @Autowired
    LinkedIndividualsDao linkedIndivAutoDao;    
    
    @Autowired
    LinkedRecordDao linkedRecordDao;
    
    @Autowired
    MatchingVarPesDao matchVarPesDao;
    
    @Autowired
    MatchingVarCensDao matchVarCensDao;    
    
   
    public LinkageService () {
    }    
    
    public List <LinkedIndividuals> findLinkedIndivByEaCode(String selEaCod) {
        return (List <LinkedIndividuals>)linkedIndivAutoDao.findByEaCode(selEaCod);
    }
    
    public List <LinkedIndividuals> findAllLinkedQuestAQuestB(String idQuestA, String idQuestB) {
        return (List <LinkedIndividuals>)linkedIndivAutoDao.findByIdQuestAAndIdQuestB(idQuestA, idQuestB);
    }   
    
    public List <MatchingVarPes> findMatchingVarPesQuest(String idQuest) {        
        return (List <MatchingVarPes>) this.matchVarPesDao.findByIdQuest(idQuest);
    }
    
    public List <MatchingVarPes> findUnlinkedPes(String eaCode) {        
        return (List <MatchingVarPes>) this.matchVarPesDao.findUnlinked(eaCode);
    }    
    
    public List <MatchingVarCens> findUnlinkedCens(String eaCode) {        
        return (List <MatchingVarCens>) this.matchVarCensDao.findUnlinked(eaCode);
    }     
    
    public List <MatchingVarCens> findMatchingVarCensQuest(String idQuest) {        
        return (List <MatchingVarCens>) this.matchVarCensDao.findByIdQuest(idQuest);
    }      

    @Transactional
    public void linkIndividuals(IndividualsToBeLinked indList, String selEaCode) {        
        //Insert new linkage record
        LinkedRecordKey lrk = new LinkedRecordKey(indList.getIdIndividualA(), 
                indList.getIdIndividualB());        
        LinkedRecord lnkRec = new LinkedRecord(lrk, 
                indList.getIdQuestA(), 
                indList.getIdQuestB(), 
                indList.getStep(),
                selEaCode);
        this.linkedRecordDao.save(lnkRec);                     
    }          
    
    public  void deleteLinkedRecord(LinkedRecordKey liKey) {
        LinkedRecord lr = this.linkedRecordDao.findOne(liKey);
        if (!lr.getStep().equals("0"))
            this.linkedRecordDao.delete(liKey);
    }
}

