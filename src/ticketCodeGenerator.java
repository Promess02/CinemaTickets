import java.util.HashSet;
import java.util.Random;
import java.util.Set;
public class ticketCodeGenerator {
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int STRING_LENGTH = 10;
    private static final Set<String> usedStrings = new HashSet<>();
    private static final Random random = new Random();

    public static String generateTicketCode() {
        String randomString;
        do {
            randomString = generateRandomString();
        } while (usedStrings.contains(randomString));
        usedStrings.add(randomString);
        return randomString;
    }

    private static String generateRandomString() {
        StringBuilder sb = new StringBuilder(STRING_LENGTH);
        for (int i = 0; i < STRING_LENGTH; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
}
