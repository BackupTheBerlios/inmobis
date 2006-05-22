package com.inmobis.login;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.Globals;
import org.apache.struts.action.*;

import com.inmobis.INMOCTES;

public class FiltroAcceso implements Filter {
  private String onErrorUrl;
  private String[] roleNames;

  public void init(FilterConfig filterConfig) 
      throws ServletException {
	    String roles = filterConfig.getInitParameter("roles");
	    if (roles == null || "".equals(roles)) {
	      roleNames = new String[0];
	    }
	    else {
	      roles.trim();
	      roleNames = roles.split("\\s*,\\s*");
	    }
	  
	  onErrorUrl = filterConfig.getInitParameter("onError");
    if (onErrorUrl == null || "".equals(onErrorUrl)) {
      onErrorUrl = "/index.jsp";
    }
  }

  public void doFilter(ServletRequest request,
                       ServletResponse response,
                       FilterChain chain) 
                 throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;
    
    HttpSession session = req.getSession();
    String userName = (String) session.getAttribute(INMOCTES.userName);
    ActionMessages errors = new ActionMessages();
    if ((userName == null)||(userName.trim().equals(""))) {
		errors.add("userName", new ActionMessage("error.password.invalid"));
    }
    else {
        boolean hasRole = false;
        String userRole = (String) session.getAttribute(INMOCTES.tipoUsuario);
        for (int i=0; i<roleNames.length; i++) {
          if (userRole.trim().equals((roleNames[i]))) {
            hasRole = true;
            break;
          }
        }
        if (!hasRole) {
    		errors.add("userName", new ActionMessage("error.tipousuario.required"));
        }
      }
      if (errors.isEmpty()) {
        chain.doFilter(request, response);
      }
      else {
        req.setAttribute(Globals.ERROR_KEY, errors);
        req.getRequestDispatcher(onErrorUrl).forward(req, res);
      }   
  }

  public void destroy() {
  }
}
