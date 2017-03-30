
Facebook notes.

To get Facebook data (posts, likes, etc.) you need an 'App'.  To make an App, you have to be part of Facebook's developer program.
- https://developers.facebook.com

An App is easy to build, just click the button.  The App will have an 'AppId' and an 'AppSecret'.  Use these to get an AccessToken, the 3rd thing needed to programmatically access Facebook.  Do this by plugging the AppId and AppSecret into a GET request in a browser:

https://graph.facebook.com/oauth/access_token?client_id=YOUR_APP_ID&client_secret=YOUR_APP_SECRET&grant_type=client_credentials

The result will be an AccessToken.

{"access_token":"19EN_hABCDEFGTHISISFAKECEHDV2o","token_type":"bearer"}


Facebook Explorer is a web interface that can be used to act as a client against the Graph API.
https://developers.facebook.com/tools/explorer
Example query:  GET / v2.8 /someuser/feed?fields=comments.limit(1).summary(true)
(Above will bring back a REST response that has data about comments, etc.

