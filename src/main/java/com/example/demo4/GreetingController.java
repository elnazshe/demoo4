package com.example.demo4;

import com.example.demo4.dto.*;
import com.example.demo4.dto.ResponseStatus;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.Objects;


@RestController
public class GreetingController {

    List<Person> personList = new ArrayList<>();

    @RequestMapping(value = "/ws/menu/getUserMenu", method = RequestMethod.POST)
    public ResponseDto<MenuItmDto> getUserMenu() {
        MenuItmDto menuItmDto = new MenuItmDto(null, null, null, new ArrayList<MenuItmDto>(Arrays.asList(
                new MenuItmDto(MenuItemType.MENU, "امور کابران", null, new ArrayList<MenuItmDto>(Arrays.asList(
                        new MenuItmDto(MenuItemType.PAGE, "ثبت اطلاعات", new UIPageDto(null, "add.xml"), new ArrayList<MenuItmDto>()),
                        new MenuItmDto(MenuItemType.PAGE, "جستجو", new UIPageDto(null, "search.xml"), new ArrayList<MenuItmDto>()))))
        )));
        return new ResponseDto(ResponseStatus.Ok, menuItmDto, null, null);
    }



    @RequestMapping(value = "/ws/uipage/getPage", method = RequestMethod.POST)
    public ResponseDto<String> getPage(@RequestParam String name) throws IOException {
        return new ResponseDto(ResponseStatus.Ok, readFile(name, StandardCharsets.UTF_8), null, null);
    }

    @RequestMapping(value = "/ws/add", method = RequestMethod.POST)
    public ResponseDto<String> add(@RequestBody Person person) {
        personList.add(person);

        return new ResponseDto(ResponseStatus.Ok, "", "اطلاعات ذخیره شد.", null);
    }

    @RequestMapping(value = "/ws/search", method = RequestMethod.POST)
    public ResponseDto<Person> search(@RequestParam String nationalCode) {

        for (Person person : personList) {
            if (Objects.equals(person.getNationalCode(), nationalCode)) {
                return new ResponseDto(ResponseStatus.Ok, person, null, null);
            }
        }
        return new ResponseDto(ResponseStatus.Error, null, "اطلاعاتی یافت نشد", null);
    }

    @RequestMapping(value = "/ws/searchAll", method = RequestMethod.POST)
    public ResponseDto<Person> searchAll(@RequestParam String name) {
        for (Person person : personList) {
            if (Objects.equals(person.getName(), name)){
                return new ResponseDto(ResponseStatus.Ok, person, null, null);
        }}
            return new ResponseDto(ResponseStatus.Error, null,null,new  ResponseException("یافت نشد") );

    }

    String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(new ClassPathResource(path).getFile().getPath()));
        return new String(encoded, encoding);
    }
    }
