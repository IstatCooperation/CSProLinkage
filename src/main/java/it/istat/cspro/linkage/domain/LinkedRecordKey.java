/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.istat.cspro.linkage.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Paolo Giacomi
 */
@Embeddable
public class LinkedRecordKey implements Serializable {
    @Column(name = "ID_INDIVIDUAL_PES")
    private String idIndividualA;    
    
    @Column(name = "ID_INDIVIDUAL_CENS")
    private String idIndividualB;

    public LinkedRecordKey(String idIndividualA, String idIndividualB) {
        this.idIndividualA = idIndividualA;
        this.idIndividualB = idIndividualB;
    }

    public LinkedRecordKey() {}
    
    

    public String getIdIndividualA() {
        return idIndividualA;
    }

    public void setIdIndividualA(String idIndividualA) {
        this.idIndividualA = idIndividualA;
    }

    public String getIdIndividualB() {
        return idIndividualB;
    }

    public void setIdIndividualB(String idIndividualB) {
        this.idIndividualB = idIndividualB;
    }    
}
