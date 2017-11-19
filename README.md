## oAuth2 Login

Both Client App and Resource Server (Authorization Server).
Application that demonstrates the oAuth2 flow.
Client Application requests authorization that is validated by the API. 

Basic64 filter verifies the Authorization Header ( Ex: Authorization : Basic Q2F0YWxpbjpMb2xpcG9wMjI= )

Authorization Server consumes :
- client_id = Application ID which requests the server (ex: demoapp)
- redirect_uri = Where the service redirects after authorization code is granted
- response_type
- scope = Level of access (ex: read/write)

Switch mySQL Database / MongoDB Database with ConfigHadler.class

### Endpoints (JAX-RS)

- **[<code>GET</code> authorize]**
- **[<code>POST</code> authorize]**
- **[<code>GET</code> token]**
- **[<code>POST</code> token]**

### Technologies / Frameworks: 

Java, JAX-RS, Jersey, JSP, JSWTL, JSON, Maven, SQL, noSQL



