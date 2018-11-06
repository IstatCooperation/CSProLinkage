package it.istat.cspro.linkage.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Paolo Giacomi
 */
@Embeddable
public class LinkageInfoKey implements Serializable {
    @Column(name = "id")
    private String id;    
    
    @Column(name = "eacode")
    private String eaCode;

    public LinkageInfoKey() {}   

    public LinkageInfoKey(String id, String eaCode) {
        this.id = id;
        this.eaCode = eaCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEaCode() {
        return eaCode;
    }

    public void setEaCode(String eaCode) {
        this.eaCode = eaCode;
    }        
}
