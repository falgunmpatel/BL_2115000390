import org.junit.jupiter.api.*;

class DatabaseConnection {
  public void connect() {
    System.out.println("Connected to the database");
  }

  public void disconnect() {
    System.out.println("Disconnected from the database");
  }
}

public class DatabaseConnectionTest {
  DatabaseConnection databaseConnection;

  @BeforeEach
  public void setUp() {
    databaseConnection = new DatabaseConnection();
    databaseConnection.connect();
  }

  @AfterEach
  public void tearDown() {
    databaseConnection.disconnect();
  }

  @Test
  public void testConnection() {}
}
