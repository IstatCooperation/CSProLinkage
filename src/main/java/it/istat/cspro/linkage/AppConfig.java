/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.istat.cspro.linkage;

import it.istat.cspro.linkage.interceptors.HandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author Paolo Giacomi
 */
@Configuration
public class AppConfig extends WebMvcConfigurerAdapter  {

    @Autowired 
    HandlerInterceptor hi;

    @Override
    public void addInterceptors(InterceptorRegistry ir) {
        ir.addInterceptor(hi);
    }
}
