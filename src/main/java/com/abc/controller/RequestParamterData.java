package com.abc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rqst")
public class RequestParamterData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("************RequestParameterData CLASS IS LOADING*************");
	}

	public RequestParamterData() {
		System.out.println("************RequestParameterData CLASS IS Instantiation*************");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("************RequestHeaderData CLASS IS INITIALIZATION************");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Setting MIME type for response Object
		response.setContentType("text/html");

		// Getting the Writer stream
		PrintWriter out = response.getWriter();

		out.println("<Html><head><title>Output</title></head>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr colspan='2'><th>RequestParameterData</th></tr>");
		out.println("<tr><td>RequestParameterName</td><td>RequestParameterValue</td></tr>");

		//Getting all the parameter details
		Enumeration<String> parameterNames = request.getParameterNames();

		while (parameterNames.hasMoreElements()) {
			
			out.println("<tr>");
			//Getting parameter names from the client
			String name = (String) parameterNames.nextElement();
			
			//Getting key values from name 
			String key=request.getParameter(name);
			
			out.println("<td>"+name+"</td>");
			out.println("<td>"+key+"</td>");
			out.println("</tr>");
		}
		
		out.println("</table>");
		out.println("</body>");
		
		// Closing the stream
		out.close();
	}

}
