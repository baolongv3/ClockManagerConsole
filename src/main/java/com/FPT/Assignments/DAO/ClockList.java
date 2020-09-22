
package com.FPT.Assignments.DAO;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import com.FPT.Assignments.DTO.Clock;
import com.FPT.Assignments.Utils.CheckingUtils;
import com.FPT.Assignments.Utils.Menu;
import com.FPT.Assignments.View.InputModule;

public class ClockList extends LinkedList<Clock> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    InputModule inputUtils = new InputModule();
    Scanner sc = new Scanner(System.in);


    public Integer searchId(String id){
        Integer index = 0;
        Iterator<Clock> iter = this.iterator();
        
        while(iter.hasNext()){
            if(iter.next().getId().equals(id)){
                return index;
            }
            ++index;
        }
        return -1;
    }


    public void addClock(){
        String clockID,clockName;
        Integer gurantee, searchPos;
        Double price;
        
        while(true){

            do{
                clockID = inputUtils.inputID();
                searchPos = searchId(clockID);
                if(searchPos!=-1){
                    System.out.println("ID Existed!");
                }
            }while(searchPos != -1);

            clockName = inputUtils.inputClockName();
            gurantee = inputUtils.inputGurantee();
            price = inputUtils.inputPrice();

            this.add(new Clock(clockID,clockName,price,gurantee));
            if(!CheckingUtils.chooseYN("Do you want to continue adding?")) break;


        }
    }

    public void showUpdateAndDeleteMenu(){
        String clockID;
        Integer clockIdPos;
        if(this.isEmpty()){
            System.out.println("This List Is Empty!");
        } else{
            clockID = inputUtils.inputID();
            
            if((clockIdPos = searchId(clockID)) == -1){
                System.out.println("Cannot find the ID inputted");
            } else{
                Menu UDMenu = new Menu("Update And Delete Menu");

                UDMenu.addItems("Update");
                UDMenu.addItems("Delete");
                
                UDMenu.printMenu();
                Integer choice = UDMenu.getChoice();
                switch(choice){
                    case 1:
                        updateClock(clockIdPos);
                        break;
                    case 2:
                        removeClock(clockIdPos);
                        break;
                }
            }
        }
    }

    private void updateClock(Integer idPos){
        Menu updateMenu = new Menu("Update Menu");
        boolean changed = false;
        updateMenu.addItems("Update Manufacturer");
        updateMenu.addItems("Update Gurantee");
        updateMenu.addItems("Update Price");
        updateMenu.addItems("Exit");


        updateMenu.printMenu();
        Integer choice = updateMenu.getChoice();

        switch(choice){
            case 1:
                String clockName = inputUtils.inputClockName();
                this.get(idPos).setManufacturer(clockName);
                changed = true;
                break;
            case 2:
                Integer gurantee = inputUtils.inputGurantee();
                this.get(idPos).setGurantee(gurantee);
                changed = true;
                break;
            case 3:
                Double price = inputUtils.inputPrice();
                this.get(idPos).setPrice(price);
                changed = true;
                break;

        }
        if(changed){
            System.out.println("Update Successfully!");
        } else{
            System.out.println("Nothing Changed!");
        }




    }


    private void removeClock(Integer idPos){
        if(CheckingUtils.chooseYN("Do you want to delete this record?")){
            this.remove(get(idPos));
            System.out.println("Remove Successfully");
        } else{
            System.out.println("Operation Cancelled");
        }

    }
    
    public void printAllClock(){
        if(isEmpty()){
            System.out.println("The List is Empty!");
        }   
        System.out.println(String.format("%8s | %20s | %30s | %10s","ID","Manufacturer","Gurantee Month","Price"));
        for(Clock clock : this){
            System.out.println(String.format("%8s | %20s | %30d | %10.2f$",clock.getId(),clock.getManufacturer(),clock.getGurantee(),clock.getPrice()));
        }
    }

    public void printClockInRange(){
        Double min,max;
        if(isEmpty()){
            System.out.println("The List is Empty!");
            return;
        }
        System.out.println("Input the minimum price");
        min = sc.nextDouble();
        System.out.println("Input the maximum price");
        max = sc.nextDouble();

        System.out.println(String.format("%8s | %20s | %30s | %10s ","ID","Manufacturer","Gurantee Month","Price"));
        for(Clock clock : this){
            if(clock.getPrice() > min && clock.getPrice() < max){
                System.out.println(String.format("%8s | %20s | %30d | %10.2f$ ",clock.getId(),clock.getManufacturer(),clock.getGurantee(),clock.getPrice()));
            }
        }

    }
}
