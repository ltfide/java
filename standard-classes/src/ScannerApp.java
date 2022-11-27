import java.util.Scanner;

public class ScannerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nama: ");
        String nama = scanner.nextLine();

        System.out.println("Umur: ");
        int umur = scanner.nextInt();

        System.out.println("Nama saya adalah " + nama + " dan umur saya " + umur + " tahun");
    }
}
