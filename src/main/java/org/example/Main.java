package org.example;
import java.util.Date;

public class Main {
  public String hash;
  public String previousHash;
  private String data;
  private long timeStamp;

  public Main(String data, String previousHash) {
      this.data = data;
      this.previousHash = previousHash;
      this.timeStamp = new Date().getTime();
  }
}