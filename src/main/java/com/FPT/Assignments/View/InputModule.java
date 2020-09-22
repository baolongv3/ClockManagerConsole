package com.FPT.Assignments.View;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.FPT.Assignments.Utils.CheckingUtils;

public class InputModule {
    Scanner sc = new Scanner(System.in);


    public String inputID(){
        String clockID;
        while(true){
                System.out.print("Input Clock ID:  ");
                clockID = sc.nextLine();
            if(CheckingUtils.isStringEmpty(clockID)){
                System.out.println("Clock ID cannot be empty");
            } else{
                break;
            }

            
        }
        return clockID;
    }

    public String inputClockName(){
        String clockName;
        while(true){
            System.out.println("");
            System.out.print("Input Manufacturer: ");
            clockName = sc.nextLine();

            if(CheckingUtils.isStringEmpty(clockName)){
                System.out.println("Manufacturer cannot be empty");
            } else{
                break;
            }

            
        }
        return clockName;
    }

    public Double inputPrice(){
        Double price = 0.0;
        boolean isValid = false;
        do{
            try{
                price = 0.0;
                System.out.println("");
                System.out.print("Input Price: ");
                price = sc.nextDouble();
                isValid = true;
            }catch(InputMismatchException e) {
                System.out.println("Price is not valid, try again");
                if(sc.hasNext()){
                    sc.nextLine();
                }
                isValid = false;
            }
            
            
        }while(!isValid);
        return price;
    }


    public Integer inputGurantee(){

        Integer gurantee = 0;
        boolean isValid = false;

        do{
            try{
                gurantee = 0;
                System.out.println("");
                System.out.print("Input Gurantee: ");
               
                gurantee = sc.nextInt();
                
                isValid = true;

            }catch(InputMismatchException e){
                System.out.println("Input is not valid");
                if(sc.hasNext()){
                    sc.nextLine();
                }
                isValid = false;
            }
        }while(!isValid);
        
        return gurantee;
       
    }
}