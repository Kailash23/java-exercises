package com.juggernaut.restful_api_tester;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.HttpClientBuilder;

public class DeleteHttpClient {
	public static void main(String[] args) throws UnsupportedOperationException, IOException {
		String url = "https://www.reqres.in/api/users/2";

		HttpDelete deleteReq = new HttpDelete(url);

		HttpClient client = HttpClientBuilder.create().build();

		HttpResponse response = client.execute(deleteReq);
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

	}
}
