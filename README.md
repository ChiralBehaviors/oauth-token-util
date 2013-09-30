oauth-token-util
================

If you've ever been trying to build a Salesforce connected app and had your soul crushed by a lack of a throw-away OAuth token, this repo is for you!

This code implements the Salesforce OAuth password flow, described here: https://help.salesforce.com/apex/HTViewHelpDoc?id=remoteaccess_oauth_username_password_flow.htm&language=en
It will use your username and password to get an OAuth token which you can then attach to other API requests. Note that tokens acquired with this method cannot be refreshed, but for prototyping, sometimes that's ok.

To use, clone the repo, then mvn clean install, then open up the example.yml file, uncomment the properties there, and fill in appropriate values. After that, just run the OAuthLoginUtil routine with a single argument of the path to your yml file (src/main/resources/example.yml, in our example). 
