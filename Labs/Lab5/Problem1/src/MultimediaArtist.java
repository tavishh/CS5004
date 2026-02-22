public abstract class MultimediaArtist extends Artist{
  private String[] movies;
  private String[] series;
  private String[] otherMultimedia;


  public MultimediaArtist(String firstName, String lastName, int age, String[] genres,
                            String[] movies, String[] series, String[] otherMultimedia){
    super(firstName, lastName, age, genres);

    this.movies = movies;
    this.series = series;
    this.otherMultimedia = otherMultimedia;
  }

  // Accessors
  public String[] getMovies(){

    return this.movies;
  }

  public String[] getSeries(){

    return this.series;
  }

  public String[] getOtherMultimedia(){

    return this.otherMultimedia;
  }

}
