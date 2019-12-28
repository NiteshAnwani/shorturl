package com.example.shorturl.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.shorturl.dao.PersonServiceDao;
import com.example.shorturl.model.Person;

@Service
public class PersonService {
	PersonServiceDao personDao;

	@Autowired
	public PersonService(@Qualifier("fakeDao") PersonServiceDao personDao) {
		this.personDao = personDao;
	}
	public int addPerson(Person person) {
		personDao.addPerson(person);
		return 0;
	}
	public List<Person> getPersons() {
		return personDao.getPerson();
	}
	public int updatePersonById(UUID id,Person person)
	{
		if(getPersonById(id).isPresent())
		{
			person.setId(id);
			return personDao.updateById(id, person);
		}
		return 0;
	}
	public Optional<Person> getPersonById(UUID id)
	{
		return personDao.selectById(id);
	}
}
