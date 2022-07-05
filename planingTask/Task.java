package com.testarmy.planingTask;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task {
    Scanner scanner = new Scanner(System.in);
    public static String title;
    public static String description;
   // public static Integer priority;
    public static Integer choiceUserPriority;
    public static Boolean choiceUserStatus;
    public static boolean status = true;

    public static void isStatus(){
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Zadanie jeszcze nie zostało ukończone? \n" +
                "Jeśli zadanie nadal trwa wpisz: true \n" +
                "Jeśli zadanie jest zakończone wpisz: false ");
        choiceUserStatus = scanner1.nextBoolean();
        if (status == choiceUserStatus){
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
    public static boolean isStatus2() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Zadanie jeszcze nie zostało ukończone? \n" +
                "Jeśli zadanie nadal trwa wpisz: true \n" +
                "Jeśli zadanie jest zakończone wpisz: false ");
        choiceUserStatus = scanner1.nextBoolean();
        if (status == choiceUserStatus) {
            System.out.println(true);
        } else {
            System.out.println(false);
        } return choiceUserStatus;
    }


    public static int priority() {
        Scanner scanner = new Scanner(System.in);
        Integer[] priorityTab = new Integer[3];
        priorityTab[0] =1;;
        priorityTab[1] =2;
        priorityTab[2] =3;
        System.out.println("Wybierz piorytet zadania (podając cyfre od 1 do 3)");
        System.out.println("1 = Bardzo ważne zadanie " + "2 = Ważne zadanie "
                +"3 = Zadanie do zrobienienia w wolnym czasie ");
        choiceUserPriority = (scanner.nextInt());
        if(choiceUserPriority == 1){
            choiceUserPriority = priorityTab[0];
            System.out.println("Wybrałeś piorytet: Bardzo ważne zadanie");
        } else if (choiceUserPriority == 2){
            choiceUserPriority = priorityTab[1];
            System.out.println("Wybrałeś piorytet: Ważne zadanie");
        } else if (choiceUserPriority == 3) {
            choiceUserPriority = priorityTab[2];
            System.out.println("Wybrałeś piorytet: Zadanie do zrobienienia w wolnym czasie");
        }else {
            System.out.println("Nie dokonłeś wyboru, musisz nadać piorytet");
        }return choiceUserPriority;

    }

//     public static Map<Integer,String> priorityMap = new HashMap<>();
//   priorityMap.
//    public static String getTitle() {
//
//        return title;
//    }
//
//    public void setTitle(String title) {
//
//        this.title = title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Integer getPriority() {
//        return priority;
//    }
//
//    public void setPriority(Integer priority) {
//        this.priority = priority;
//    }
//
//    public boolean isStatus() {
//        return status;
//    }
//
//    public void setStatus(boolean status) {
//        this.status = status;
//    }
}
