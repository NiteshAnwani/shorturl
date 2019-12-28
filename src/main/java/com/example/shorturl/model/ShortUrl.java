package com.example.shorturl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "SHORTURL")
public class ShortUrl {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "hashurl")
	private String hash;

	@Column(name = "longurl")
	private String longurl;

	@Column(name = "expirydays")
	private int expirydays;

	@Column(name = "lob")
	private String lob;

	
	
	public ShortUrl() {
		
	}

	public ShortUrl(@JsonProperty("longUrl") String longurl,@JsonProperty("expiryDays") int expirydays,@JsonProperty("lob") String lob) {
		this.longurl = longurl;
		this.expirydays = expirydays;
		this.lob = lob;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getLongurl() {
		return longurl;
	}

	public void setLongurl(String longurl) {
		this.longurl = longurl;
	}

	public int getExpirydays() {
		return expirydays;
	}

	public void setExpirydays(int expirydays) {
		this.expirydays = expirydays;
	}

	public String getLob() {
		return lob;
	}

	public void setLob(String lob) {
		this.lob = lob;
	}

}
