public abstract class VisualArtist extends Artist {
  private String[] exhibits;

  public VisualArtist(String firstName, String lastName, int age, String[] genres,
                        String[] exhibits){
    super(firstName, lastName, age, genres);

    this.exhibits = exhibits;
  }

  // Accessors
  public String[] getExhibits(){
    return this.exhibits;
  }

}
