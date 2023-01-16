package io.yelpcode.todoappdemo.service;

import io.yelpcode.todoappdemo.database.TodoRepository;
import io.yelpcode.todoappdemo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo findById(BigInteger id){
        return todoRepository.findById(id).orElse(null);
    }


    public void deleteById(BigInteger id){
        todoRepository.deleteById(id);
    }

    public List<Todo> findAll(){
        return todoRepository.findAll();
    }


}
