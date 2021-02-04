package com.binarybeast.todoapi.in.controller;

import com.binarybeast.todoapi.in.model.ToDoModel;
import com.binarybeast.todoapi.in.service.ToDoApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/my_todo")
public class Controller implements CommandLineRunner {

    @Autowired
    ToDoApiService toDoApiService;

    @GetMapping("/menu")
    public String welcomeMenu() {
        String menu = "" +
                "<h1>" +
                "This is To Do : Task Management API" +
                "</h1>" +
                "<ol>" +
                "<li><b>my_todo/menu :</b> for viewing full menu<li>" +
                "<li><b>my_todo/add_note :</b> for adding a new note <li>" +
                "<li><b>my_todo/all_notes :</b> for viewing whole added notes<li>" +
                "<li><b>my_todo/note/id :</b> for viewing note with respected Id<li>" +
                "<li><b>my_todo/note/title_author :</b> for viewing full note by title and author name<li>" +
                "<li><b>my_todo/note/author/author_name :</b> for viewing full note by Author name<li>" +
                "</ol>" +
                "";
        return menu;
    }

    @PostMapping("/add_note")
    public void sayHello(@RequestBody ToDoModel toDoModel) {
        toDoApiService.insert(toDoModel);
    }

    @GetMapping("/all_notes")
    public List<ToDoModel> getAllNotes() {
        System.out.println(toDoApiService.getAllNotes());
        return toDoApiService.getAllNotes();
    }

    @GetMapping("/note/{id}")
    public ToDoModel getNotesById(@PathVariable int id) {
        return toDoApiService.getNoteById(id);
    }

    @PutMapping("/update/{id}")
    public void updateById(@PathVariable int id, @RequestBody ToDoModel toDoModel) {
        toDoApiService.updateById(id, toDoModel);
    }

    @GetMapping("/note/author/{author}")
    public List<ToDoModel> getNoteByAutor(@PathVariable String author) {
        return toDoApiService.getNoteByAuthor(String.join(" ",author.split("_")));
    }

    @PostMapping("/note/title_author")
    public List<ToDoModel> getNoteByTitleAndAuthor(@RequestBody ToDoModel toDoModel){
        return toDoApiService.findByTitleAndAuthor(toDoModel.getTitle(),toDoModel.getAuthor());
    }


    @Override
    public void run(String... strings) throws Exception {
        System.out.println(toDoApiService.getAllNotes());


    }


}
