/**
 * Copyright (c) {year}, Chiral Behaviors, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
