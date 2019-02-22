
package com.juggernaut.restful_api_tester;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

public class PutHttpClient {

	public static void main(String[] args) throws ClientProtocolException, IOException {

		String url = "https://www.reqres.in/api/users";

		HttpPut putRequest = new HttpPut(url);
		HttpClient client = HttpClientBuilder.create().build();

		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("name", "morpheus"));
		urlParameters.add(new BasicNameValuePair("job", "zion resident"));

		putRequest.setEntity(new UrlEncodedFormEntity(urlParameters));

		HttpResponse response = client.execute(putRequest);
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
