package com.au.example.controller.mvc;

import com.au.example.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("persons")
public class PersonController {


    /**
     * Mvc view example
     * if you don't use @ResponseBody, controller go to view resolver
     *
     * @param name
     * @param model
     * @return
     */
    @RequestMapping(value = "/{name}.view", method = RequestMethod.GET, produces = "application/json")
    public  String getPersonView(@PathVariable String name,Model model) {
        Person person = new Person();
        person.setName(name);
        person.setSurname("a@a.com");
        model.addAttribute(person);
        return "person";
    }


    /**
     * mvc rest json example
     * if you use @ResponseBody, controller create http response
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = "application/json")
    public  @ResponseBody Person getPersonInJSON(@PathVariable String name) {
        Person person = new Person();
        person.setName(name);
        person.setSurname("a@a.com");
        return person;

    }

    /**
     * mvc xml example
     * if you use @ResponseBody, controller create http response
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/{name}.xml", method = RequestMethod.GET, produces = "application/xml")
    public @ResponseBody Person getPersonInXML(@PathVariable String name) {
        Person person = new Person();
        person.setName(name);
        person.setSurname("a@a.com");
        return person;

    }
}


