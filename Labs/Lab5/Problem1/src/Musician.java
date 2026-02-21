public class Musician extends Artist{
  private String recordingCompany;
  private String lastRecordAlbum;

  public Musician(String firstName, String lastName, int age, String[] genres,
                    String recordingCompany, String lastRecordAlbum){
    super(firstName, lastName, age, genres);
    this.lastRecordAlbum = lastRecordAlbum;
    this.recordingCompany = recordingCompany;
  }

  // Accessors
  public String getRecordingCompany(){
    return recordingCompany;
  }

  public String getLastRecordAlbum(){
    return lastRecordAlbum;
  }

}