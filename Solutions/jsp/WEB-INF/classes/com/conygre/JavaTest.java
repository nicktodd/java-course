package com.conygre;

import java.io.*;
//import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 * This is a simple example of an HTTP Servlet.  It responds to the GET
 * and HEAD methods of the HTTP protocol.
 */
public class JavaTest extends HttpServlet {

    private int deleTotal=0;
    private static String answers[] = {"a", "d", "a", "c", "c", "false", "c", "b"};
    private static int total = answers.length;

    public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
    {
        calculateScore(req);
	    resultsPage(res);
	    deleTotal = 0;
    }

    public void calculateScore(HttpServletRequest req) throws ServletException, IOException
    {
        for (int i=0; i<answers.length; i++)
        {
            String currentAnswer = req.getParameter("q" + i);
            if (currentAnswer.equals(answers[i]))
                deleTotal++;
        }
    }

    public void resultsPage(HttpServletResponse res) throws ServletException, IOException
    {
        // first, set the "content type" header of the response
	    res.setContentType("text/html");

        ServletOutputStream out = res.getOutputStream();
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>Your Java Test Results</title>");
	    out.println("</head>");
	    out.println("<body>");
        out.println("<h1>Your Java Test Results</h1>");
        out.println("You scored " + deleTotal + " out of " + total);
        out.println("</body>");
        out.println("</html>");

    }


    public String getServletInfo() {
        return "Java Testing Utility";
    }

}

