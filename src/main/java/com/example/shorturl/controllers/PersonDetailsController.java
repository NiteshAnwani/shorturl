package com.example.shorturl.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.shorturl.model.Person;
import com.example.shorturl.services.PersonService;

@RequestMapping("api/v1/fake/person")
@RestController
public class PersonDetailsController {
	PersonService personService;

	@Autowired
	public PersonDetailsController(PersonService personService) {
		this.personService = personService;
	}

	@PostMapping
	public void postAddPerson(@RequestBody Person person) {
		personService.addPerson(person);
	}

	@GetMapping
	public List<Person> getPerson() {
		return personService.getPersons();
	}
	
	@GetMapping(path = "{id}")
	public Optional<Person> getPersonById(@PathVariable UUID id) {
		return personService.getPersonById(id);
	}
	
	
	@PutMapping(path = "{id}")
	public int updatePersonById(@PathVariable UUID id,@RequestBody Person person)
	{
		return personService.updatePersonById(id, person);
	}
}
