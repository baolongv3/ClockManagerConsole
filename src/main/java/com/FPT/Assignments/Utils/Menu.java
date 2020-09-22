package com.FPT.Assignments.Utils;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends ArrayList<String> {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    
    String title;
    Scanner sc = new Scanner(System.in);

    public Menu(String title) {
        this.title = title;
    }
    
    public void addItems(String Item){
        this.add(Item);
    }

    public void printMenu(){
        Integer i = 0;

        System.out.println(title);
    
        for(String menuItem : this){
            System.out.println(String.format("[%d] %s",++i,menuItem));
        }

    }
    
    public Integer getChoice(){
        System.out.print("Your Choice:  ");
        return sc.nextInt();

    }
    
}