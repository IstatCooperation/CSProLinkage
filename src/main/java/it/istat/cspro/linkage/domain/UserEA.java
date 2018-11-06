package it.istat.cspro.linkage.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author Paolo Giacomi
 */
@Entity
@Table(name = "linkage_user_ea")
public class UserEA implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "ea_cod")
    private String eaCod;

    @Column(name = "selected")
    private int selected; 

    public UserEA() {}
    
    public UserEA(String userName, String eaCod) {
        this.userName = userName;
        this.eaCod = eaCod;
        this.selected = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEaCod() {
        return eaCod;
    }

    public void setEaCod(String eaCod) {
        this.eaCod = eaCod;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }    
}
