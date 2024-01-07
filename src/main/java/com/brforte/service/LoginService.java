package com.brforte.service;

import java.net.URI;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.brforte.dto.Return;
import com.brforte.dto.User;
import com.brforte.dto.UserResponse;

public class LoginService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);

	public UserResponse send(User user) {

		LOGGER.info("Request LoginService.send >>>> ");
		UserResponse userResponse = new UserResponse();
		String url = "https://www.negocioslucrativos.com.br/users/usersocial/index.php?mail=" + user.getEmail()
				+ "&name=" + URLEncoder.encode(user.getName());

		try {
			URI uri = new URI(url);
			RestTemplate restTemplate = new RestTemplate();
			userResponse = restTemplate.getForObject(uri, UserResponse.class);
			
			Return retorno = new Return();
			retorno.setCode("01");
			retorno.setMessage("_Sucess");
			userResponse.setUser(user);
			userResponse.setReturno(retorno);
			

			LOGGER.info("Get id user >>>> " + userResponse.getUser().getId());

		} catch (Exception e) {
			LOGGER.error("LoginService.send " + e.getMessage());
		}

		LOGGER.info("End LoginService.send >>>> ");
		return userResponse;
	}

}
