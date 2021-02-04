package com.binarybeast.todoapi.in.repository;

import com.binarybeast.todoapi.in.model.ToDoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ToDoApiRepository extends JpaRepository<ToDoModel,Integer> {

    @Query("FROM ToDoModel WHERE author= ?1")
    List<ToDoModel> findByAuthorAsc(String author);


    List<ToDoModel> findByTitleAndAuthor(String title,String author);

    List<ToDoModel> findByTitleAndPlace(String title,String place);

    List<ToDoModel> findByAuthorAndPlace(String author,String place);
}
