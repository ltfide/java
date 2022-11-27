import java.util.InputMismatchException;
import java.util.Scanner;
import data.Mahasiswa;
import exception.InvalidInput;

public class Person {
  public static void main(String[] args) {
    try {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Masukkan nama kau: ");
      String name = scanner.nextLine();
      System.out.print("Masukkan umur kau: ");
      int umur = scanner.nextInt();
      System.out.println("Nama kau adalah: " + name + " dan umur kau " + umur + " tahun");
      scanner.close();

      Mahasiswa mahasiswa = new Mahasiswa(name, umur);
      System.out.println(mahasiswa.getName());
    } catch (Exception e) {
      throw new InvalidInput("Input yang di masukkan salah", e);
    }
  }
}