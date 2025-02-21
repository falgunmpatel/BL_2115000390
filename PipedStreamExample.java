import java.io.*;

class WriterThread extends Thread {
  private PipedOutputStream pos;

  public WriterThread(PipedOutputStream pos) {
    this.pos = pos;
  }

  @Override
  public void run() {
    try {
      String message = "Hello from WriterThread!";
      pos.write(message.getBytes());
      pos.close();
    } catch (IOException e) {
      System.out.println("Error writing data: " + e.getMessage());
    }
  }
}

class ReaderThread extends Thread {
  private PipedInputStream pis;

  public ReaderThread(PipedInputStream pis) {
    this.pis = pis;
  }

  @Override
  public void run() {
    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(pis));
      String receivedMessage = reader.readLine();
      System.out.println("Received: " + receivedMessage);
      pis.close();
    } catch (IOException e) {
      System.out.println("Error reading data: " + e.getMessage());
    }
  }
}

public class PipedStreamExample {
  public static void main(String[] args) {
    try {
      PipedOutputStream pos = new PipedOutputStream();
      PipedInputStream pis = new PipedInputStream(pos);
      WriterThread writer = new WriterThread(pos);
      ReaderThread reader = new ReaderThread(pis);
      writer.start();
      reader.start();
    } catch (IOException e) {
      System.out.println("Error setting up piped streams: " + e.getMessage());
    }
  }
}
