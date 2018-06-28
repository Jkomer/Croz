package com.test.test.Controller;

import com.test.test.Entity.Joke;
import com.test.test.Entity.JokeForm;
import com.test.test.Service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Controller
public class JokeController {

    @Autowired
    private JokeService jokeService;


    @GetMapping
    public String getJokeTable(Model model){
        model.addAttribute("jokeList", jokeService.getAllJokes());
        return "index";
    }

    @GetMapping("new")
    public String newJokeForm(Model model){
        model.addAttribute("jokeForm", new JokeForm());
        return "new";
    }

    @PostMapping("/like")
    public String like(@RequestParam Integer id){
        jokeService.addJoke(jokeService.findById(id).setLikeInc());
        return "redirect:/";

    }

    @PostMapping("/dislike")
    public String dislike(@RequestParam Integer id){
        jokeService.addJoke(jokeService.findById(id).setDislikeInc());
        return "redirect:/";

    }

    @PostMapping("new")
    public String newjoke(@ModelAttribute("jokeForm") JokeForm jokeForm){
        jokeService.addJoke(jokeForm);
        return "redirect:/";
    }



}
