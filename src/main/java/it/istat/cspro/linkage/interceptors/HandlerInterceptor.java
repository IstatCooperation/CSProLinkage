/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.istat.cspro.linkage.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author Paolo Giacomi
 */
@Component
public class HandlerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(HttpServletRequest request, 
            HttpServletResponse response, 
            Object handler, 
            ModelAndView modelView) throws Exception {      
        //String codTerr = request.getParameter("codTerr");
        /*if (codTerr == null && request.getRequestURI().indexOf("ea_select") == -1) {
            response.sendRedirect("/linkage/ea_select");
        }*/
        //return super.preHandle(request, response, handler); //To change body of generated methods, choose Tools | Templates.
        //return true;
    }    
    
    
}
