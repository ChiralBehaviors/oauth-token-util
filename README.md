oauth-token-util
================

If you've ever been trying to build a Salesforce connected app and had your soul crushed by a lack of a throw-away OAuth token, this repo is for you!

This code implements the Salesforce OAuth password flow, described here: https://help.salesforce.com/apex/HTViewHelpDoc?id=remoteaccess_oauth_username_password_flow.htm&language=en
It will use your username and password to get an OAuth token which you can then attach to other API requests. Note that tokens acquired with this method cannot be refreshed, but for prototyping, sometimes that's ok.

To use, clone the repo, then mvn clean install, then open up the example.yml file, uncomment the properties there, and fill in appropriate values. After that, just run the OAuthLoginUtil routine with a single argument of the path to your yml file (src/main/resources/example.yml, in our example). 

IMPORTANT NOTE:
Just in case it's not abundantly clear, using this repo means storing your Salesforce password in PLAIN TEXT. If you're not clear on why this is generally a bad thing, just understand that it is, and that this repo is not meant to be production code, nor is it a substitute for implementing OAuth correctly. This is really just for your 24 hour hack day projects. 


Copyright (c) 2013, Chiral Behaviors, LLC
Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
