package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Movie")
public class Movie {
    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movie_id;
    @Column(name = "name")
    private String name;
    @Column(name = "year_of_production")
    private int year_of_production;
    @ManyToOne
    @JoinColumn(name = "director_id", referencedColumnName = "director_id")
    private Director director;

    public Movie() {
    }

    public Movie(String name, int year_of_production, Director director) {
        this.name = name;
        this.year_of_production = year_of_production;
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }


    public int getYearOfProduction() {
        return year_of_production;
    }

    public void setYearOfProduction(int year_of_production) {
        this.year_of_production = year_of_production;
    }

    @Override
    public String toString() {
        return "Movie: " + name + ", director=" + director;
    }
}
