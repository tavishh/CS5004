public abstract class Artist {
  private String firstName;
  private String lastName;
  private int age;
  private String[] genres;
  private String[] awards;

  public Artist(String firstName, String lastName, int age, String[] genres){
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.genres = genres;
    this.awards = new String[0];
  }


  void receiveAward(String award){
    String[] newAwards = new String[this.awards.length+1];
    for (int i =0; i < this.awards.length ; i++){
      newAwards[i] = this.awards[i];
    }
    newAwards[this.awards.length - 1] = award;
    this.awards = newAwards;
  }

  public String getFirstName(){
    return this.firstName;
  }

  public String getLastName(){
    return this.lastName;
  }

  public int getAge(){
    return this.age;
  }

  public String[] getGenres(){
    return this.genres;
  }

  public String[] getAwards(){
    return this.awards;
  }

}
