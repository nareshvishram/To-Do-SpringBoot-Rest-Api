package com.binarybeast.todoapi.in.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="todo_api")
@NamedQuery(name = "select-all-notes",query = "select t from ToDoModel t")
public class ToDoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @JsonProperty("id")
    private int id;

    @Column(name="title")
    @JsonProperty("title")
    private String title;

    @Column(name="description")
    @JsonProperty("description")
    private String description;

    @Column(name="author")
    @JsonProperty("author")
    private String author;

    @Column(name="place")
    @JsonProperty("place")
    private String place;
}
