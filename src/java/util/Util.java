/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.Food;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Another User
 */
public class Util {
    public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	public static Food getCart() {
		HttpSession session = getSession();
		Food f = (Food) session.getAttribute("food");
		if (f == null) {
			f = new Food();
			session.setAttribute("food", f);
		}
		return f;
	}

	public static void emptyCart() {
		HttpSession session = getSession();
		session.removeAttribute("food");
	}
}
