package io.yelpcode.todoappdemo.model;

import javax.persistence.*;
import java.math.BigInteger;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    private String description;
    private boolean complete;


    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }
}
