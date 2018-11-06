package it.istat.cspro.linkage.domain;
import javax.persistence.*;

/**
 *
 * @author giacomi
 */
@MappedSuperclass
public abstract class MatchingVar {

    @Id
    @Column(name = "ID_INDIV")
    private String idIndividual;
    
    @Column(name = "ID_QUEST")
    private String idQuest;    
    
    @Column(name = "NAME1")
    private String name1;                
    
    @Column(name = "NAME2")
    private String name2;
    
    @Column(name = "NAME3")
    private String name3;    
    
    @Column(name = "AGE")
    private String age;                    

    @Column(name = "SEX")
    private String sex;
    
    @Column(name = "RELIGION")
    private String religion;    
    
    @Column(name = "RELAT")
    private String relat;

    @Column(name = "GRADE")
    private String grade;    
    
    @Column(name = "ETHNIC")
    private String ethnic;
    
    @Column(name = "MARITAL")
    private String marital;             
    
//    @Column(name = "ID101")
//    private int idTerr1;       
//    
//    @Column(name = "ID102")
//    private int idTerr2;    
//    
//    @Column(name = "ID103")    
//    private int idTerr3;    
//    
//    @Column(name = "ID104")
//    private int idTerr4; 
//    
//    @Column(name = "ID105")
//    private int idTerr5; 
//    
//    @Column(name = "ID106")
//    private int idTerr6;
//    
//    @Column(name = "ID107")
//    private int idTerr7;  
//    
//    @Column(name = "ID108")
//    private int idTerr8;  
//    
//    @Column(name = "ID109")
//    private int idTerr9;        
    
    @Column(name = "COD_EA")
    private String eaCode;      
            
    public MatchingVar() {}

    public String getEaCode() {return eaCode;}

    public void setEaCode(String eaCode) {this.eaCode = eaCode;}        

    public String getIdIndividual() {return idIndividual;}

    public void setIdIndividual(String idIndividualA) {this.idIndividual = idIndividualA;}

    public String getIdQuest() {return idQuest;}

    public void setIdQuest(String idQuestA) {this.idQuest = idQuestA;}

    public String getName1() {return name1;}

    public void setName1(String name1A) {this.name1 = name1A;}

    public String getName2() {return name2;}

    public void setName2(String name2A) {this.name2 = name2A;}

    public String getName3() {return name3;}

    public void setName3(String name3A) {this.name3 = name3A;}

    public String getAge() {return age;}

    public void setAge(String ageA) {this.age = ageA;}

    public String getSex() {return sex;}

    public void setSex(String sexA) {this.sex = sexA;}

    public String getReligion() {return religion;}

    public void setReligion(String religionA) {this.religion = religionA;}

    public String getRelat() {return relat;}

    public void setRelat(String relatA) {this.relat = relatA;}

    public String getGrade() {return grade;}

    public void setGrade(String gradeA) {this.grade = gradeA;}

    public String getEthnic() {return ethnic;}

    public void setEthnic(String ethnicA) {this.ethnic = ethnicA;}

    public String getMarital() {return marital;}

    public void setMarital(String maritalA) {this.marital = maritalA;}

//    public int getIdTerr1() {return idTerr1;}
//
//    public void setIdTerr1(int idTerr1) {this.idTerr1 = idTerr1;}
//
//    public int getIdTerr2() {return idTerr2;}
//
//    public void setIdTerr2(int idTerr2) {this.idTerr2 = idTerr2;}
//
//    public int getIdTerr3() {return idTerr3;}
//
//    public void setIdTerr3(int idTerr3) {this.idTerr3 = idTerr3;}
//
//    public int getIdTerr4() {return idTerr4;}
//
//    public void setIdTerr4(int idTerr4) {this.idTerr4 = idTerr4;}
//
//    public int getIdTerr5() {return idTerr5;}
//
//    public void setIdTerr5(int idTerr5) {this.idTerr5 = idTerr5;}
//
//    public int getIdTerr6() {return idTerr6;}
//
//    public void setIdTerr6(int idTerr6) {this.idTerr6 = idTerr6;}
//
//    public int getIdTerr7() {return idTerr7;}
//
//    public void setIdTerr7(int idTerr7) {this.idTerr7 = idTerr7;}
//
//    public int getIdTerr8() {return idTerr8;}
//
//    public void setIdTerr8(int idTerr8) {this.idTerr8 = idTerr8;}
//
//    public int getIdTerr9() {return idTerr9;}
//
//    public void setIdTerr9(int idTerr9) {this.idTerr9 = idTerr9;}    
    
//    public String getEACod() {
//        return this.idTerr1 + "-" + this.idTerr2 + "-" + this.idTerr3 + "-" + 
//            this.idTerr4 + "-" + this.idTerr5 + "-" + this.idTerr6 + "-" +                 
//            this.idTerr7 + "-" + this.idTerr8 + "-" + this.idTerr9;
//    }
    
    public String getFullName() {
        return this.name1 + " " + this.name2 + " " + this.name3;
    }
    
    public String getLinkageCod() {
        return this.idIndividual + "_" + this.idQuest;
    }
}
