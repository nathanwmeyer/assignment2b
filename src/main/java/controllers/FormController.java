package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.User;

@ManagedBean 
@ViewScoped
public class FormController {

	public String onSubmit(User user)
	{
		System.out.println("To check: /nThe user's first name is: " + user.getFirstName() + "/nand their last name is: " + user.getLastName());
		FacesContext context = FacesContext.getCurrentInstance();
		user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		return "TestResponse.xhtml";
	}
	public String onFlash(User user)
	{
		FacesContext context = FacesContext.getCurrentInstance();
		user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("user", user);
		return "TestResponse2.xhtml";
	}
}
