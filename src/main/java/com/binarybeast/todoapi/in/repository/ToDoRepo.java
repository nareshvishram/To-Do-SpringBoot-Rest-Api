package com.binarybeast.todoapi.in.repository;

import com.binarybeast.todoapi.in.model.ToDoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ToDoRepo {

    @Autowired
    EntityManager entityManager;

    public void insert(ToDoModel toDoModel){

        entityManager.merge(toDoModel);
    }

    public List<ToDoModel> getAllNotes(){

        return entityManager.createNamedQuery("select-all-notes",ToDoModel.class).getResultList();
    }

    public ToDoModel getNoteById(int id){
        return entityManager.find(ToDoModel.class,id);
    }

    public void updateById(int id, ToDoModel toDoModel){
        entityManager.merge(toDoModel);
    }

    public ToDoModel getNoteByAuthor(String author){
        return entityManager.find(ToDoModel.class,author);
    }
}
