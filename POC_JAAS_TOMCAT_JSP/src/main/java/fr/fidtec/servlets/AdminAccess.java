package fr.fidtec.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// http://localhost:8080/POC_JAAS_TOMCAT_JSP/AdminAccess
public class AdminAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminAccess() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().println("Acces administrateur autorisé on " + request.getContextPath());
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
