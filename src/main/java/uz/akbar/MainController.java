package uz.akbar;

import java.util.Scanner;

/**
 * MainController
 */
public class MainController {

    private Scanner sc = new Scanner(System.in);

    public void start() {

        new TableRepository().createTables();

        InitService initService = new InitService();
        initService.initAdmin();
        initService.initTestStudent();

        boolean loop = true;
        while (loop) {

            showMenu();
            int action = getAction();
            System.out.println();

            switch (action) {
                case 1:
                    System.out.println("Book list");
                    break;
                case 2:
                    System.out.println("Search");
                    break;
                case 3:
                    System.out.println("By Category");
                    break;
                case 4:
                    login();
                    break;
                case 5:
                    System.out.println("Registration");
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    System.out.println();
                    loop = false;
                    break;

                default:
                    System.out.println("Wrong input!");
                    break;
            }
        }

        sc.close();
    }

    public void showMenu() {
        System.out.println();
        System.out.println("*** Main Menu ***");
        System.out.println("1. Book List");
        System.out.println("2. Search");
        System.out.println("3. By Category");
        System.out.println("4. Login");
        System.out.println("5. Registration");
        System.out.println("0. Exit");
    }

    public int getAction() {
        System.out.print("Enter action => ");
        return sc.nextInt();
    }

    public void login() {
        sc = new Scanner(System.in);
        System.out.print("Enter login => ");
        String login = sc.nextLine();

        System.out.print("Enter password => ");
        String password = sc.nextLine();

        new AuthService().login(login, password);
    }
}
