/**
 * Copyright (c) 2013, Chiral Behaviors, LLC
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided
 * that the following conditions are met:
 *
 *    Redistributions of source code must retain the above copyright notice, this list of conditions and the
 *    following disclaimer.
 *
 *    Redistributions in binary form must reproduce the above copyright notice, this list of conditions and
 *    the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 *    Neither the name of Chiral Behaviors, LLC. nor the names of its contributors may be used to endorse or
 *    promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */


package com.chiral.oauth;

import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * A quick and dirty util to get the goddamn oauth token from Salesforce so we can all
 * move on with our lives. Not that we're bitter or anything.
 * @author hparry
 * @author hhildebrand
 *
 */
public class OAuthLoginUtil {
	// The connection data
	private static final String clientId = "3MVG9A2kN3Bn17hv1LMM2yEJZ.6CYoCg.FA.115PqoH8kMFPOPyHjy_dRQzAH_WZ9BOJHLpEB6C3XdtbUbBr7";
	private static final String secret = "2875976084689535109";
	// THis is meaningless in our context
	private static final String redirectUri = "https://localhost:8443/_callback";
	private static final String environment = "https://login.salesforce.com";
	private static String tokenUrl = null;
	private static final String username = "hal.hildebrand@halhildebrand.com";
	private static final String password = "God4LarryEllisonsWdRVmt7BIJdeZ95jEpiVXDh3";
	private static String accessToken = null;
	private static String instanceUrl = null;

	public static void main(String[] args) {
		// Step 0: Connect to SalesForce.
		System.out.println("Getting a token");
		tokenUrl = environment + "/services/oauth2/token";
		HttpClient httpclient = new HttpClient();
		PostMethod post = new PostMethod(tokenUrl);
		post.addParameter("grant_type", "password");
		post.addParameter("client_id", clientId);
		post.addParameter("client_secret", secret);
		post.addParameter("redirect_uri", redirectUri);
		post.addParameter("username", username);
		post.addParameter("password", password);

		try {
			httpclient.executeMethod(post);
			System.out.println(post.getResponseBodyAsString());
		} catch (HttpException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			post.releaseConnection();
		}
		System.out.println("We have an access token: " + accessToken + "\n"
				+ "Using instance " + instanceUrl + "\n\n");

	}

}
