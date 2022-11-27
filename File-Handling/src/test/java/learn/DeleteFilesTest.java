package learn;

import java.io.File;

import org.junit.jupiter.api.Test;

public class DeleteFilesTest {

   @Test
   void testDeleteFile() {
      File myObj = new File("notes.txt");
      if (myObj.delete()) {
         System.out.println("Deleted the file: " + myObj.getName());
      } else {
         System.out.println("Failed to delete the file.");
      }
   }

   @Test
   void testDeleteFolder() {
      File myObj = new File("E:\\Pustaka\\Java\\File-Handling\\newFolder");
      if (myObj.delete()) {
         System.out.println("Deleted the folder: " + myObj.getName());
      } else {
         System.out.println("Failed to delete the folder.");
      }
   }

}
