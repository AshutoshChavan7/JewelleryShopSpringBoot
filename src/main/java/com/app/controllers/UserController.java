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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AuthResp;
import com.app.dto.BlankRepsonseDto;
import com.app.dto.LoginDTO;
import com.app.dto.OTPVerifyUpdatePassword;
import com.app.dto.ProductDto;
import com.app.dto.UserDTO;
import com.app.entities.Authentication;
import com.app.entities.Customer;
import com.app.entities.Manager;
import com.app.entities.Role;
import com.app.entities.Staff;
import com.app.entities.User;


import com.app.service.UserServices;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
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
	public ResponseEntity<?> processLoginForm(@RequestBody LoginDTO lo) {
		System.out.println("in process login form " + lo.getEmail() + " " + lo.getPassword() );
	
			Authentication auth = userService.validateUser(lo.getEmail(), lo.getPassword());
			
			System.out.println(auth);
			
			long authid=auth.getId();
			
			int i=(int)authid;
			//System.out.println(auth);
//			System.out.println(auth.getRole());
//			System.out.println(auth.getRole()=="Manager");
			
			if(auth!=null) {
			if (auth.getRole().equals("Manager")) {
				System.out.println("inside mananger");
				Manager mgr=userService.fetchManager(auth);
				System.out.println(mgr);
			//	session.setAttribute("user_details", mgr);
			    return new ResponseEntity<>(mgr, HttpStatus.OK);	
				
			}
			else if (auth.getRole().equals("Customer")) {
				Customer cus=userService.fetchCustomer(auth);
			//	session.setAttribute("user_details", cus);
				return new ResponseEntity<>(cus,HttpStatus.OK);
			}
			
			else if (auth.getRole().equals("Staff")) {
				System.out.println("inside staff of user controller");
				Staff stff=userService.fetchStaff(auth);
			//	session.setAttribute("user_details", stff);
				return new ResponseEntity<>(stff,HttpStatus.OK);
			}
			}
			
		
		BlankRepsonseDto rsdto=new BlankRepsonseDto("Invalid Login!! Please retry...");
		
		return new ResponseEntity<>(rsdto,HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/logout")
	public String userLogout(HttpSession session,Model map,HttpServletRequest rq,HttpServletResponse resp)
	{
		System.out.println("in user logout");
		map.addAttribute("user_details", session.getAttribute("user_details"));
		//invalidate session
		session.invalidate();
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
