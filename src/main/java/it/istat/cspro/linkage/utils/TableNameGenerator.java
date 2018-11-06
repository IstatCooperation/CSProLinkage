/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.istat.cspro.linkage.utils;

/**
 *
 * @author Paolo Giacomi
 */
public final class TableNameGenerator {
    public final  static  String getTableNameFromEaCod(String eaCode) {
        return "ea" + eaCode;
    }
}
