package com.brforte.controller;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.social.facebook.api.UserOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
@RequestMapping("/")
public class FacebookController {

	private Facebook facebook;

	private ConnectionRepository connectionRepository;



	public FacebookController(Facebook facebook, ConnectionRepository connectionRepository) {
		this.facebook = facebook;
		this.connectionRepository = connectionRepository;
	}



	@GetMapping
	public String getfacebookFeeds(Model model) {
		if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
			return "redirect:/connect/facebook";
		}
		PagedList<Post> posts = facebook.feedOperations().getPosts();
		model.addAttribute("profileName", posts.get(0).getFrom().getName());

		UserOperations userOperations = facebook.userOperations();
        String [] fields = { "id", "email",  "first_name", "last_name" };
        
        org.springframework.social.facebook.api.User profile = facebook.fetchObject
                ("me", org.springframework.social.facebook.api.User.class, fields);
	
		
    	model.addAttribute("nome", profile.getFirstName() + " "+profile.getLastName());
    		
		
		model.addAttribute("email", profile.getEmail());
		
		
		model.addAttribute("posts", posts);
		return "profile";
	}
	
//	@GetMapping(path = "/facebook/", produces = "application/hal+json;charset=utf8")
	//	@GetMapping

	public String getfacebookInfo(Model model) {
		PagedList<Post> posts = facebook.feedOperations().getPosts();
		
		System.out.println(">>>>> "+posts.get(0).getFrom().getName());
		model.addAttribute("profileName", posts.get(0).getFrom().getName());
		
		
		
		model.addAttribute("posts", posts);
		return "profile";
	}
	
	
}
