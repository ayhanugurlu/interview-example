package com.au.example.controller.rest;

import com.au.example.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/rest/persons")
public class PersonRestController {

    /**
     *
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/1/{name}", method = RequestMethod.GET, produces = "application/json")
    public Person getPersonInJSON(@PathVariable String name) {
        Person person = new Person();
        person.setName(name);
        person.setSurname("a@a.com");
        return person;
    }


    @RequestMapping(value = "/2/{name}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Person> getPersonInJSONResponseEntity(@PathVariable String name) {
        Person person = new Person();
        person.setName(name);
        person.setSurname("a@a.com");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(person);
    }

    @RequestMapping(value = "/{name}.xml", method = RequestMethod.GET, produces = "application/xml")
    public Person getPersonInXML(@PathVariable String name) {
        Person person = new Person();
        person.setName(name);
        person.setSurname("a@a.com");
        return person;

    }
}


