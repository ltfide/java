package learn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class ReadFilesTest {
   
   @Test
   void testReadFile() {
      try {
         File myObj = new File("createbyfile.txt");
         Scanner scanner = new Scanner(myObj);
         while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            System.out.println(data);
         }
         scanner.close();
      } catch (FileNotFoundException e) {
         System.out.println("An error occured.");
         e.printStackTrace();
      }
   }

   @Test
   void testGetFileInfo() {
      File myObj = new File("createbyfile.txt");
      if (myObj.exists()) {
         System.out.println("File name: " + myObj.getName());
         System.out.println("Absolute path: " + myObj.getAbsolutePath());
         System.out.println("Readeable: " + myObj.canRead());
         System.out.println("File size in bytes: " + myObj.length());
      } else {
         System.out.println("The file does not exist.");
      }
   }

   @Test
   void testScratch() {
      System.out.println("Hello" + "");
   }

}
