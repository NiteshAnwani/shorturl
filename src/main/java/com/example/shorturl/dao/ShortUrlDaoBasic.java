package com.example.shorturl.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shorturl.model.ShortUrl;

@Repository
public interface ShortUrlDaoBasic extends JpaRepository<ShortUrl, Integer>{
	Optional<ShortUrl> findByHash(String hash);
	ShortUrl findByLongurl(String longurl);
}
