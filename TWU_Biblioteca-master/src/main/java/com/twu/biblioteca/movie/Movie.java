package com.twu.biblioteca.movie;


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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  @Override
  public boolean equals(Object object) {
    Movie movie = (Movie) object;

    return name.equals(movie.name) && year == movie.year && director.equals(movie.director) && rating == movie.rating;
  }




}
