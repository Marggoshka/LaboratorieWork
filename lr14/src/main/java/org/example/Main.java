package org.example;
import java.io.*;
import java.util.*;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("ВАРИАНТ 10");
        System.out.println("1. Информация о будущей профессии");
        System.out.println("2. Числа больше среднего арифметического");
        System.out.println("3. Разделение трёхзначных чисел");
        System.out.println("4. Средняя масса тела");
        System.out.println("5. Числа, оканчивающиеся на 5");

        System.out.print("Выберите задание: ");
        int choice = input.nextInt();
        input.nextLine();

        switch (choice) {
            case 1:
                task1();
                break;
            case 2:
                task2();
                break;
            case 3:
                task3();
                break;
            case 4:
                task4();
                break;
            case 5:
                task5();
                break;
            default:
                System.out.println("Неверный номер задания");
        }
    }

    // Задание 1
    static void task1() throws IOException {

        File file = new File("profession.txt");

        System.out.print("Введите информацию о будущей профессии: ");
        String profession = input.nextLine();

        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println(profession);
        }

        System.out.println("\nИнформация о файле:");
        System.out.println("Имя: " + file.getName());
        System.out.println("Путь: " + file.getAbsolutePath());
        System.out.println("Размер: " + file.length());
        System.out.println("Существует: " + file.exists());

        System.out.println("\nСодержимое файла:");

        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
        }
    }

    // Задание 2
    static void task2() throws IOException {

        File file = new File("f.txt");

        try (PrintWriter writer = new PrintWriter(file)) {

            System.out.println("Введите 10 целых чисел:");

            for (int i = 0; i < 10; i++) {
                int number = input.nextInt();
                writer.println(number);
            }
        }

        int sum = 0;
        int count = 0;

        try (Scanner reader = new Scanner(file)) {

            while (reader.hasNextInt()) {
                int number = reader.nextInt();

                System.out.println(number);

                sum += number;
                count++;
            }
        }

        double average = (double) sum / count;
        int result = 0;

        try (Scanner reader = new Scanner(file)) {

            while (reader.hasNextInt()) {
                int number = reader.nextInt();

                if (number > average) {
                    result++;
                }
            }
        }

        System.out.println("Среднее арифметическое: " + average);
        System.out.println("Количество чисел больше среднего: " + result);
    }

    // Задание 3
    static void task3() throws IOException {

        File fileF = new File("f.txt");
        File fileG = new File("g.txt");
        File fileH = new File("h.txt");

        Random random = new Random();

        try (PrintWriter writer = new PrintWriter(fileF)) {

            for (int i = 0; i < 20; i++) {
                int number = random.nextInt(2001) - 1000;
                writer.println(number);
            }
        }

        try (
                Scanner reader = new Scanner(fileF);
                PrintWriter writerG = new PrintWriter(fileG);
                PrintWriter writerH = new PrintWriter(fileH)
        ) {

            while (reader.hasNextInt()) {

                int number = reader.nextInt();

                if (Math.abs(number) >= 100 &&
                        Math.abs(number) <= 999) {

                    writerG.println(number);

                } else {
                    writerH.println(number);
                }
            }
        }

        System.out.println("Файл g.txt — трёхзначные числа:");
        printFile(fileG);

        System.out.println("\nФайл h.txt — остальные числа:");
        printFile(fileH);
    }

    // Задание 4
    static void task4() throws IOException {

        File file = new File("mass.txt");

        try (PrintWriter writer = new PrintWriter(file)) {

            System.out.println("Введите массу тела 12 человек:");

            for (int i = 0; i < 12; i++) {
                double mass = input.nextDouble();
                writer.println(mass);
            }
        }

        double sum = 0;
        int count = 0;

        try (Scanner reader = new Scanner(file)) {

            while (reader.hasNextDouble()) {
                double mass = reader.nextDouble();

                sum += mass;
                count++;
            }
        }

        double average = sum / count;

        System.out.println("Средняя масса тела: " + average);
    }

    // Задание 5
    static void task5() throws IOException {

        File file = new File("numbers.txt");

        try (PrintWriter writer = new PrintWriter(file)) {

            System.out.println("Введите 10 целых чисел:");

            for (int i = 0; i < 10; i++) {
                int number = input.nextInt();
                writer.println(number);
            }
        }

        int count = 0;

        try (Scanner reader = new Scanner(file)) {

            while (reader.hasNextInt()) {

                int number = reader.nextInt();

                System.out.println(number);

                if (Math.abs(number) % 10 == 5) {
                    count++;
                }
            }
        }

        System.out.println("Количество чисел, оканчивающихся на 5: " + count);
    }

    // Вывод содержимого файла
    static void printFile(File file) throws IOException {

        try (Scanner reader = new Scanner(file)) {

            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
        }
    }
}
