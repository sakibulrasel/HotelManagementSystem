/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Another User
 */
public class EventFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest reqt = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;
            HttpSession ses = reqt.getSession(false);
 
            String reqURI = reqt.getRequestURI();
            if ((ses != null && ses.getAttribute("urole") != null && !ses.getAttribute("urole").equals("") )){
                if(ses.getAttribute("urole").equals("Admin")){
                    resp.sendRedirect(reqt.getContextPath() + "/admin/welcome.xhtml");
                }else if(ses.getAttribute("urole").equals("Manager")){
                    resp.sendRedirect(reqt.getContextPath() + "/roommanager/welcome.xhtml");
                }else{
                    chain.doFilter(request, response);
                }    
                
            }
            
            else{
                resp.sendRedirect(reqt.getContextPath() + "/login");
            }
            
        } catch (Exception e) {
        }
    }

    @Override
    public void destroy() {
        
    }
    
    
    
}
