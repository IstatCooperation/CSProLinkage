package it.istat.cspro.linkage.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.istat.cspro.linkage.dao.PESDuplicateDao;
import it.istat.cspro.linkage.domain.PESDuplicate;

@Service
@Transactional
public class LinkageChecksService {

    @Autowired
    private PESDuplicateDao pesDuplicateDao;

    public List<PESDuplicate> findAllDuplicate() {
        return (List<PESDuplicate>) this.pesDuplicateDao.findAll();
    }

    public PESDuplicate findOne(Long id) {
        return this.pesDuplicateDao.findOne(id);
    }

}
