public abstract class Artist {
  private String firstName;
  private String lastName;
  private int age;
  private String[] genres;
  private String[] awards;

  public Artist(String firstName, String lastName, int age, String[] genres){
    this.genres = genres;
    this.awards = new String[0];

    if (age < 0 || age > 128){
      throw new IllegalArgumentException("Age must be between 0 and 128!");
    } else {
      this.age = age;
    }

    if (!firstName.matches("[a-zA-Z]+")){
      throw new IllegalArgumentException("First name can only consist of letters!");
    } else {
      this.firstName = firstName;
    }

    if (!lastName.matches("[a-zA-Z]+")){
      throw new IllegalArgumentException("Last name can only consist of letters!");
    } else{
      this.lastName = lastName;
    }

  }


  void receiveAward(String award) {
    if (award == null || award.isEmpty()) {
      throw new IllegalArgumentException("Award cannot be null or empty!");
    } else {
      String[] newAwards = new String[this.awards.length + 1];
      for (int i = 0; i < this.awards.length; i++) {
        newAwards[i] = this.awards[i];
      }
      newAwards[this.awards.length - 1] = award;
      this.awards = newAwards;
    }
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
