package com.example.demo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Logger;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ErrorReportValve;

public class BlankTomcatErrorValve extends ErrorReportValve {

	// Create a simple logger
	Logger log = Logger.getLogger(BlankTomcatErrorValve.class.getName());

	@Override
	protected void report(Request request, Response response, Throwable t) {
		try {
			// Write a more friendly, less technical message to the user
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(response.getOutputStream()));
			out.write("<html><head><title>Oops</title><body>");
			out.write("<h1>Oops</h1>");
			out.write("<p>Wrong file type uploaded!</p>");
			out.write("<p>Please return to previous page and resubmit a CSV file.</p>");
			out.write("</body></html>");
			out.close();

			// Log the error with your favorite logging framework...
			log.severe("Uncaught throwable was thrown: " + t.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
