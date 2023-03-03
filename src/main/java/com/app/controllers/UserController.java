package com.app.controllers;

import java.util.Collection;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AuthResp;
import com.app.dto.LoginDTO;
import com.app.dto.OTPVerifyUpdatePassword;
import com.app.dto.UserDTO;
import com.app.entities.Authentication;
import com.app.entities.Role;
import com.app.entities.User;

import com.app.service.CustomSecurityUserDetails;
import com.app.service.UserServices;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
	// dep : service layer i/f
	
//	@Autowired
//	private AuthenticationManager manager;


	@Autowired
	private JavaMailSender mailSender;
	
//	@Autowired
//	private JwtUtils utils;

//	private Collection<? extends GrantedAuthority> authorities;
//	
	@Autowired
	private UserServices userService;

	public UserController() {
		System.out.println("in def ctor " + getClass());
	}

	// add req handling method to forward the clnt to login form
	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("in show login form ");
		return "/user/login";// LVN --> D.S --> V.R --> /WEB-INF/views/users/login.jsp
	}

	// add req handling method for --authentication n authorization
	@PostMapping("/login")
	public String processLoginForm(@RequestParam String email, 
			@RequestParam String pass, Model map,HttpSession session) {
		System.out.println("in process login form " + email + " " + pass + " " + map);
		try {
			Authentication auth = userService.validateUser(email, pass);
			//System.out.println(auth);
//			System.out.println(auth.getRole());
//			System.out.println(auth.getRole()=="Manager");
			session.setAttribute("user_details", auth);
			if(auth!=null) {
			if (auth.getRole().equals("Manager")) {
				return "redirect:/manager/main";	
				
			}
			else if (auth.getRole().equals("Customer")) {
				return "redirect:/customer/main";
			}
			
			else
				return "redirect:/staff/main";
			}
			
			return "Wrong Credentials please retry";

		} catch (RuntimeException e) {
			System.out.println("err in " + getClass() + " " + e);
			map.addAttribute("mesg", "Invalid Login , Please Retry!!!!");
			return "/users/login";
		}
	}
	
	@GetMapping("/logout")
	public String userLogout(HttpSession session,Model map,HttpServletRequest rq,HttpServletResponse resp)
	{
		System.out.println("in user logout");
		map.addAttribute("user_details", session.getAttribute("user_details"));
		//invalidate session
		session.invalidate();
		//set refresh header : for auto redirection after delay
		resp.setHeader("refresh", "5;url="+rq.getContextPath());
		return "/user/logout";
	}
	
	
//	@PostMapping("/login")
//	public ResponseEntity<?> login(@RequestBody @Valid LoginDTO request) {
//		log.info(request.getEmail());
//		log.info(request.getPassword());
//
//		// Store incoming user details(not yet validated) into Authentication object
//		// Authentication i/f ---> implemented by UserNamePasswordAuthToken
//		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(request.getEmail(),
//				request.getPassword());
//		log.info("auth token " + authToken);
//		try {
//			// authenticate the credentials
//			org.springframework.security.core.Authentication authenticatedDetails = manager.authenticate(authToken) ;
//			log.info("auth token again " + authenticatedDetails);
//			User user = ((CustomSecurityUserDetails) authenticatedDetails.getPrincipal()).getUserDetails();
//			Role userRole = ((CustomSecurityUserDetails) authenticatedDetails.getPrincipal()).getRole();
//			// => auth succcess
//			return ResponseEntity
//					.ok(new AuthResp("AuthAuthResp.java successful!", utils.generateJwtToken(authenticatedDetails), userRole, user));
//		} catch (BadCredentialsException e) { // lab work : replace this by a method in global exc handler
//			// send back err resp code
//			System.out.println("err " + e);
//			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
//		}
//
//	}
	
	
	@PostMapping("/send_otp")
	public ResponseEntity<?> SendOTP(@RequestBody OTPVerifyUpdatePassword update) {
		String destEmail = update.getDestEmail();
		System.out.println("-----------sending otp-----------");
		System.out.println(" Email " + destEmail);
		SimpleMailMessage mesg = new SimpleMailMessage();
		mesg.setTo(destEmail);
		mesg.setSubject("OTP for verification");
		Random ramdom = new Random();
		int otp = ramdom.nextInt(999999);
		mesg.setText("Enter this OTP for verification : " + otp + "\nDo not share it with anyone !!!!!");
		mailSender.send(mesg);
		return ResponseEntity.status(HttpStatus.OK).body(otp);
	}
	
//	@PostMapping("/changepass")
//	public ResponseEntity<?> changePassword(@RequestBody UserDTO userDto) {
//		if (userService.updatePass(userDto)) {
//			String destEmail = userDto.getEmail();
//			SimpleMailMessage msg = new SimpleMailMessage();
//			msg.setTo(destEmail);
//			msg.setSubject("Password Changed Successfully!!");
//			msg.setText(
//					"Hi You have successfully changed your password , now you can use new password to access the website \n"
//							+ "\n If this is not done by you Please reply us or send email on royaltravelsbookings@gmail.com immediately.\n\n Happy Journey, Keep Traveling");
//			mailSender.send(msg);
//			return new ResponseEntity<>(HttpStatus.OK);
//		}
//		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
//	}

}
