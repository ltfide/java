public class StringBuilderApp {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("Lutfi");
        builder.append(" ");
        builder.append("Dendiansyah");

        System.out.println(builder);
        String fullName = builder.toString();
        System.out.println(fullName);
    }
}
