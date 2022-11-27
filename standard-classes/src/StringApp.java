public class StringApp {
    public static void main(String[] args) {
        String name = "Lutfi Dendiansyah";
        String nameLowercase = name.toLowerCase();
        String nameUppercase = name.toUpperCase();

        System.out.println(nameLowercase);
        System.out.println(nameUppercase);
        System.out.println(name.length());
        System.out.println(name.startsWith("Lutfi"));
        System.out.println(name.endsWith("Dendiansyah"));

        String[] names = name.split(" ");
        for (var result : names) {
            System.out.println(result);
        }

        System.out.println("".isEmpty());
        System.out.println(" ".isBlank());
        System.out.println(name.charAt(0));

        char[] chars = name.toCharArray();
        for (char value : chars) {
            System.out.println(value);
        }
    }
}
