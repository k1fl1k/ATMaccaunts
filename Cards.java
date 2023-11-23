import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class Cards {

    private BigInteger cardNumberEU;
    private BigInteger cardNumberUSA;
    private BigInteger cardNumberUA;
    private final Random random = new Random();

    public void readfile() {
        String filePath = "user.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                cardNumberEU = new BigInteger(fields[2]);
                cardNumberUSA = new BigInteger(fields[3]);
                cardNumberUA = new BigInteger(fields[4]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Choose(String login) {
        readfile();
        System.out.println(login);
        System.out.println("Оберіть карточку");
        System.out.println("1 Euro");
        System.out.println("2 USA");
        System.out.println("3 Ua");
        Scanner scanner = new Scanner(System.in);
        int card = scanner.nextInt();

        switch (card) {
            case 1:
                new EuroCard(login, cardNumberEU);
                break;
            case 2:
                new UsaCard(login, cardNumberUSA);
                break;
            case 3:
                new UaCard(login, cardNumberUA);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }


    public class EuroCard {
        private int money;
        public EuroCard(String login, BigInteger cardNumberEU) {
            Random random = new Random();
            this.money = random.nextInt(2000);

            boolean exit = false;

            while (!exit) {
                System.out.println(
                    login + ", Ваша карта " + cardNumberEU + " Баланс на карті " + money + "€");
                System.out.println("1 Зняти гроші");
                System.out.println("2 Поповнити рахунок");
                System.out.println("3 Вихід");

                Scanner scanner = new Scanner(System.in);
                int variant = scanner.nextInt();

                switch (variant) {
                    case 1:
                        withdrawMoney(); // Implement this method
                        break;
                    case 2:
                        addMoney(); // Implement this method
                        break;
                    case 3:
                        exit = true;
                        break;
                    default:
                        System.out.println("Невірний вибір, спробуйте ще раз.");
                }
            }
        }
        public int withdrawMoney() {
            System.out.println("Яку суму зняти");
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();

            if (x > money) {
                System.out.println("Недостатньо на балансі");
            } else {
                money -= x; // Update the instance variable
            }

            return money;
        }
        public int addMoney() {
            System.out.println("Яку суму додати");
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();

            money += x; // Update the instance variable

            return money;
        }
    }

    public class UsaCard {
        private int money;
        public UsaCard(String login, BigInteger cardNumberEU) {
            Random random = new Random();
            this.money = random.nextInt(2000);

            boolean exit = false;

            while (!exit) {
                System.out.println(
                    login + ", Ваша карта " + cardNumberEU + " Баланс на карті " + money + "$");
                System.out.println("1 Зняти гроші");
                System.out.println("2 Поповнити рахунок");
                System.out.println("3 Вихід");

                Scanner scanner = new Scanner(System.in);
                int variant = scanner.nextInt();

                switch (variant) {
                    case 1:
                        withdrawMoney(); // Implement this method
                        break;
                    case 2:
                        addMoney(); // Implement this method
                        break;
                    case 3:
                        exit = true;
                        break;
                    default:
                        System.out.println("Невірний вибір, спробуйте ще раз.");
                }
            }
        }
        public int withdrawMoney() {
            System.out.println("Яку суму зняти");
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();

            if (x > money) {
                System.out.println("Недостатньо на балансі");
            } else {
                money -= x; // Update the instance variable
            }

            return money;
        }
        public int addMoney() {
            System.out.println("Яку суму додати");
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();

            money += x; // Update the instance variable

            return money;
        }
    }

    public class UaCard {
        private int money;
        public UaCard(String login, BigInteger cardNumberEU) {
            Random random = new Random();
            this.money = random.nextInt(200000);

            boolean exit = false;

            while (!exit) {
                System.out.println(
                    login + ", Ваша карта " + cardNumberEU + " Баланс на карті " + money + "₴");
                System.out.println("1 Зняти гроші");
                System.out.println("2 Поповнити рахунок");
                System.out.println("3 Вихід");

                Scanner scanner = new Scanner(System.in);
                int variant = scanner.nextInt();

                switch (variant) {
                    case 1:
                        withdrawMoney(); // Implement this method
                        break;
                    case 2:
                        addMoney(); // Implement this method
                        break;
                    case 3:
                        exit = true;
                        break;
                    default:
                        System.out.println("Невірний вибір, спробуйте ще раз.");
                }
            }
        }
        public int withdrawMoney() {
            System.out.println("Яку суму зняти");
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();

            if (x > money) {
                System.out.println("Недостатньо на балансі");
            } else {
                money -= x; // Update the instance variable
            }

            return money;
        }
        public int addMoney() {
            System.out.println("Яку суму додати");
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();

            money += x; // Update the instance variable

            return money;
        }
    }
}
