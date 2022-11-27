package learn.java;

import java.io.File;
import java.io.IOException;

public class WriteFile {
   public static void main(String[] args) {
      try {
         File myObj = new File("notes.txt");
         if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
         } else {
            System.out.println("File already exist.");
         }
      } catch (IOException e) {
         System.out.println("An error occured");
         e.printStackTrace();
      }
   }
}
