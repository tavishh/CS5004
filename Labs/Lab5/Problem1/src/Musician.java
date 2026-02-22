public class Musician extends Artist{
  private String recordingCompany;
  private String lastRecordAlbum;

  public Musician(String firstName, String lastName, int age, String[] genres,
                    String recordingCompany, String lastRecordAlbum){
    super(firstName, lastName, age, genres);

    if (lastRecordAlbum == null || lastRecordAlbum.isEmpty()){
      throw new IllegalArgumentException("Last Record Album cannot be null or empty!");
    }else {
      this.lastRecordAlbum = lastRecordAlbum;
    }

    if (recordingCompany == null || recordingCompany.isEmpty()){
      throw new IllegalArgumentException("Recording Company cannot be null or empty!");
    }else{
      this.recordingCompany = recordingCompany;
    }
  }

  // Accessors
  public String getRecordingCompany(){

    return recordingCompany;
  }

  public String getLastRecordAlbum(){

    return lastRecordAlbum;
  }

}