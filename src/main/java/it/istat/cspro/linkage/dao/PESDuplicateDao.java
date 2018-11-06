package it.istat.cspro.linkage.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.istat.cspro.linkage.domain.PESDuplicate;

@Repository
public interface PESDuplicateDao extends CrudRepository<PESDuplicate, Long> { 
    
}
