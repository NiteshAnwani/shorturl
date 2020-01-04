package com.example.shorturl.services;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.zip.CRC32;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shorturl.dao.ShortUrlDaoBasic;
import com.example.shorturl.model.ShortUrl;

import sun.misc.CRC16;

@Service
public class ShortUrlService {

	@Autowired
	ShortUrlDaoBasic shorturldao;

	public ShortUrl createShortUrl(ShortUrl shorturl) {

		SimpleDateFormat format = new SimpleDateFormat("MMddHHmmssSSS");
		String temp = format.format(new Date()) + shorturldao.count();
		CRC32 crc=new CRC32();
		crc.update(temp.getBytes());
		String finalHash=String.valueOf(crc.getValue());
		shorturl.setHash(finalHash.substring(0, 5));
		shorturldao.save(shorturl);
		return shorturl;
	}

	public Optional<ShortUrl> getByHash(String hash) {
		return shorturldao.findByHash(hash);
	}

	public List<ShortUrl> getAllData() {
		return shorturldao.findAll();
	}
}
