package org.camunda.loanApplication.loanApprovalPkg;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.io.OutputStream;

import java.io.OutputStreamWriter;

import java.net.HttpURLConnection;

import java.net.MalformedURLException;

import java.net.ProtocolException;

import java.net.URL;



public class StartCamundaProcess {

	public static void POSTRequest() throws IOException {

		final String POST_PARAMS = "{}";

		System.out.println(POST_PARAMS);

		URL obj = new URL("http://localhost:8080/rest/engine/default/process-definition/key/loanApplication/start");

		HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();

		postConnection.setRequestMethod("POST");


		postConnection.setRequestProperty("Content-Type", "application/json");

		postConnection.setDoOutput(true);

		OutputStream os = postConnection.getOutputStream();

		os.write(POST_PARAMS.getBytes());

		os.flush();

		os.close();

		int responseCode = postConnection.getResponseCode();

		System.out.println("POST Response Code :  " + responseCode);

		System.out.println("POST Response Message : " + postConnection.getResponseMessage());

		if (responseCode == HttpURLConnection.HTTP_OK) { // success

			BufferedReader in = new BufferedReader(new InputStreamReader(

					postConnection.getInputStream()));

			String inputLine;

			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {

				response.append(inputLine);

			}
			in.close();

			// print result
			
			
			

			System.out.println(response.toString());

		} else {

			System.out.println("POST NOT WORKED");

		}

	}

}
