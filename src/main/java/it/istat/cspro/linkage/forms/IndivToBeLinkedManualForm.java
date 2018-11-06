package it.istat.cspro.linkage.forms;

import it.istat.cspro.linkage.bean.IndividualsToBeLinked;

public class IndivToBeLinkedManualForm {

    private String indiv_quest_A;
    
    private String indiv_quest_B;
    
    private String step;

    public IndivToBeLinkedManualForm() {}

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step + "m";
    }    

    /**
     * individuals to be linked
     * @return 
     */
    public IndividualsToBeLinked getIndivToBeLinkedList() {
        return new IndividualsToBeLinked(indiv_quest_A, indiv_quest_B, step);
    }

    public String getIndiv_quest_A() {
        return indiv_quest_A;
    }

    public void setIndiv_quest_A(String indiv_quest_A) {
        this.indiv_quest_A = indiv_quest_A;
    }

    public String getIndiv_quest_B() {
        return indiv_quest_B;
    }

    public void setIndiv_quest_B(String indiv_quest_B) {
        this.indiv_quest_B = indiv_quest_B;
    }
}
