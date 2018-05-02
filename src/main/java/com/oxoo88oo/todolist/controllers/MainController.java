package com.oxoo88oo.todolist.controllers;

import com.oxoo88oo.todolist.entities.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Main controller
 *
 * @author 0x008800
 * @version 1.0
 * @since 2.05.2018
 */

@Controller
public class MainController{

    private List<Task> tasks = new ArrayList<>();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAll(Map<String, List> model){

        model.put("tasks", tasks);
        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("form") Task task){

        if(null != task && null != task.getText() && !task.getText().isEmpty()){
            synchronized (tasks){
                tasks.add(new Task(task.getText()));
            }
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id){

       synchronized (tasks){
            for(int i = 0; i < tasks.size(); i++){
                if(tasks.get(i).getId() == id){
                    tasks.remove(i);
                    break;
                }
            }
       }
       return "redirect:/";
    }
}
