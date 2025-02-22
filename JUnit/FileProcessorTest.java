import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import org.junit.jupiter.api.*;

class FileProcessor {
  public void writeToFile(String filename, String content) throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
      writer.write(content);
    }
  }

  public String readFromFile(String filename) throws IOException {
    StringBuilder content = new StringBuilder();

    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        content.append(line).append("\n");
      }
    }
    return content.toString().trim();
  }
}

public class FileProcessorTest {
  FileProcessor fileProcessor;
  String filename;

  @BeforeEach
  public void setUp() {
    fileProcessor = new FileProcessor();
    filename = "testfile.txt";
  }

  @Test
  public void testWriteToFile() throws IOException {
    String content = "Hello, world!";
    fileProcessor.writeToFile(filename, content);
    File file = new File(filename);
    assertTrue(file.exists());
  }

  @Test
  public void testReadFromFile() throws IOException {
    String content = "Hello, world!";
    fileProcessor.writeToFile(filename, content);
    String readContent = fileProcessor.readFromFile(filename);
    assertEquals(content, readContent);
  }

  @Test
  public void testIOException() {
    assertThrows(IOException.class, () -> fileProcessor.readFromFile("nonexistentfile.txt"));
  }

  @AfterEach
  public void tearDown() {
    File file = new File(filename);
    if (file.exists()) {
      file.delete();
    }
  }
}
