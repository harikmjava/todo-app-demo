package io.yelpcode.todoappdemo.controller;

import io.yelpcode.todoappdemo.database.TodoRepository;
import io.yelpcode.todoappdemo.model.Todo;
import io.yelpcode.todoappdemo.model.TodoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;

@Controller
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/")
    public String index(Model model) {
        //List<Todo> todoList = todoRepository.findAll();
        model.addAttribute("todos", todoRepository.findAll());
        model.addAttribute("todoForm", new TodoForm());
        return "index";
    }

    @PostMapping("/todos/create")
    public ModelAndView create(@ModelAttribute("todoForm") TodoForm todoForm, @RequestParam String title, @RequestParam String description) {
        Todo todo = new Todo(todoForm.getTitle(), todoForm.getDescription(), false);
        Todo todo1 = todoRepository.save(todo);
        todoForm.setId(todo1.getId());
        ModelAndView mav = new ModelAndView();
        mav.addObject((TodoForm)todoForm);
        mav.setViewName("redirect:/");
        return mav;
    }

    @PostMapping("/todos/update/{id}")
    public ModelAndView update(@ModelAttribute("todoForm") TodoForm todoForm, @PathVariable BigInteger id) {
        Todo todo = todoRepository.findById(id).orElse(null);
//        todoForm.setDescription(todo.getDescription());
//        todoForm.setTitle(todo.getTitle());
//        todoForm.setComplete(todo.isComplete());For now,
        if (todo != null) {
            todo.setTitle(todoForm.getTitle());
            todo.setDescription(todoForm.getDescription());
            todo.setComplete(todoForm.isComplete());
            todoRepository.save(todo);
        }
        ModelAndView mav = new ModelAndView();
        mav.addObject((TodoForm)todoForm);
        mav.setViewName("redirect:/");
        return mav;
    }

    @PostMapping("/todos/toggle")
    public String toggle(@RequestParam BigInteger id) {
        Todo todo = todoRepository.findById(id).orElse(null);
        if (todo != null) {
            todo.setComplete(!todo.isComplete());
            todoRepository.save(todo);
        }
        return "redirect:/";
    }

    @PostMapping("/todos/delete")
    public String delete(@RequestParam BigInteger id) {
        todoRepository.deleteById(id);
        return "redirect:/";
    }


}
