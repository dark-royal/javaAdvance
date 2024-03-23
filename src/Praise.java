import java.util.Scanner;

public class Praise {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String prompt = """
                Press
                Nokia,
                1 -> Phone book
                2 -> Messages\t
                3 -> Chat
                4 -> Call register
                5 -> Tones
                6 -> Settings
                7 -> Call divert
                8 -> Games
                9 -> Calculator
                10 -> Reminder
                11 -> Clock
                12 -> Profiles
                13 -> SIM services
                """;

        String prompt2 = """
                Press
                1 -> Search
                2 -> Service Nos.
                3 -> Add name
                4 -> Erase
                5 -> Edit
                6 -> Assign tone
                7 -> Send b'card
                8 -> Options
                9 -> Speed dials
                10 -> Voice tags
                """;

        String prompt3 = """
                Press
                1 -> Write messages
                2 -> Inbox
                3 -> Outbox
                4 -> Picture messages
                5 -> Template
                6 -> Smileys
                7 -> Message setting
                8 -> Info service
                9 -> Voice mailbox number
                10 -> Service command editor
                """;

        System.out.println("Enter option:");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println("Phone book");
                System.out.println(prompt2);
                int input1 = scanner.nextInt();
                switch (input1) {
                    case 1:
                        System.out.println("Type of view");
                        break;
                    case 2:
                        System.out.println("Memory status");
                        break;
                    default:
                        System.out.println("Go back");
                        break;
                }
                break;

            case 2:
                System.out.println("Messages");
                System.out.println(prompt3);
                int input2 = scanner.nextInt();
                switch (input2) {
                    case 1:
                        System.out.println("Write messages");
                        break;
                    case 2:
                        System.out.println("Inbox");
                        break;
                    case 3:
                        System.out.println("Outbox");
                        break;
                    case 4:
                        System.out.println("Picture messages");
                        break;
                    case 5:
                        System.out.println("Template");
                        break;
                    case 6:
                        System.out.println("Smileys");
                        break;
                    case 7:
                        System.out.println("Message setting");
                        break;
                    case 8:
                        System.out.println("Info service");
                        break;
                    case 9:
                        System.out.println("Voice mailbox number");
                        break;
                    case 10:
                        System.out.println("Service command editor");
                        break;
                    default:
                        System.out.println("Go back");
                        break;
                }
                break;

            case 3:
                System.out.println("Chat");
                break;

            case 4:
                System.out.println("Call register");
                break;

            case 5:
                System.out.println("Tones");
                break;

            case 6:
                System.out.println("Settings");
                break;

            case 7:
                System.out.println("Call divert");
                break;

            case 8:
                System.out.println("Games");
                break;

            case 9:
                System.out.println("Calculator");
                break;

            case 10:
                System.out.println("Reminder");
                break;

            case 11:
                System.out.println("Clock");
                break;

            case 12:
                System.out.println("Profiles");
                break;

            case 13:
                System.out.println("SIM services");
                break;

            default:
                System.out.println("Invalid option");
                break;

        }
    }
}