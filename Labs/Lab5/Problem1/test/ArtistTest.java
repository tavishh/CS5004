import static org.junit.jupiter.api.Assertions.*;

class ArtistTest {
  Musician musician;

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    musician = new Musician("John", "Lennon", 40, new String[]{"Rock"},
                              "EMI", "Abbey Road");
  }

  @org.junit.jupiter.api.Test
  void TestReceiveAward() {
    musician.receiveAward("Grammy");
    assertEquals("Grammy", musician.getAwards()[0]);
  }

  @org.junit.jupiter.api.Test
  void TestGetFirstName() {
    assertEquals("John", musician.getFirstName());
  }

  @org.junit.jupiter.api.Test
  void TestGetLastName() {
    assertEquals("Lennon", musician.getLastName());
  }

  @org.junit.jupiter.api.Test
  void TestGetAge() {
    assertEquals(40, musician.getAge());
  }

  @org.junit.jupiter.api.Test
  void TestGetGenres() {
    assertEquals("Rock", musician.getGenres()[0]);
  }

  @org.junit.jupiter.api.Test
  void TestGetAwards() {
    assertEquals(0,musician.getAwards().length);
  }

  @org.junit.jupiter.api.Test
  void TestInvalidAge(){
    assertThrows(IllegalArgumentException.class, () -> {new Musician("John", "Lennon", 200,
                                                                        new String[]{"Rock"}, "EMI", "Abbey Road");
    });
  }
}