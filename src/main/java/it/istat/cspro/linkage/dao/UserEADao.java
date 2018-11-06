package it.istat.cspro.linkage.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.istat.cspro.linkage.domain.UserEA;
import java.util.List;

@Repository
public interface UserEADao extends CrudRepository<UserEA, Long> {
    
    public List <UserEA> findByUserName(String userName);
    
    public UserEA findByUserNameAndEaCod(String userName, String eaCod);
    
}
