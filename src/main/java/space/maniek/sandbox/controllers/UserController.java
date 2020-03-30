package space.maniek.sandbox.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    private final RepositoryController repositoryController;

    @Autowired
    public UserController(RepositoryController repositoryController) {
        this.repositoryController = repositoryController;
    }

    public void beforeEach(){

    }

    @GetMapping("/")
    public String index(Model model) {
        
        List<String> history = repositoryController.getHistory();

        model.addAttribute("message", "Welcome!");
        model.addAttribute("tasks", history);



        return "index";
    }
}