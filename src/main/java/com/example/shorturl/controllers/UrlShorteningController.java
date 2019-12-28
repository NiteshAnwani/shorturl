package com.example.shorturl.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shorturl.ShorturlApplication;
import com.example.shorturl.dao.ShortUrlDaoBasic;
import com.example.shorturl.model.ShortUrl;
import com.example.shorturl.services.ShortUrlService;

@RequestMapping("api/v1/fake/shorturl")
@RestController
public class UrlShorteningController {

	@Autowired
	ShortUrlService shortUrlService;
	private HashMap<String, Object> response;

	@GetMapping
	public List<ShortUrl> getShortUrl() {
		return shortUrlService.getAllData();
	}

	@PostMapping
	public HashMap<String, Object> postShortUrl(@RequestBody ShortUrl shorturl) {
		ShortUrl shorturlCreated = shortUrlService.createShortUrl(shorturl);
		response = new HashMap<String, Object>();
		response.put("ShortUrl", "http://localhost:8080/"+shorturlCreated.getHash());
		response.put("LongUrl", shorturlCreated.getLongurl());
		response.put("Lob", shorturlCreated.getLob());
		response.put("Id", shorturlCreated.getId());
		response.put("Hash", shorturlCreated.getHash());
		return response;
	}

	@GetMapping(path = "{hash}")
	public HashMap<String, Object> getLongUrl(@PathVariable String hash) {
		Optional<ShortUrl> result = shortUrlService.getByHash(hash);
		if (shortUrlService.getByHash(hash).isPresent()) {
			response = new HashMap<String, Object>();
			response.put("Hash", result.get().getHash());
			response.put("LongUrl", result.get().getLongurl());
			response.put("Lob", result.get().getLob());
			response.put("shortUrl", "http://localhost:8080/" + result.get().getHash());
			return response;
		} else {
			return null;
		}
	}
}
