package it.istat.cspro.linkage.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.istat.cspro.linkage.dao.UserEADao;
import it.istat.cspro.linkage.domain.UserEA;
import java.util.Iterator;

@Service
@Transactional
public class UserEaService {

    @Autowired
    private UserEADao userEaDao;      
    
    @Autowired
    private LinkageStepService linkageStepService;       

    public List<UserEA> findByUserName(String userName) {
        return (List<UserEA>) this.userEaDao.findByUserName(userName);
    }
    
    public UserEA findByEaCodeAndUserName(String eaCode, String userName) {
        return this.userEaDao.findByUserNameAndEaCod(userName, eaCode);
    }    

    public UserEA setEaUser(String eaCode, String userName) {
        UserEA userEA;
        List <UserEA> userList = this.userEaDao.findByUserName(userName);
        for (Iterator <UserEA> iterator = userList.iterator(); iterator.hasNext();) {
            iterator.next().setSelected(0);
        }
        this.userEaDao.save(userList);            
        userEA = this.userEaDao.findByUserNameAndEaCod(userName, eaCode);
        userEA.setSelected(1);
        this.userEaDao.save(userEA);
        this.linkageStepService.createTableEA(eaCode);
        return userEA;
    }
    
    /**
     * UserEA with "selected = 1" list 
     * @param userName 
     * @return 
     */
    public UserEA findSelectedEA(String userName) {
        UserEA currUserEA, returnUserEA = null;        
        List <UserEA> userList = this.userEaDao.findByUserName(userName);
        if (userList.isEmpty()) {
            return null;
        }
        else {
            for (Iterator <UserEA> iterator = userList.iterator(); iterator.hasNext() && returnUserEA == null;) {
                currUserEA = iterator.next();
                if (currUserEA.getSelected() == 1)
                    returnUserEA = currUserEA;
            }
            if (returnUserEA == null && !userList.isEmpty()) {
                currUserEA = userList.get(0);
                currUserEA.setSelected(1);
                this.userEaDao.save(currUserEA);
                returnUserEA = currUserEA;
            }
        }
        return returnUserEA;
    }
    
    public void delete(UserEA uea) {
        this.userEaDao.delete(uea);
    }
    
    public void save(UserEA uea) {
        this.userEaDao.save(uea);
    }
}
