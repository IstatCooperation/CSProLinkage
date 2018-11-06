/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.istat.cspro.linkage.dao;

import it.istat.cspro.linkage.domain.LinkedRecord;
import it.istat.cspro.linkage.domain.LinkedRecordKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Paolo Giacomi
 */

@Repository
public interface LinkedRecordDao extends JpaRepository <LinkedRecord, LinkedRecordKey> {    
}
