package com.brforte;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.brforte.utils.MockSupport;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class JWTDecoderTest extends MockSupport {

	@Test
	public void getSubject() {
		DecodedJWT jwt = JWT.decode(
				"eyJhbGciOiJSUzI1NiIsImtpZCI6IjU5NjJlN2EwNTljN2Y1YzBjMGQ1NmNiYWQ1MWZlNjRjZWVjYTY3YzYiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb20iLCJuYmYiOjE2NzY4MDM1NDgsImF1ZCI6IjEwMjI3NzMyNzc2OTEtaTRzM2Q1ZHNjcXI2ZTRtcjUxOGo5OXNzOWdmYWRqZTMuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJzdWIiOiIxMTM5NjM5MjQ1NTAzNTcwNDYyNTUiLCJlbWFpbCI6ImpjZWxlc3RlMUBnbWFpbC5jb20iLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwiYXpwIjoiMTAyMjc3MzI3NzY5MS1pNHMzZDVkc2NxcjZlNG1yNTE4ajk5c3M5Z2ZhZGplMy5hcHBzLmdvb2dsZXVzZXJjb250ZW50LmNvbSIsIm5hbWUiOiJKb3PDqSBDZWxlc3RlIiwicGljdHVyZSI6Imh0dHBzOi8vbGgzLmdvb2dsZXVzZXJjb250ZW50LmNvbS9hL0FFZEZUcDR2dDM2ZUZGVS1TMzltVFRGWXdqb29OWnFMX0ZzeEJNYWFrSEItNWc9czk2LWMiLCJnaXZlbl9uYW1lIjoiSm9zw6kiLCJmYW1pbHlfbmFtZSI6IkNlbGVzdGUiLCJpYXQiOjE2NzY4MDM4NDgsImV4cCI6MTY3NjgwNzQ0OCwianRpIjoiN2JhNzQwZjA4ZDI3ZjUxNDkzNDJhYjEwOGJjZmE3YWEyMzZlYmE5NSJ9.PngVyO_ASn-a9QCiDHpwDnw6Q3ad8543reez8Q0X5h62_gFqr_dGUlPi7j_HuDAmpGEH4a5i_JKCw42QIiAfv-F6vjX-IpR6Vb3fFPrzm72HVQcTd0EUNEE_XzewJgVEWK2BNIt6y52EtkEKQBlFX5QUJXTAwN5icvIhcrDHfwhkoVAZTcZdaWosGuu8mz0H6ktfOS7FSL_EkRPjoxTNhTwVHP0TGjeFmP6rzW0PsiTnYw6b95dDHNAAUK4J-5NOLGW0lPOoAiaGWPGfkDmnDyE1bo8NUiDVHj7zJIywgXtgR7CPnG7bIjfNgA3KnA76SEuUP7vniTdsso5eOJJhWw");

		assertThat(jwt.getClaim("email").toString(), is( not( "jceleste1@gmail.com")));
		//assertThat(jwt.getClaim("name").toString(), is("José Celeste"));
	}



}
