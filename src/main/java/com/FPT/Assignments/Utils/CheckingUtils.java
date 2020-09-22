package com.FPT.Assignments.Utils;

import java.util.Scanner;

public class CheckingUtils {
    static Scanner sc = new Scanner(System.in);

    public static boolean isMonthValid(Integer month){
        if(month < 1 || month > 12){
            return false;
        }       
        return true;
    }

    public static boolean isStringEmpty(String string){
        return string.isEmpty() || string == null;
    }

    public static boolean chooseYN(String message){
        String inputChoice;

        System.out.println("");
        System.out.print(message + "(Y/N):  ");
        do{
            inputChoice = sc.nextLine().toUpperCase();
            if(!inputChoice.equals("Y") && !inputChoice.equals("N")){
                System.out.println("Must be Y/N");
            } else if(inputChoice.equals("Y")){
                return true;
            } else{
                return false;
            }
        }while(true);
        

    }

}