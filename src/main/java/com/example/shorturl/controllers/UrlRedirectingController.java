package com.example.shorturl.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shorturl.services.IdConvertorService;

@RequestMapping("/")
@RestController
public class UrlRedirectingController {

	@Autowired
	IdConvertorService idConvertorService;

	@GetMapping(path = "{hash}")
	public void redirectUrl(@PathVariable String hash,HttpServletRequest req, HttpServletResponse res) {
		//System.out.println(hash+"HASH");
		String redirectUrl = idConvertorService.getUrl(hash);
		//System.out.println(redirectUrl);
		res.addHeader("location", redirectUrl);
		res.setStatus(301);
		//return "redirect:" + redirectUrl;

	}
}
