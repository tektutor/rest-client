package org.tektutor.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class Main {

	public static void main(String[] args) {
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet("https://www.metaweather.com/api/location/search/?query=san");
		HttpResponse response;
		try {
			response = client.execute(request);
			BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
			    System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
