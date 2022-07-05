package com.testarmy.planingTask;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;


public class Util extends Task {
    public static void createTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj tytuł zadania:");
        title = scanner.nextLine();
        System.out.println("Podaj opis zadania:");
        description = scanner.nextLine();
        //status = true;

    }

    public static String createTask2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj  nowy tytuł zadania:");
        title = scanner.nextLine();
        System.out.println("Podaj nowy opis zadania:");
        description = scanner.nextLine();
        //status = true;
        return title + "\n" + description;
    }

    public static void saveTaskToFile() {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            if (!title.equals("")) {
                File file = new File("03_programowanie_obiektowe/files/newTask2/" + title + ".txt");
                try (FileWriter fileWriter = new FileWriter(file, true)) {
                    fileWriter.write(title + "\n");
                    fileWriter.write(description + "\n");
                    fileWriter.write(choiceUserPriority + "\n");
                    fileWriter.write(choiceUserStatus + "\n");

                    break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else break;

        }
    }

    public static String saveTaskToFile2() {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            if (!title.equals("")) {
                File file = new File("03_programowanie_obiektowe/files/newTask2/" + title + ".txt");
                try (FileWriter fileWriter = new FileWriter(file, true)) {
                    fileWriter.write(title + "\n");
                    fileWriter.write(description + "\n");
                    fileWriter.write(choiceUserPriority + "\n");
                    fileWriter.write(choiceUserStatus + "\n");

                    break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else break;

        }
        return title + "\n" + description + "\n" + choiceUserStatus + "\n" + choiceUserPriority;
    }


    public static void showAllTask() {
        File file = new File("03_programowanie_obiektowe/files/newTask2/");
        Scanner scanner = new Scanner(System.in);
        String[] task = file.list();
        for (int i = 0; i < task.length; i++) {
            System.out.println(i + " - " + task[i]);
        }
    }

    public static void showUniTask() {
        System.out.println("w celu wyświetlenia zadania podaj jego tytuł:");
        Scanner scanner3 = new Scanner(System.in);
        title = scanner3.nextLine();
        File file = new File("03_programowanie_obiektowe/files/newTask2/" + title + ".txt");
        try (Scanner scanner4 = new Scanner(file)) {
            while (scanner4.hasNextLine()) {
                System.out.println(scanner4.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void editionTaskMain() {
        System.out.println("Edycja zadania wymaga podania aktualnego tytułu:");
        Scanner scanner = new Scanner(System.in);
        title = scanner.nextLine();
        File file = new File("03_programowanie_obiektowe/files/newTask2/" + title + ".txt");
        try (Scanner scanner5 = new Scanner(file)) {
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(Util.editionTask());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static void deletionTask() {
        System.out.println("w celu usuniecia zadania podaj jego tytuł:");
        Scanner scanner2 = new Scanner(System.in);
        title = scanner2.nextLine();
        File file = new File("03_programowanie_obiektowe/files/newTask2/" + title + ".txt");
        file.delete();
        System.out.println("Zadanie " + title + " zostało usuniente.");
    }

    public static String deletionTask2() {
        Scanner scanner2 = new Scanner(System.in);
        title = scanner2.nextLine();
        File file = new File("03_programowanie_obiektowe/files/newTask2/" + title + ".txt");
        file.delete();
        return title;
    }

    // DOPISYWANIE NA KOŃCU PLIKU
//      try (FileWriter fileWriter = new FileWriter(file, true))
//    {
//        fileWriter.write("tekst\n");
//    } catch (IOException e) {
//        throw new RuntimeException(e);
//    }
    public static String editionTask() {
        Util.createTask2();
        Task.priority();
        Task.isStatus2();
        Util.saveTaskToFile2();
//        Util.deletionTask2();
        return title + "\n" + description + "\n" + choiceUserStatus + "\n" + choiceUserPriority;
    }

    public static void completionTask() {
        System.out.println("Zamkniecie zadania wymaga podania tytułu zadania, które chcesz zamknąć:");
        Scanner scanner = new Scanner(System.in);
        title = scanner.nextLine();
        File file = new File("03_programowanie_obiektowe/files/newTask2/" + title + ".txt");
        List list = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("03_programowanie_obiektowe/files/newTask2/" + title + ".txt"))) {
            list = bufferedReader.lines().collect(Collectors.toList());

        } catch (IOException exception) {
            exception.printStackTrace();
        }
        System.out.println("Dotychczasowy stan zadania: \n" +
                "true - zadanie nadal trwa \n" +
                "false - zadanie jest już zamknięte");
        System.out.println(list.contains("true"));
        list.set(3, "false");
        System.out.println("Zadanie zostało zamknięte. Aktualny przegląd zadania");
        System.out.println(list);
    }


    public static <T> List<T> filter(List<T> list, Filter<T> filter){
        List<T> result = new ArrayList<>();
        for(T element: list) {
        if(filter.check(element)) {
            result.add(element);
        }
        }
    return result;
    }

    public static void sortAfterInitialLetter(){
        File file = new File("03_programowanie_obiektowe/files/newTask2/");
        System.out.println("Podaj pierszą litere zadań które mają się wyświetlić");
        Scanner scanner = new Scanner(System.in);
        String choiceSort = scanner.nextLine();
        String[] task = file.list();
        List<String> task2 = Arrays.asList(task);
        System.out.println("Zadania na litere " + choiceSort + " to:");
        System.out.println(Util.filter(task2, e -> e.startsWith(choiceSort)));
    }

    public static void sortAfterLength(){
        File file = new File("03_programowanie_obiektowe/files/newTask2/");
        System.out.println("Podaj liczbę liter, aby wyświetlić zadania o tej samej długości nazwy");
        Scanner scanner = new Scanner(System.in);
        Integer choiceLength = scanner.nextInt();
        String[] task = file.list();
        List<String> task2 = Arrays.asList(task);
        System.out.println("Zadania o długości nazwy " + choiceLength + " to:");
        System.out.println(Util.filter(task2, e -> e.length() == (4 + choiceLength)));
    }
}



