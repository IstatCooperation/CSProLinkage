package it.istat.cspro.linkage.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author giacomi
 */
@Entity
@Table(name = "linked_record")
public class LinkedRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private LinkedRecordKey id;    
    
    @Column(name = "ID_QUEST_PES")
    private String idQuestA;
    
    @Column(name = "ID_QUEST_CENS")
    private String idQuestB;    
    
    @Column(name = "LINKAGE_STEP")
    private String step;
    
    @Column(name = "EA_CODE")
    private String eaCode;

    public LinkedRecord(LinkedRecordKey id, 
            String idQuestA, 
            String idQuestB, 
            String step,
            String eaCode) {
        this.id = id;
        this.idQuestA = idQuestA;
        this.idQuestB = idQuestB;
        this.step = step;
        this.eaCode = eaCode;
    }

    public LinkedRecord() {
    }
    
    

    public LinkedRecordKey getId() {
        return id;
    }

    public void setId(LinkedRecordKey id) {
        this.id = id;
    }

    public String getIdQuestA() {
        return idQuestA;
    }

    public void setIdQuestA(String idQuestA) {
        this.idQuestA = idQuestA;
    }

    public String getIdQuestB() {
        return idQuestB;
    }

    public void setIdQuestB(String idQuestB) {
        this.idQuestB = idQuestB;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }
    
    public String getIdIndividualA() {
        return this.id.getIdIndividualA();
    }
    
    public String getIdIndividualB() {
        return this.id.getIdIndividualB();
    }    

    public String getEaCode() {
        return eaCode;
    }

    public void setEaCode(String eaCode) {
        this.eaCode = eaCode;
    }
    
}
