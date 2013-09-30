oauth-token-util
================

If you've ever been trying to build a Salesforce connected app and had your soul crushed by a lack of a throw-away OAuth token, this repo is for you!

This code implements the Salesforce OAuth password flow, described here: https://help.salesforce.com/apex/HTViewHelpDoc?id=remoteaccess_oauth_username_password_flow.htm&language=en
It will use your username and password to get an OAuth token which you can then attach to other API requests. Note that tokens acquired with this method cannot be refreshed, but for prototyping, sometimes that's ok.

To use, clone the repo, then mvn clean install, then open up the example.yml file, uncomment the properties there, and fill in appropriate values. After that, just run the OAuthLoginUtil routine with a single argument of the path to your yml file (src/main/resources/example.yml, in our example). 

IMPORTANT NOTE:
Just in case it's not abundantly clear, using this repo means storing your Salesforce password in PLAIN TEXT. If you're not clear on why this is generally a bad thing, just understand that it is, and that this repo is not meant to be production code, nor is it a substitute for implementing OAuth correctly. This is really just for your 24 hour hack day projects. 


Copyright (c) 2013, Chiral Behaviors, LLC
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 
Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.

Neither the name of Chiral Behaviors, LLC. nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
