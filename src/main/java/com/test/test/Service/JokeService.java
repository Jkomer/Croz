package com.test.test.Service;

import com.test.test.Entity.Joke;
import com.test.test.Entity.JokeForm;
import com.test.test.Repository.JokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;


@Service
public class JokeService {

    @Autowired
    private JokeRepository jokeDataBase;


    public LinkedList<Joke> getAllJokes(){
        LinkedList<Joke> l = new LinkedList<>();
        jokeDataBase.findAll().forEach(j -> l.add(j));

        Collections.sort(l, new Comparator<Joke>() {
            @Override
            public int compare(Joke joke, Joke t1) {
                if(joke.getDifference() < t1.getDifference()) return 1;
                else if(joke.getDifference() > t1.getDifference()) return -1;
                else return 0;
            }
        });

        return l;
    }

    public Joke findById(Integer id){
        LinkedList<Joke> jlist = getAllJokes();
        for(Joke j : jlist){
            if (id.equals(j.getId())){
                return j;
            }
        }
        return null;
    }

    public void addJoke(JokeForm jokeForm){
        Joke joke = new Joke();
        joke.setContent(jokeForm.getContent());
        jokeDataBase.save(joke);
    }

    public void addJoke(Joke joke){
        jokeDataBase.save(joke);
    }

}
