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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * A quick and dirty util to get the goddamn oauth token from Salesforce so we
 * can all move on with our lives. Not that we're bitter or anything.
 * 
 * @author hparry
 * @author hhildebrand
 * 
 */
public class OAuthLoginUtil {


	
	public static void main(String[] args) throws Exception {
		// Step 0: Connect to SalesForce.
		OAuthConfiguration config;
		File configFile = new File(args[0]);
		config = OAuthConfiguration.fromYaml(new FileInputStream(configFile));
		System.out.println("Getting a token");
		String tokenUrl = config.environment + "/services/oauth2/token";
		//TODO hparry use JAX-RS instead of Apache commons
		HttpClient httpclient = new HttpClient();
		PostMethod post = new PostMethod(tokenUrl);
		post.addParameter("grant_type", "password");
		post.addParameter("client_id", config.clientId);
		post.addParameter("client_secret", config.secret);
		post.addParameter("redirect_uri", config.redirectUri);
		post.addParameter("username", config.username);
		post.addParameter("password", config.password);

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
	}

}
