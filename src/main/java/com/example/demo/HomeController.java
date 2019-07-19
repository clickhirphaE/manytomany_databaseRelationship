package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;
@Controller
public class HomeController {
    @Autowired
    ActorRepository actorRepository;

    @RequestMapping("/")
    public String index(Model model){
                                   //first lets create an actor
        Actor actor=new Actor();
        actor.setName("Sandra bullock");
        actor.setRealname("Sandra mae Bullowski");

                                      //now let's create movie
        Movie movie=new Movie();
        movie.setTitle(" Emoji movie");
        movie.setYear(2017);
        movie.setDescription("About emojies..");
                                        //Add the movie to an empty list
        Set<Movie> movies=new HashSet<Movie>();
        movies.add(movie);
                                        //Add the list of movies to the actor's movie list
        actor.setMovies(movies);
                                        //save the actor to the database
        actorRepository.save(actor);
                                        //Grad all the actors from the database and send the to the template
        model.addAttribute("actors",actorRepository.findAll());
           return "index";
    }
}
