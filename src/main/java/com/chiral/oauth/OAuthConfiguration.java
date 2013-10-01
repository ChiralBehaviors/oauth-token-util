/**
 * Copyright (c) 2013, Chiral Behaviors, LLC
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

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

/**
 * @author hparry
 *
 */
public class OAuthConfiguration {
	

	
	public static OAuthConfiguration fromYaml(InputStream yaml)
			throws JsonParseException, JsonMappingException, IOException {
		OAuthConfiguration configuration = new ObjectMapper(new YAMLFactory())
				.readValue(yaml, OAuthConfiguration.class);
		yaml.close();
		return configuration;
	}
	
	@JsonProperty
	public static String clientId;
	
	@JsonProperty
	public static String secret;
	
	//If you've got a legit callback URL, use it. If you just need to get stuff
	//done, throw in something like "myfakecallback" and be done with it.
	public static String redirectUri;
	
	public static String environment;

	public static String username;

	public static String password;
	
	public String getClientId() {
		return clientId;
	}
	
	public void setClientId(String id) {
		clientId = id;
	}

	/**
	 * @return the secret
	 */
	public String getSecret() {
		return secret;
	}

	/**
	 * @param secret the secret to set
	 */
	public void setSecret(String secret) {
		OAuthConfiguration.secret = secret;
	}

	/**
	 * @return the redirectUri
	 */
	public String getRedirectUri() {
		return redirectUri;
	}

	/**
	 * @param redirectUri the redirectUri to set
	 */
	public void setRedirectUri(String redirectUri) {
		OAuthConfiguration.redirectUri = redirectUri;
	}

	/**
	 * @return the environment
	 */
	public String getEnvironment() {
		return environment;
	}

	/**
	 * @param environment the environment to set
	 */
	public void setEnvironment(String environment) {
		OAuthConfiguration.environment = environment;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		OAuthConfiguration.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		OAuthConfiguration.password = password;
	}

}
