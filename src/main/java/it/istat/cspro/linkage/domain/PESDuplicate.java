package it.istat.cspro.linkage.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author giacomi
 */
@Entity
@Table(name = "pes_individual_duplicate")
public class PESDuplicate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(name = "num", nullable = false)
    private int num;

    public PESDuplicate() {
    }

    public PESDuplicate(PESDuplicate pesDuplicate) {
        this.name = pesDuplicate.getName();
        this.num = pesDuplicate.getNum();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
