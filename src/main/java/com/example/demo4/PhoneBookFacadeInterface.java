package com.example.demo4;

import java.util.List;


public interface PhoneBookFacadeInterface {
    String addToPhoneBook( String name, String number, String lastName, Gender gender , TypePhone typePhone,
                           String nationalCode , String date);
    List<String> show();
    String search( String name);
}


