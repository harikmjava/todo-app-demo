package io.yelpcode.todoappdemo.controller;

import io.yelpcode.todoappdemo.model.Todo;
import io.yelpcode.todoappdemo.model.TodoForm;
import io.yelpcode.todoappdemo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;

@Controller
public class TodoController {

    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("todos", todoService.findAll());
        model.addAttribute("todoForm", new TodoForm());
        return "index";
    }

    @PostMapping("/todos/create")
    public String create(@Valid  @ModelAttribute("todoForm") TodoForm todoForm, BindingResult bindingResult, @RequestParam String title, @RequestParam String description) {

        if (bindingResult.hasErrors()) {
            return "redirect:/";
        }
            Todo todo = new Todo(todoForm.getTitle(), todoForm.getDescription(), false);
            Todo todo1 = todoService.save(todo);
            todoForm.setId(todo1.getId());
            return "redirect:/";
    }

    @PostMapping("/todos/toggle/{id}")
    public String toggle( @PathVariable BigInteger id) {
        Todo todo = todoService.findById(id);
        if (todo != null) {
            todo.setComplete(!todo.isComplete());
            todoService.save(todo);
        }
        return "redirect:/";
    }

    @PostMapping("/todos/delete")
    public String delete(@RequestParam BigInteger id) {
        todoService.deleteById(id);
        return "redirect:/";
    }
}
