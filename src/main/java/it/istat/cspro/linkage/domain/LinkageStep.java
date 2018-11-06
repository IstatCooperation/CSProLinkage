package it.istat.cspro.linkage.domain;

import java.io.Serializable;

/**
 *
 * @author Paolo Giacomi
 */
public class LinkageStep implements Serializable {
    
    private String idIndividualA;
    
    private String idIndividualB;    
    
    private String idQuestA;  
    
    private String name1A;                
    
    private String name2A;
    
    private String name3A;    
    
    private String ageA;                    

    private String sexA;
    
    private String religionA;    
    
    private String relatA;

    private String gradeA;    
    
    private String ethnicA;
    
    private String maritalA;    
    
    private String idQuestB;    
    
    private String name1B;                
    
    private String name2B;
    
    private String name3B;    
    
    private String ageB;                    

    private String sexB;
    
    private String religionB;    
    
    private String relatB;

    private String gradeB;    
    
    private String ethnicB;
    
    private String maritalB;           
    
    private String eaCode;
    
    private int unlinkedQuestA;
    
    private int unlinkedQuestB;
    
            
    public LinkageStep() {}  

    public int getUnlinkedQuestA() {
        return unlinkedQuestA;
    }

    public void setUnlinkedQuestA(int unlinkedQuestA) {
        this.unlinkedQuestA = unlinkedQuestA;
    }

    public int getUnlinkedQuestB() {
        return unlinkedQuestB;
    }

    public void setUnlinkedQuestB(int unlinkedQuestB) {
        this.unlinkedQuestB = unlinkedQuestB;
    }    
    
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
    
    

    public String getIdQuestA() {
        return idQuestA;
    }

    public void setIdQuestA(String idQuestA) {
        this.idQuestA = idQuestA;
    }

    public String getName1A() {
        return name1A;
    }

    public void setName1A(String name1A) {
        this.name1A = name1A;
    }

    public String getName2A() {
        return name2A;
    }

    public void setName2A(String name2A) {
        this.name2A = name2A;
    }

    public String getName3A() {
        return name3A;
    }

    public void setName3A(String name3A) {
        this.name3A = name3A;
    }

    public String getAgeA() {
        return ageA;
    }

    public void setAgeA(String ageA) {
        this.ageA = ageA;
    }

    public String getSexA() {
        return sexA;
    }

    public void setSexA(String sexA) {
        this.sexA = sexA;
    }

    public String getReligionA() {
        return religionA;
    }

    public void setReligionA(String religionA) {
        this.religionA = religionA;
    }

    public String getRelatA() {
        return relatA;
    }

    public void setRelatA(String relatA) {
        this.relatA = relatA;
    }

    public String getGradeA() {
        return gradeA;
    }

    public void setGradeA(String gradeA) {
        this.gradeA = gradeA;
    }

    public String getEthnicA() {
        return ethnicA;
    }

    public void setEthnicA(String ethnicA) {
        this.ethnicA = ethnicA;
    }

    public String getMaritalA() {
        return maritalA;
    }

    public void setMaritalA(String maritalA) {
        this.maritalA = maritalA;
    }

    public String getIdQuestB() {
        return idQuestB;
    }

    public void setIdQuestB(String idQuestB) {
        this.idQuestB = idQuestB;
    }

    public String getName1B() {
        return name1B;
    }

    public void setName1B(String name1B) {
        this.name1B = name1B;
    }

    public String getName2B() {
        return name2B;
    }

    public void setName2B(String name2B) {
        this.name2B = name2B;
    }

    public String getName3B() {
        return name3B;
    }

    public void setName3B(String name3B) {
        this.name3B = name3B;
    }

    public String getAgeB() {
        return ageB;
    }

    public void setAgeB(String ageB) {
        this.ageB = ageB;
    }

    public String getSexB() {
        return sexB;
    }

    public void setSexB(String sexB) {
        this.sexB = sexB;
    }

    public String getReligionB() {
        return religionB;
    }

    public void setReligionB(String religionB) {
        this.religionB = religionB;
    }

    public String getRelatB() {
        return relatB;
    }

    public void setRelatB(String relatB) {
        this.relatB = relatB;
    }

    public String getGradeB() {
        return gradeB;
    }

    public void setGradeB(String gradeB) {
        this.gradeB = gradeB;
    }

    public String getEthnicB() {
        return ethnicB;
    }

    public void setEthnicB(String ethnicB) {
        this.ethnicB = ethnicB;
    }

    public String getMaritalB() {
        return maritalB;
    }

    public void setMaritalB(String maritalB) {
        this.maritalB = maritalB;
    }

    public String getEaCode() {
        return eaCode;
    }

    public void setCodEaCode(String eaCode) {
        this.eaCode = eaCode;
    }    
    
    public String getLinkageCod() {
        return this.getIdIndividualA() + "_" + this.idQuestA + "#" +
                this.getIdIndividualB() + "_" + this.idQuestB;
    }
    
    public String getLinkageIndiv() {
        return this.getIdIndividualA() + "_" + this.getIdIndividualB();
    }    
    
    public String getFullNameA() {
        return this.name1A + " " + this.name2A + " " + this.name3A;
    }
    
    public String getFullNameB() {
        return this.name1B + " " + this.name2B + " " + this.name3B;                      
    }
}
