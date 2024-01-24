package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.domain.User;
import com.example.app.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {

	private final UserService service;
	
	@GetMapping
	public String showlogin(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@PostMapping
	public String login(
			@Valid User user,
			Errors errors,
			HttpSession session) throws Exception {
		// 入力の不備
		if(errors.hasErrors()) {
			return "login";
		}
		
		//パスワード間違い
		if(!service.isCorrectIdAndPassword(user.getUserId(), user.getPassword())) {
			errors.rejectValue("userId", "error.incorrect_id_password");
			return"login";
		}
		
		// 正しいID/PW
		session.setAttribute("userId", user.getUserId());
		return"redirect:/items";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// セッションを破棄してログインページに遷移
		session.invalidate();
		return "redirect:/";
	}
}
