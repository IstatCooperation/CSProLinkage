/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.istat.cspro.linkage.dao;

import it.istat.cspro.linkage.domain.MatchingVarCens;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Paolo Giacomi
 */

@Repository
public interface MatchingVarCensDao extends JpaRepository <MatchingVarCens, String> {   
    
    @Query("SELECT m FROM MatchingVarCens m WHERE m.idQuest = :idQuest "
            + "and m.idIndividual not in (select lr.id.idIndividualB from LinkedRecord lr)")    
    public List <MatchingVarCens> findByIdQuest(@Param("idQuest") String idQuest);
    
     @Query("SELECT m FROM MatchingVarCens m " + 
            " WHERE cod_ea = :eaCode" +              
            " AND m.idIndividual not in (select lr.id.idIndividualB from LinkedRecord lr)")
    public List <MatchingVarCens> findUnlinked(@Param("eaCode") String eaCode);    
    
    @Query("SELECT count(m) FROM MatchingVarCens m WHERE m.idQuest = :idQuest "
            + "and m.idIndividual not in (select lr.id.idIndividualB from LinkedRecord lr)")    
    public int countByIdQuest(@Param("idQuest") String idQuest);
}
