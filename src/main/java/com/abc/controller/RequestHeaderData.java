package com.abc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = { "/test" }, loadOnStartup = 1)
public class RequestHeaderData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("************RequestHeaderData CLASS IS LOADING*************");
	}

	public RequestHeaderData() {
		System.out.println("************RequestHeaderData CLASS IS INSTATNTIATION*****************");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("************RequestHeaderData CLASS IS INITIALIZATION************");
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Setting the MIME type
		response.setContentType("text/html");

		// Getting the writer stream object to send the response
		PrintWriter out = response.getWriter();

		//Generating the response to the client
		out.println("<html><head><title>Response</title></head>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr><th colspan='2'>Request Header</th></tr>");
		out.println("<tr><th>HeaderName</th><th>HeaderValue</th></tr>");

		//Getting all the header details
		Enumeration<String> headerNames = request.getHeaderNames();
		
		//processing enumeration object to get key and value
		while (headerNames.hasMoreElements()) {
			out.println("</tr>");
		
			//Getting the key of a particular header
			String key = (String) headerNames.nextElement();
			
			//Getting the value on based on key
			String value = request.getHeader(key);
			out.println("<td>" + key + "</td>");
			out.println("<td>" + value + "</td>");
			out.println("</tr>");

		}
		out.println("</table>");
		out.println("</body>");

		// closing stream
		out.close();
	}

}
