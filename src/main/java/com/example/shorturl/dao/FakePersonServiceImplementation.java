package com.example.shorturl.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.shorturl.model.Person;

@Repository("fakeDao")
public class FakePersonServiceImplementation implements PersonServiceDao {

	private ArrayList<Person> person_db = new ArrayList<Person>();

	@Override
	public int insertPerson(Person person) {
		person_db.add(person);
		return 0;
	}

	@Override
	public List<Person> getPerson() {
		return person_db;
	}

	@Override
	public Optional<Person> selectById(UUID id) {
		return person_db.stream().filter(per -> per.getId().equals(id)).findFirst();
	}

	@Override
	public int updateById(UUID id, Person person) {
		selectById(id).map(p -> {
			int personToDelete = person_db.indexOf(p);
			if (personToDelete >= 0)
				person_db.set(personToDelete, person);
			return 1;
		});

		return 0;
	}
}
