package com.binarybeast.todoapi.in.service;

import com.binarybeast.todoapi.in.model.ToDoModel;
import com.binarybeast.todoapi.in.repository.ToDoApiRepository;
import com.binarybeast.todoapi.in.repository.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoApiService {

    @Autowired
    ToDoRepo toDoRepo;

    @Autowired
    ToDoApiRepository t;

    public void insert(ToDoModel toDoModel){
        toDoRepo.insert(toDoModel);
    }

    public List<ToDoModel> getAllNotes(){
        return toDoRepo.getAllNotes();
    }

    public ToDoModel getNoteById(int id){
        return toDoRepo.getNoteById(id);
    }

    public List<ToDoModel> getNoteByAuthor(String author){

        return t.findByAuthorAsc(author);
    }

    public void updateById(int id,ToDoModel toDoModel){
         toDoRepo.updateById(id,toDoModel);
    }

    public List<ToDoModel> findByTitleAndAuthor(String title,String author){
        return t.findByTitleAndAuthor(title,author);
    }
}
