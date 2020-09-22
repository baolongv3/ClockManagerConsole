package com.FPT.Assignments;

import com.FPT.Assignments.DAO.ClockList;
import com.FPT.Assignments.Utils.Menu;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Menu menu = new Menu("App Menu");
        ClockList clockList = new ClockList();
        
        menu.addItems("Add New Clock");
        menu.addItems("Update or Remove a Clock");
        menu.addItems("List all the clock");
        menu.addItems("List all the clock in the money range");
        menu.addItems("Exit");
        while(true){
            menu.printMenu();
            Integer choice = menu.getChoice();
            switch(choice){
                case 1:
                    clockList.addClock();
                    break;
                case 2:
                    clockList.showUpdateAndDeleteMenu();
                    break;
                case 3:
                    clockList.printAllClock();
                    break;
                case 4:
                    clockList.printClockInRange();
                    break;
                default:
                    System.out.println("App Exited!");
                    return;
            }
        }


    }
}
