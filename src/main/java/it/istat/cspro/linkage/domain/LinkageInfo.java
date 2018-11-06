package it.istat.cspro.linkage.domain;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;

/**
 *
 * @author giacomi
 */
@Entity
@Table(name = "linkage_info")
public class LinkageInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    LinkageInfoKey infoKey;
    
    @Column(name = "VALUE")
    private String value;    
    
    @Column(name = "DATE")
    private Date date;     
    
    @Column(name = "NOTE")
    private String note;        

    public LinkageInfo() {}
    
    public LinkageInfo(LinkageInfoKey infoKey, String value, String note) {
        this.infoKey = infoKey;
        this.value = value;
        this.note = note;
        this.date = new Date(System.currentTimeMillis());
    }

    
    
    public String getId() {
        return this.infoKey.getId();
    }
    
    public String getEaCode() {
        return this.infoKey.getEaCode();
    }    

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
}
