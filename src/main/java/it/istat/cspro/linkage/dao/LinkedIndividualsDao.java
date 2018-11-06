/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.istat.cspro.linkage.dao;

import it.istat.cspro.linkage.domain.LinkedIndividualKey;
import it.istat.cspro.linkage.domain.LinkedIndividuals;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Paolo Giacomi
 */

@Repository
public interface LinkedIndividualsDao extends JpaRepository <LinkedIndividuals, LinkedIndividualKey> {    
    public List <LinkedIndividuals> findByIdQuestAAndIdQuestB(String idQuestA, String idQuestB);
    
    public List <LinkedIndividuals> findByEaCode(String eaCode);    
}
