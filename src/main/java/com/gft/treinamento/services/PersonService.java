package com.gft.treinamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.treinamento.entities.Person;
import com.gft.treinamento.repositories.PersonRepository;

@Service
public class PersonService {
	@Autowired
	PersonRepository personRepository;
	
	
	public Person creatPerson() {
		
		
		Person person = new Person();
		person.setName("Gabriel");
		person.setAge(24);
		person.setStatus(Boolean.TRUE);
		
		return person;
	}
	
	
	public Person savePerson(Person person) {
	return personRepository.save(person);
	}
	
	public Person getPerson(Long id) throws Exception {
		
		Optional<Person> person = personRepository.findById(id);
		
		if(person.isEmpty()) {
			throw new Exception("Person not found!");
		}
			return person.get();
	}
	
	public void deletePerson(Long id) {
		
		personRepository.deleteById(id);
		
	}
	
	public List<Person>listPerson(){
		return personRepository.findAll();
	}
	
}





