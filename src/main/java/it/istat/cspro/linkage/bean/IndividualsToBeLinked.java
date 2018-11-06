/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.istat.cspro.linkage.bean;

/**
 *
 * @author Paolo Giacomi
 */
public class IndividualsToBeLinked {
    
    String idIndividualA;
    
    String idQuestA;
    
    String idIndividualB;
    
    String idQuestB;
    
    String step;

    public IndividualsToBeLinked(String idIndividualA, 
            String idQuestA, 
            String idIndividualB, 
            String idQuestB,
            String step) {
        this.idIndividualA = idIndividualA;
        this.idQuestA = idQuestA;
        this.idIndividualB = idIndividualB;
        this.idQuestB = idQuestB;
        this.step = step;
    }

    /**
     * @param indToBeLinkEncoded string containing idA, idB, idQuestA, idQuestB
     * es. 2768_689#12405_3080
     */
    public IndividualsToBeLinked(String indToBeLinkEncoded, String step) {
        String part [] = indToBeLinkEncoded.split("#");
        String indA [] = part[0].split("_");
        String indB [] = part[1].split("_");
        this.idIndividualA = indA[0];
        this.idQuestA = indA[1];
        this.idIndividualB = indB[0];
        this.idQuestB = indA[1];
        this.step = step;
    }
    
    /**
     * 
     * @param indToBeLinkEncodedA string containing indiv A es: 2768_689
     * @param indToBeLinkEncodedB string containing indiv B
     * @param step 
     */
    public IndividualsToBeLinked(String indToBeLinkEncodedA, String indToBeLinkEncodedB, String step) {
        String [] indivA = indToBeLinkEncodedA.split("_");
        String [] indivdB = indToBeLinkEncodedB.split("_");
        this.idIndividualA = indivA[0];
        this.idQuestA = indivA[1];
        this.idIndividualB = indivdB[0];
        this.idQuestB = indivdB[1];
        this.step = step;
    }    

    public String getStep() {
        return step;
    }

    
    
    public String getIdIndividualA() {
        return idIndividualA;
    }

    public String getIdQuestA() {
        return idQuestA;
    }

    public String getIdIndividualB() {
        return idIndividualB;
    }

    public String getIdQuestB() {
        return idQuestB;
    }
    
}
