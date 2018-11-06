/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.istat.cspro.linkage.dao;

import it.istat.cspro.linkage.domain.LinkageStep;
import it.istat.cspro.linkage.utils.TableNameGenerator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Paolo Giacomi
 */
@Repository
public class LinkageStepDao {      
    
    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public LinkageStepDao(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
    
    public List <LinkageStep> findByCodEaAndStep(final String eaCode, String step) {
        return (List<LinkageStep>) hibernateTemplate.execute(new HibernateCallback() {
            @Override
            public Object doInHibernate(Session sn) throws HibernateException {
                if (step.equals("1"))
                    createTableEA(eaCode);
                SQLQuery query = sn.createSQLQuery("SELECT * from " + TableNameGenerator.getTableNameFromEaCod(eaCode) + 
                        " where step ='" + step + "'");
                query.addScalar("idIndividualA", StandardBasicTypes.STRING)
                    .addScalar("idQuestA", StandardBasicTypes.STRING)
                    .addScalar("name1A", StandardBasicTypes.STRING)
                    .addScalar("name2A", StandardBasicTypes.STRING)
                    .addScalar("name3A", StandardBasicTypes.STRING)
                    .addScalar("ageA", StandardBasicTypes.STRING)
                    .addScalar("sexA", StandardBasicTypes.STRING)
                    .addScalar("religionA", StandardBasicTypes.STRING)
                    .addScalar("relatA", StandardBasicTypes.STRING)
                    .addScalar("gradeA", StandardBasicTypes.STRING)
                    .addScalar("ethnicA", StandardBasicTypes.STRING)
                    .addScalar("maritalA", StandardBasicTypes.STRING)
                    .addScalar("idIndividualB", StandardBasicTypes.STRING)                        
                    .addScalar("idQuestB", StandardBasicTypes.STRING)
                    .addScalar("name1B", StandardBasicTypes.STRING)
                    .addScalar("name2B", StandardBasicTypes.STRING)
                    .addScalar("name3B", StandardBasicTypes.STRING)
                    .addScalar("ageB", StandardBasicTypes.STRING)
                    .addScalar("sexB", StandardBasicTypes.STRING)
                    .addScalar("religionB", StandardBasicTypes.STRING)
                    .addScalar("relatB", StandardBasicTypes.STRING)
                    .addScalar("gradeB", StandardBasicTypes.STRING)
                    .addScalar("ethnicB", StandardBasicTypes.STRING)
                    .addScalar("maritalB", StandardBasicTypes.STRING)                        
                    .addScalar("eaCode", StandardBasicTypes.STRING)
                    .addScalar("unlinkedQuestA", StandardBasicTypes.INTEGER)
                    .addScalar("unlinkedQuestB", StandardBasicTypes.INTEGER)
                    .setResultTransformer(Transformers.aliasToBean(LinkageStep.class));
                return query.list();
            }
        });
    }    
    
    
    public Object initializeStep(String userName, String eaCode, String step) {
        return hibernateTemplate.execute(new HibernateCallback() {
            @Override
            public Object doInHibernate(Session sn) throws HibernateException {
                Query query = sn.createSQLQuery("CALL proc_linkage_step(:userName, :eaCode, :tableName, :step)")
                        .setParameter("userName", userName)
                        .setParameter("eaCode", eaCode)
                        .setParameter("tableName", TableNameGenerator.getTableNameFromEaCod(eaCode))
                        .setParameter("step", step);
                return query.executeUpdate();
            }
        });
    }
    
    public Object refreshNumUnlinked(String eaCode) {
        return hibernateTemplate.execute(new HibernateCallback() {
            @Override
            public Object doInHibernate(Session sn) throws HibernateException {
                Query query = sn.createSQLQuery("CALL updateNumberUnlinked(:tableName)")
                        .setParameter("tableName", TableNameGenerator.getTableNameFromEaCod(eaCode));
                return query.executeUpdate();
            }
        });
    }    
    
    public Object createTableEA(String eaCode) {
        return hibernateTemplate.execute(new HibernateCallback() {
            @Override
            public Object doInHibernate(Session sn) throws HibernateException {
                /* create table if not exists */
                Query query = sn.createSQLQuery("CALL proc_linkage_create_table(:tableName)")
                        .setParameter("tableName", TableNameGenerator.getTableNameFromEaCod(eaCode));
                return query.executeUpdate();
            }
        });
    }    
}              