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
public class ObjectIDGenerator {

    public final static String getQuestionariesID(String idQuestA, String idQuestB) {
        return "qa_" + idQuestA + "qb_" + idQuestB;
    }
}
