package com.twu.biblioteca.movie;

import java.util.Objects;

/**
 * Created by zgebru on 18.04.17.
 */
public class Movie {

  private String name;
  private int year;
  private String director;
  private int rating;
  private boolean available;

  public Movie(String name, int year, String director, int rating) {
    this.name = name;
    this.year = year;
    this.director = director;
    this.rating = rating;
    this.available = true;
  }

  public boolean isAvailable() {
    return available;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }




  @Override
  public boolean equals(Object object) {
    Movie movie = (Movie) object;

    return name.equals(movie.name) && year == movie.year && director.equals(movie.director) && rating == movie.rating;
  }




}
