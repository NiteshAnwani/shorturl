package com.example.shorturl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shorturl.dao.ShortUrlDaoBasic;

@Service
public class IdConvertorService {

	@Autowired
	ShortUrlDaoBasic shorturldao;

	public String getUrl(String hash) {
		if (shorturldao.findByHash(hash).isPresent()) {
			return shorturldao.findByHash(hash).get().getLongurl();
		} else {
			return null;
		}
	}
}
