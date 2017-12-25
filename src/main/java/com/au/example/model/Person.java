package com.au.example.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "Person")
public class Person {

    private String name;

    private String surname;

}
