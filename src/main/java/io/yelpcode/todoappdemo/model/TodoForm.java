package io.yelpcode.todoappdemo.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;

public class TodoForm {

    public TodoForm(){}

    public TodoForm(BigInteger id,String title, String description, boolean complete) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.complete = complete;
    }

    private BigInteger id;
    @NotNull(message = "title cannot be empty")
    @Size(min=2, max=250, message="title must be between 2 and 250")
    private String title;
    @NotNull(message = "description cannot be empty")
    @Size(min=2, max =250, message="description must be between 2 and 250")
    private String description;
    private boolean complete;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

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

}
