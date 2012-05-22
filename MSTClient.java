package mst.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MSTClient {
 
  public static void main(String[] args) throws IOException {
    Socket socket = null;
    
    PrintWriter printWriter = null;
    
    BufferedReader bufferedReaderFromServer = null;

    try {
      socket = new Socket("localhost", 5150);

      printWriter = new PrintWriter(socket.getOutputStream(), true);

      bufferedReaderFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      
      System.out.println("Got connection to localhost");

    } catch (Exception e) {
      System.out.println("EXCEPTION: " + e.getMessage());
    }

    BufferedReader bufferedReaderFromClient = new BufferedReader(new InputStreamReader(System.in));

    String inputFromClient = null;

    while((inputFromClient = bufferedReaderFromClient.readLine()) != null){
      System.out.println(inputFromClient);

      printWriter.println(inputFromClient);
    }

    printWriter.close();

    bufferedReaderFromServer.close();

    bufferedReaderFromClient.close();

    socket.close();
  }
}