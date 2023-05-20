package org.example;

import org.example.model.Director;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class).addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Movie movie = session.get(Movie.class, 7);

            Director director = session.get(Director.class, 1);

            Director pastDirector = movie.getDirector();

            movie.setDirector(director);
            List<Movie> movies = pastDirector.getMovies();

            System.out.println(movies);
            movies.remove(movie);
            pastDirector.setMovies(movies);
            session.persist(movie);
            System.out.println(movies);


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
