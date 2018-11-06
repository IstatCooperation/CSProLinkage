package it.istat.cspro.linkage.service;

import it.istat.cspro.linkage.dao.LinkageInfoDao;
import it.istat.cspro.linkage.domain.LinkageInfo;
import it.istat.cspro.linkage.domain.LinkageInfoKey;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class LinkageInfoService {     
    private final static String LAST_STEP = "last_step";

    @Autowired
    LinkageInfoDao linkageinfoDao;    
       
    public LinkageInfo getInfoLastStep(String eaCode) {        
        LinkageInfo linkInfo = linkageinfoDao.findOne(new LinkageInfoKey(LAST_STEP, eaCode));
        // if linkInfo doesn't exists create a new entry with step = "0"
        if (linkInfo == null) {
            linkInfo = new LinkageInfo(new LinkageInfoKey(LAST_STEP, eaCode), "0", "");
            linkageinfoDao.save(linkInfo);
        }
        return linkInfo;
    }    
}

