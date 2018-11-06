/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.istat.cspro.linkage;

/**
 *
 * @author Paolo Giacomi
 */
public class AppStatus {
    String userName;
    
    String selEaCod;

    public AppStatus(String selEaCod, String userName) {
        this.selEaCod = selEaCod;
        this.userName = userName;
    }    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }   

    public String getSelEaCod() {
        return selEaCod;
    }

   public void setSelEaCod(String selEaCod) {
        this.selEaCod = selEaCod;
    }
}
