package com.example.demo4;

import java.util.ArrayList;
import java.util.List;

public class ServiceImpl {


    List<Person> personList =new ArrayList<>();

    public String addToPhoneBook( String name, String number, String lastName, Gender gender , TypePhone typePhone,
                                  String nationalCode , String date) {
        personList.add(new Person(name,number,lastName,gender,typePhone , nationalCode , date));
        return "successfully added";
    }

    public List<String> show() {

        List<String> myList = new ArrayList<>();
        for (int i = 0; i < personList.size(); i++) {
            myList.add(personList.get(i).toString());
        }

        return myList;

    }

    public String search( String name) {

        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getName().equals(name))
               return this.personList.get(i).toString();

        }
        return "Not Founded";
    }

}

