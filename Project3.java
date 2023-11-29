import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LinkShortener {
    private static Map<String, String> linkMapping = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a long URL to shorten (type 'exit' to quit): ");
            String longUrl = scanner.nextLine();

            if (longUrl.equalsIgnoreCase("exit")) {
                break;
            }

            String shortUrl = shortenUrl(longUrl);
            System.out.println("Shortened URL: " + shortUrl);

            // Store the mapping
            linkMapping.put(shortUrl, longUrl);
        }

        System.out.println("Exiting link shortener application.");
    }

    private static String shortenUrl(String longUrl) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(longUrl.getBytes());

            // Convert hash bytes to a shortened string (you may adjust the length)
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }

            return sb.toString().substring(0, 8); // Adjust the length as needed
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}






