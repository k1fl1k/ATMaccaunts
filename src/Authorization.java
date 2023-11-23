import java.io.*;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class Authorization {

    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();

    public void login() {
        System.out.println("1 Реєстрація");
        System.out.println("2 Авторизація");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                handleRegistration();
                break;
            case "2":
                handleDefaultAuthentication();
                break;
            default:
                System.out.println("Спробуй знову");
                login();
        }
    }

    private void handleRegistration() {
        System.out.println("Ваш логін");
        String login = scanner.nextLine();

        if (userExists(login)) {
            System.out.println("Вже існує користувач з такии логіном");
            return;
        }

        System.out.println("Ваш пароль");
        String password = scanner.nextLine();

        BigInteger randomCardNumberEU = generateRandomBigInteger();
        BigInteger randomCardNumberUSA = generateRandomBigInteger();
        BigInteger randomCardNumberUA = generateRandomBigInteger();

        BuilderUser user = new BuilderUser.Builder(login, password)
            .cardnumberEU(randomCardNumberEU)
            .cardnumberUSA(randomCardNumberUSA)
            .cardnumberUA(randomCardNumberUA)
            .build();

        saveToTextFile(user, "user.txt");

        System.out.println("Успішна реєстрація");
        System.out.println();
        System.out.println();
        System.out.println();
        int Choise = scanner.nextInt();

        switch (Choise){
            case 1:
                Cards cards = new Cards();
                cards.Choose(login);
                break;
            case 2:
                System.out.println();
                break;
        }
    }


    public void handleDefaultAuthentication() {
        System.out.println("Введіть логін");
        String login = scanner.nextLine();

        System.out.println("Введіть пароль:");
        String password = scanner.nextLine();

        try {
            BuilderUser user = readFromTextFile("user.txt");

            if (user != null && user.getLogin().equals(login) && user.getPassword().equals(password)) {
                Cards cards = new Cards();
                cards.Choose(login);

            } else {
                System.out.println("Авторизація не вдалась");
                System.out.println("Спробуйте знову або зареєструйтесь");
                login();
            }
        } catch (IOException e) {
            System.err.println("Error handling authentication: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public BuilderUser readFromTextFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 3) {
                    String login = fields[0];
                    String password = fields[1];
                    BigInteger cardnumberEU = new BigInteger(fields[2]);
                    BigInteger cardnumberUSA = new BigInteger(fields[3]);
                    BigInteger cardnumberUA = new BigInteger(fields[4]);

                    return new BuilderUser.Builder(login, password)
                        .cardnumberEU(cardnumberEU)
                        .cardnumberUSA(cardnumberUSA)
                        .cardnumberUA(cardnumberUA)
                        .build();
                }
            }
        }
        return null;
    }

    private static void saveToTextFile(BuilderUser user, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            writer.println(user.getLogin() + "," + user.getPassword() + ","
                + user.getCardnumberEU() + "," + user.getCardnumberUSA() + "," + user.getCardnumberUA());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean userExists(String login) {
        try (BufferedReader reader = new BufferedReader(new FileReader("user.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 1) {
                    String existingLogin = fields[0];
                    if (existingLogin.equals(login)) {
                        return true; // Користувач з таким логіном вже існує
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    private BigInteger generateRandomBigInteger() {
        return new BigInteger(53, random);
    }
}
