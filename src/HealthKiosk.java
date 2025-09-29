import java.util.*;
import static java.lang.Math.*;

public class HealthKiosk {
    public static void main(String[] args) {
            System.out.print("Welcome to Ashesi Health Kiosk")

       //Task 1
        char serviceDesk;
        String service;
        String category;
        double bmi = 0;
        double roundedBmi =0;
        int tOption = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter service code(P/L/T/C): ");
        serviceDesk = Character.toUpperCase(scanner.nextLine().charAt(0));


        switch(serviceDesk){
            case 'P' -> service = "Pharmacy Desk";
            case 'L' -> service = "Lab Desk";
            case 'T' -> service = "Triage Desk";
            case 'C' -> service = "Counseling Desk";
            default -> service = "Invalid service code";
        }
        System.out.println("Go to: "+ service);

        //Task 2

        if(service.equals("Triage Desk")){
            System.out.println("Enter health metric(1 for BMI,2 for Dosage round-up,3 for simple trig helper. ");

             tOption = scanner.nextInt();
             scanner.nextLine();

            switch(tOption){
                case 1 -> {
                    System.out.println("Enter weight(kg): ");
                    double weight = Double.parseDouble(scanner.nextLine());

                    System.out.println("Enter height(m): ");
                    double height = Double.parseDouble(scanner.nextLine());

                    bmi = weight / Math.pow(height, 2);
                    roundedBmi = Math.round(bmi * 10) / 10.0;


                    if(roundedBmi<18.5){
                        category = "Underweight";
                    }
                    else if(roundedBmi<=24.9){
                        category = "Normal";
                    }
                    else if(roundedBmi>=25.0 && roundedBmi<=29.9){
                        category = "Overweight";
                    }
                    else {
                        category = "Obese";
                    }
                    System.out.println("BMI: "+roundedBmi+"  Category: "+category);
                }
                case 2 -> {
                    System.out.println("Enter the required dosage mg: ");
                    double dose = Double.parseDouble(scanner.nextLine());


                    double maxDose = 250.0;
                    int tablet = (int) Math.ceil(dose/maxDose);
                    System.out.println(tablet+" tablet");
                }
                case 3 -> {
                    System.out.println("Enter an angle in degrees: ");
                     double degrees = Double.parseDouble(scanner.nextLine());
                     double toSin = Math.round(Math.sin(Math.toRadians(degrees))*1000)/1000.0;
                     double toCos = Math.round(Math.cos(Math.toRadians(degrees))*1000)/1000.0;
                    System.out.println("sin: "+toSin+"  cos: "+toCos);
                }
            }
        }

        //Task 3
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int index = (int)(Math.random() * alphabet.length());
        char randomChar = alphabet.charAt(index);

        int num1 = (int) (3 + Math.random() * 7);
        int num2 = (int) (3 + Math.random() * 7);
        int num3 = (int) (3 + Math.random() * 7);
        int num4 = (int) (3 + Math.random() * 7);

        String id = Character.toString(randomChar) + num1 + num2 + num3 + num4;
        System.out.println(id);

        if(id.length()!=5){
            System.out.println("Invalid length");
        }
        else if(!Character.isLetter(id.charAt(0))){
            System.out.println("Invalid: first char must be a letter");
        }
        else if(!Character.isDigit(id.charAt(1)) ||
                !Character.isDigit(id.charAt(2)) ||
                !Character.isDigit(id.charAt(3)) ||
                !Character.isDigit(id.charAt(4))){
            System.out.println("Invalid: last 4 must be digits");
        }
        else{
            System.out.println("ID OK");
        }

        //Task 4
        System.out.println("Enter your first name: ");
        String name = scanner.nextLine();

        char baseCode;
        baseCode = Character.toUpperCase(name.charAt(0));
        char shiftedLetter = (char) ('A' +(baseCode - 'A' + 2) % 26);
        String lastTwoChar = id.substring(id.length()-2);
        int roundedMetric = (int)Math.round(roundedBmi);
        String code = Character.toString(shiftedLetter) + lastTwoChar + "-" + roundedMetric;

        System.out.println("Display Code: "+code);

        //Task 5
        switch(serviceDesk){
            case 'P' -> System.out.println("Summary: PHARMACY | "+id+" | "+code);
            case 'T' -> System.out.println("Summary: TRIAGE | "+id+" | "+code);
            case 'L' -> System.out.println("Summary: LAB | "+id+" | "+code);
            case 'C' -> System.out.println("Summary: COUNSELING | "+id+" | "+code);
        }

        scanner.close();
    }
}
