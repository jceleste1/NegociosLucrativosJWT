package com.brforte.controller;

import java.net.URI;
import java.net.URLEncoder;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.brforte.dto.Return;
import com.brforte.dto.User;
import com.brforte.dto.UserResponse;
import com.brforte.service.LoginService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "API for performing operations on ")
public class DecodeJWTController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DecodeJWTController.class);

	@GetMapping(path = "/jwt/{token}", produces = "application/hal+json;charset=utf8")
	public ResponseEntity<UserResponse> decode(@PathVariable String token) {

		LOGGER.info("Request Begin !! 1>>>> ");
		ResponseEntity response = null;
		UserResponse userResponse = new UserResponse();
		User user = new User();
		try {
			byte[] decodedBytes = Base64.getUrlDecoder().decode(token);
			token = new String(decodedBytes);
			LOGGER.info("!!>>>> ");
			
			DecodedJWT jwt = JWT.decode(token);
			
			String mail = (  null != jwt.getClaim("email") ? jwt.getClaim("email").toString()  : "" ) ;
			String given_name = (  null != jwt.getClaim("given_name") ? jwt.getClaim("given_name").toString()  : "" ) ;
			String family_name =  (  null != jwt.getClaim("family_name") ? jwt.getClaim("family_name").toString()  : "" ) ;
			
			
			LOGGER.info("ok >> >>>> "+ given_name+ " - "  +mail);
			
			user.setEmail(cleanVar( mail ));
			user.setName(
					cleanVar(given_name + " " +  family_name));
			userResponse.setUser(user);
			
			Return retorno = new Return();
			retorno.setCode("01");
			retorno.setMessage("_Sucess");
			userResponse.setReturno(retorno);

			response = ResponseEntity.status(HttpStatus.OK).body(userResponse);

		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.FORBIDDEN).body(userResponse);
			e.printStackTrace();
			LOGGER.info("Exception  >>>> " + e.getMessage());
		}

		LOGGER.info("End >>>> ");

		return response;
	}

	private String cleanVar(String variable) {
		variable = variable.replace("\"", "");
		return variable;
	}

}
