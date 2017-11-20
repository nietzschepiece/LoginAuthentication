## oAuth2 Login

Both Client App and Resource Server (Authorization Server).
Application that demonstrates the oAuth2 flow.
Client Application requests authorization that is validated by the API. 

Basic64 filter verifies the Authorization Header ( Ex: Authorization : Basic Q2F0YWxpbjpMb2xpcG9wMjI= )

Token

Switch mySQL Database / MongoDB Database with ConfigHadler.class

### Authorization Server Endpoints (JAX-RS)

- **[<code>GET</code> authorize]**
- **[<code>POST</code> authorize]**

Authorize Resource Consumes:
- client_id = Application ID which requests the server (ex: demoapp)
- redirect_uri = Where the service redirects after authorization code is granted
- response_type
- scope = Level of access (ex: read/write)

Produces:
- code = authorization_code

- **[<code>GET</code> token]**
- **[<code>POST</code> token]**

Token Resource Consumes:
- client_id
- client_secret
- grant_type = token
- authorization_code = Retrieved from Authorize Resource

Produces:
- token = Header: Authorization: Bearer <JWT>

### Technologies / Frameworks: 

Java, JAX-RS, Jersey, JSP, JWT, JSWTL, JSON, Maven, SQL, noSQL



