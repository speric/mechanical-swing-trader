package com.mechanicalswingtrader.test;

import java.io.*;
import java.net.*;

public class GetCSVFile {
  
  public static void main(String[] args) throws Exception{
    URL url = new URL("http://finance.yahoo.com/d/quotes.csv?s=SIRI&f=sl1d1t1c1ohgv&e=.csv");
    
    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
   
    urlConnection.setRequestMethod("GET");
    urlConnection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
    urlConnection.setRequestProperty("Accept", "");
    urlConnection.setRequestProperty("HTTP-Version", "HTTP/1.0");
    urlConnection.setRequestProperty("Connection", "Keep-Alive");
    urlConnection.setRequestProperty("Host", "finance.yahoo.com:80");

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

    StringBuffer sb = new StringBuffer();
    String line = null;

    try{
      while ((line=bufferedReader.readLine())!= null){
        sb.append(line);
      }
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
   
    bufferedReader.close();

    String stockInformation = sb.toString();
    String[] parsedData = stockInformation.split(",");

    for(int i = 0; i < parsedData.length; i++){
      System.out.println(parsedData[i]);
    }
  }
}