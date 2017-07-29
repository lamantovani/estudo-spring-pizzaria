package com.lucascorp.pizzaria;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Application implements WebApplicationInitializer  {
	

	@Override
	public void onStartup(ServletContext serviletContext) throws ServletException {
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.setConfigLocation("com.lucascorp.pizzaria.configuration");
		
		Dynamic appServlet = serviletContext.addServlet("appServlet", new DispatcherServlet(webApplicationContext));
		appServlet.setLoadOnStartup(1);
		appServlet.addMapping("/app/*");
		
		serviletContext.addListener(new ContextLoaderListener(webApplicationContext));
		
	}
	

}
