package com.example.shorturl.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.shorturl.model.Person;

public interface PersonServiceDao {
	public int insertPerson(Person person);
	public List<Person> getPerson();
	public Optional<Person> selectById(UUID id);
	public int updateById(UUID id,Person person);
	default int addPerson(Person person) {
		person.setId(UUID.randomUUID());
		return insertPerson(person);
	}
	
}
