package uz.akbar;

import java.util.Scanner;

public class StudentController {
    private final Scanner sc = new Scanner(System.in);

    public void start() {
        boolean loop = true;
        while (loop) {

            showMenu();
            int action = getAction();
            System.out.println();

            switch (action) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    //
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 0:
                    loop = false;
                    break;

                default:
                    System.out.println("Wrong input!");
                    break;
            }
        }
    }

    public void showMenu() {
        System.out.println("*** Student Menu ***");
        System.out.println("1. Book list");
        System.out.println("2. Search");
        System.out.println("3. Take book");
        System.out.println("4. Return book");
        System.out.println("5. Books on hand");
        System.out.println("6. Taken books history");
        System.out.println("0. Exit");
    }

    public int getAction() {
        System.out.print("Enter action => ");
        return sc.nextInt();
    }
}
