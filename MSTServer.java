package com.mechanicalswingtrader.server.core;

import java.io.*;
import java.net.*;

public class MSTServer {

  public static void main(String[] args) throws IOException {

    final int SERVER_PORT = 5150;

    ServerSocket serverSocket = null;

    try {
      serverSocket = new ServerSocket(SERVER_PORT);

      System.out.println("MechanicalSwingTraderServer now listening on port: " + SERVER_PORT);

    } catch (IOException e) {
      System.err.println("Could not listen on port: " + SERVER_PORT);
    }

    Socket clientSocket = null;

    try {
      clientSocket = serverSocket.accept();

      System.out.println("Socket accepted from: " + clientSocket.getInetAddress());
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }

    PrintWriter clientPrintWriter = new PrintWriter(clientSocket.getOutputStream(), true);

    String inputFromServer = null;
    String inputFromClient = null;

    BufferedReader bufferedReaderFromServer = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader bufferedReaderFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

    while((inputFromClient = bufferedReaderFromClient.readLine()) != null){
      System.out.println("MSG FROM CLIENT: " + inputFromClient);

      break;
    }

    clientPrintWriter.close();

    bufferedReaderFromClient.close();

    bufferedReaderFromServer.close();

    clientSocket.close();

    serverSocket.close();
  }
}