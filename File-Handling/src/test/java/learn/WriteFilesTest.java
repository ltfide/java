package learn;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class WriteFilesTest {

   @Test
   void testCreateByFile() {
      try {
         File myObj = new File("createbyfile.txt");
         if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
         } else {
            System.out.println("File already exist.");
         }
      } catch (IOException e) {
         System.out.println("An error occured.");
         e.printStackTrace();
      }
   }

   @Test
   void testWriteByFilwWriter() {
      try {
         FileWriter myWriter = new FileWriter("filewriter.txt");
         myWriter.write("Files in java might be tricky, but its fun enough!");
         myWriter.close();
         System.out.println("Successfully wrote to the file.");
      } catch (IOException e) {
         System.out.println("An error occured.");
         e.printStackTrace();
      }
   }
   
}
