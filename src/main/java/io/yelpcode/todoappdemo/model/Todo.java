package io.yelpcode.todoappdemo.model;

import lombok.Data;
import javax.persistence.*;
import java.math.BigInteger;


@Data
@Entity
@Table(name = "todos")
public class Todo {

    public Todo(){}

    public Todo(String title, String description, boolean complete) {
        this.title = title;
        this.description = description;
        this.complete = complete;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private String title;
    private String description;
    private boolean complete;


}
