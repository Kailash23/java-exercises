package com.juggernaut.restful_api_tester;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class GetHttpRequest {
//	private static final String USER_AGENT = null;

	public static void main(String[] args) throws IOException {
		String url = "https://www.reqres.in/api/users?page=2";

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet getReq = new HttpGet(url);

//		// add request header
//		request.addHeader("User-Agent", USER_AGENT);
		HttpResponse response = client.execute(getReq);

		System.out.println("Response Code : " 
	                + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
			new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		
		System.out.println(result);
	}
}
