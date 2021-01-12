package doctor;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static WaitingList waitingList = new WaitingList();


    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printControls();
        while (!quit) {
            System.out.println("Dr's surgery, Welcome what would you like to do:     ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printControls();
                    break;
                case 1:
                    arrivePatient();
                    break;
                case 2:
                    signPatientOut();
                    break;
                case 3:
                    changePatientDetails();
                case 4:
                    lookUpPatient();
                    break;
                case 5:
                    waitingList.printWaitingList();
                    break;
                case 6:
                    quit = true;
                default:
                    System.out.println("Sorry incorrect input");
                    break;
            }
        }
    }




    public static void arrivePatient() {
        System.out.print("Please enter Patient Name:    ");
        waitingList.bookPatient(scanner.nextLine());
    }

    public static void changePatientDetails() {
        System.out.println("Enter patient Name:  ");
        String patient = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter New Item: ");
        String updatedPatientInfo = scanner.nextLine();
        waitingList.modifyItem(patient, updatedPatientInfo);
    }

    public static void signPatientOut() {
        System.out.println("Enter patient to sign out:  ");
        String patientName = scanner.nextLine();
       // scanner.nextLine();
        waitingList.removePatient(patientName);
    }

    public static void lookUpPatient() {
        System.out.print("Enter patient's name: ");
        String searchPatient = scanner.nextLine();
        if (waitingList.onSystem(searchPatient)) {
            System.out.println(searchPatient + "On System");
        } else {
            System.out.println(searchPatient + "is not on System.");
        }
    }

        public static void printControls () {
            System.out.println("\n Controls");
            System.out.println("\t 0 - Show controls.");
            System.out.println("\t 1 - Arrive Patient.");
            System.out.println("\t 2 - SignOut Patient.");
            System.out.println("\t 3 - Change Patient Name.");
            System.out.println("\t 4 - Search Patient.");
            System.out.println("\t 5 - Show Waiting List.");
            System.out.println("\t 6 - Close System.");
    }
}






