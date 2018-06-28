package com.test.test.Repository;

import com.test.test.Entity.Joke;
import org.springframework.data.repository.CrudRepository;

public interface JokeRepository extends CrudRepository<Joke,Integer> {

}
