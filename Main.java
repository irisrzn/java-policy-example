import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    @SuppressWarnings({ "removal", "deprecation" })
	public static void main(String[] args) {
        System.setSecurityManager(new SecurityManager()); // Setează un SecurityManager

        File file = new File("D:\\test.txt");

        try {
            if (file.exists() && file.canRead()) {
                System.out.println("Citirea din fișier permisă.");
            } else {
                System.out.println("Citirea din fișier interzisă. Verificați politica de securitate.");
            }

            if (file.exists() && file.canWrite()) {
                System.out.println("Scrierea în fișier permisă.");

                try (FileWriter writer = new FileWriter(file)) {
                    writer.write("Date scrise în fișier.");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println("Scrierea în fișier interzisă. Verificați politica de securitate.");
            }

        } catch (SecurityException e) {
            System.out.println("Eroare de securitate: " + e.getMessage());
        }
    }
}
