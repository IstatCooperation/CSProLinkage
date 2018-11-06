package it.istat.cspro.linkage.forms;

import it.istat.cspro.linkage.bean.IndividualsToBeLinked;

public class IndivToBeLinkedForm {

    private String [] indToBeLink;
    
    private String step;

    public IndivToBeLinkedForm() {}

    public String[] getIndToBeLink() {
        return indToBeLink;
    }

    public void setIndToBeLink(String[] indToBeLink) {
        this.indToBeLink = indToBeLink;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }    

    /**
     * individuals to be linked
     * @return 
     */
    public IndividualsToBeLinked [] getIndivToBeLinkedList() {
        IndividualsToBeLinked [] indList;
        if (this.indToBeLink == null) {
            indList = new IndividualsToBeLinked[0];
        }
        else {
            indList = new IndividualsToBeLinked[indToBeLink.length];
            for (int i = 0; i < indList.length; i++) {
                indList[i] = new IndividualsToBeLinked(indToBeLink[i], step);
            }
        }
        return indList;
    }
}
