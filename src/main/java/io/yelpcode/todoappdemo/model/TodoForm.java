package io.yelpcode.todoappdemo.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class TodoForm {

    public TodoForm(){}

    public TodoForm(BigInteger id,String title, String description, boolean complete) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.complete = complete;
    }

    private BigInteger id;
    private String title;
    private String description;
    private boolean complete;


}
