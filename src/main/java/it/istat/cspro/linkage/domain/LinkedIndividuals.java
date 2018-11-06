package it.istat.cspro.linkage.domain;
import it.istat.cspro.linkage.utils.ObjectIDGenerator;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author giacomi
 */
@Entity
@Table (name = "linked_individual")
public class LinkedIndividuals implements Serializable {

    @Id    
    private LinkedIndividualKey id;
    
    @Column(name = "PES_ID_QUEST")
    private String idQuestA;  
    
    @Column(name = "PES_NAME1")
    private String name1A;                
    
    @Column(name = "PES_NAME2")
    private String name2A;
    
    @Column(name = "PES_NAME3")
    private String name3A;    
    
    @Column(name = "PES_AGE")
    private String ageA;                    

    @Column(name = "PES_SEX")
    private String sexA;
    
    @Column(name = "PES_RELIGION")
    private String religionA;    
    
    @Column(name = "PES_RELAT")
    private String relatA;

    @Column(name = "PES_GRADE")
    private String gradeA;    
    
    @Column(name = "PeS_ETHNIC")
    private String ethnicA;
    
    @Column(name = "PES_MARITAL")
    private String maritalA;    
    
    @Column(name = "CENS_ID_QUEST")
    private String idQuestB;    
    
    @Column(name = "CENS_NAME1")
    private String name1B;                
    
    @Column(name = "CENS_NAME2")
    private String name2B;
    
    @Column(name = "CENS_NAME3")
    private String name3B;    
    
    @Column(name = "CENS_AGE")
    private String ageB;                    

    @Column(name = "CENS_SEX")
    private String sexB;
    
    @Column(name = "CENS_RELIGION")
    private String religionB;    
    
    @Column(name = "CENS_RELAT")
    private String relatB;

    @Column(name = "CENS_GRADE")
    private String gradeB;    
    
    @Column(name = "CENS_ETHNIC")
    private String ethnicB;
    
    @Column(name = "CENS_MARITAL")
    private String maritalB; 
    
    @Column(name = "STEP")    
    private String step;
    
    @Column(name = "EA_CODE")    
    private String eaCode;    
    
            
    public LinkedIndividuals() {}

    public String getEaCode() {return eaCode;}

    public void setEaCode(String eaCode) {this.eaCode = eaCode;}        

    public String getIdIndividualA() {return id.getIdIndividualA();}

    public String getIdQuestA() {return this.idQuestA;}

    public void setIdQuestA(String idQuestA) {this.idQuestA = idQuestA;}        

    public String getName1A() {return name1A;}

    public void setName1A(String name1A) {this.name1A = name1A;}

    public String getName2A() {return name2A;}

    public void setName2A(String name2A) {this.name2A = name2A;}

    public String getName3A() {return name3A;}

    public void setName3A(String name3A) {this.name3A = name3A;}

    public String getAgeA() {return ageA;}

    public void setAgeA(String ageA) {this.ageA = ageA;}

    public String getSexA() {return sexA;}

    public void setSexA(String sexA) {this.sexA = sexA;}

    public String getReligionA() {return religionA;}

    public void setReligionA(String religionA) {this.religionA = religionA;}

    public String getRelatA() {return relatA;}

    public void setRelatA(String relatA) {this.relatA = relatA;}

    public String getGradeA() {return gradeA;}

    public void setGradeA(String gradeA) {this.gradeA = gradeA;}

    public String getEthnicA() {return ethnicA;}

    public void setEthnicA(String ethnicA) {this.ethnicA = ethnicA;}

    public String getMaritalA() {return maritalA;}

    public void setMaritalA(String maritalA) {this.maritalA = maritalA;}

    public String getIdIndividualB() {return id.getIdIndividualB();}

    public String getIdQuestB() {return this.idQuestB;}

    public void setIdQuestB(String idQuestB) {this.idQuestB = idQuestB;}

    public String getName1B() {return name1B;}

    public void setName1B(String name1B) {this.name1B = name1B;}

    public String getName2B() {return name2B;}

    public void setName2B(String name2B) {this.name2B = name2B;}

    public String getName3B() {return name3B;}

    public void setName3B(String name3B) {this.name3B = name3B;}

    public String getAgeB() {return ageB;}

    public void setAgeB(String ageB) {this.ageB = ageB;}

    public String getSexB() {return sexB;}

    public void setSexB(String sexB) {this.sexB = sexB;}

    public String getReligionB() {return religionB;}

    public void setReligionB(String religionB) {this.religionB = religionB;}

    public String getRelatB() {return relatB;}

    public void setRelatB(String relatB) {this.relatB = relatB;}

    public String getGradeB() {return gradeB;}

    public void setGradeB(String gradeB) {this.gradeB = gradeB;}

    public String getEthnicB() {return ethnicB;}

    public void setEthnicB(String ethnicB) {this.ethnicB = ethnicB;}

    public String getMaritalB() {return maritalB;}

    public void setMaritalB(String maritalB) {this.maritalB = maritalB;}
    
    public String getFullNameA() {
        return this.name1A + " " + this.name2A + " " + this.name3A;
    }
    
    public String getFullNameB() {
        return this.name1B + " " + this.name2B + " " + this.name3B;                      
    }  

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }    
    
    public String getLinkageCod() {
        return id.getIdIndividualA() + "_" + this.idQuestA + "#" +
                id.getIdIndividualB() + "_" + this.idQuestB;
    }
    
    public String getLinkageIndiv() {
        return id.getIdIndividualA() + "_" + id.getIdIndividualB();
    }    
    
    public String getQuestionariesID() {
        return ObjectIDGenerator.getQuestionariesID(this.idQuestA, this.idQuestB);
    }        
}
