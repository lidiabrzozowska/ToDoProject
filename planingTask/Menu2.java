package com.testarmy.planingTask;

import java.util.Scanner;

public interface Menu2{
    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        int createTask = 1;
        int reviewTask = 2;
        int editionTask = 3;
        int deletionTask = 4;
        int completionTask = 5;

        
        System.out.println("PlaningTask Menu:");
        System.out.println(
                " 1. Tworzenie nowych zadań.\n 2. Podgląd wszystkich zadań. \n 3. Edycja zadań. " +
                        "\n 4. Usuwanie zadań. \n 5. Ukończenie zadania.");
        System.out.println("wybierz pozycje z menu (podając cyfre od 1 do 5)");
        int choiceUser = (scanner.nextInt());
        if (choiceUser == 1){
            Util.createTask();
            Task.priority();
            Task.isStatus();
            Util.saveTaskToFile();
       } else if (choiceUser == 2){
            System.out.println("jeśli chcesz wyświetlić wszytkie tytuły zadań wybierz 6 \n"
                    + "jeśli chcesz wyświetlić jedno całe zadanie wybierz 7\n"
                    + "jeśli chcesz wyświetlić zadania zaczynjące sie na tą samą literę wybierz 8 \n"
                    + "jeśli chcesz wyświetlić zadania o tej samej długości nazwy wybierz 9");
            int choiceUserSort = (scanner.nextInt());
            if(choiceUserSort == 6){
            Util.showAllTask();
            }else if (choiceUserSort == 7){
            Util.showUniTask();
            }else if (choiceUserSort == 8){
                Util.sortAfterInitialLetter();
            }else if (choiceUserSort == 9){
                Util.sortAfterLength();
            }else
                System.out.println("narazie tyle2");
        } else if (choiceUser == 3) {
            Util.editionTaskMain();
        } else if (choiceUser == 4) {
            Util.deletionTask();
       } else if (choiceUser == 5) {
            Util.completionTask();
        }else {
            System.out.println("wybierz pozycje z menu (podając cyfre od 1 do 5)");
        }
    }
}
