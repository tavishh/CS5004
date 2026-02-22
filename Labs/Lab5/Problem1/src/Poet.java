public class Poet extends Artist{
  private String publishingCompany;
  private String lastPublishedCollection;

  public Poet(String firstName, String lastName, int age, String[] genres,
                    String publishingCompany, String lastPublishedCollection) {
    super(firstName, lastName, age, genres);
    if (lastPublishedCollection == null || lastPublishedCollection.isEmpty()) {
      throw new IllegalArgumentException("Last Published Collection cannot be null or empty!");
    } else {
      this.lastPublishedCollection = lastPublishedCollection;
    }

    if (publishingCompany == null || publishingCompany.isEmpty()) {
      throw new IllegalArgumentException("Publishing Company cannot be null or empty!");
    } else {
      this.publishingCompany = publishingCompany;
    }
  }

  // Accessors
  public String getPublishingCompany(){

    return publishingCompany;
  }

  public String getLastPublishedCollection(){

    return lastPublishedCollection;
  }

}