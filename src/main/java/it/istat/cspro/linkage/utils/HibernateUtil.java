/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.istat.cspro.linkage.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;

/**
 *
 * @author Paolo Giacomi
 */
public final class HibernateUtil {

    private static SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }
    
    public static HibernateTemplate getHibernateTemplate() {
        return new HibernateTemplate(getSessionFactory());
    }
}
