package com.company;

import java.util.Arrays;

public class Main {

    private static int[] arrInt = new int[400];
    private static int[] arrInt2 = new int[400];
    private static int[] task3 = new int[400];
    private static long timeSort;
    private static long timeBuuble;
    private static long timeSelect;
    private static long insertionSort;


    public static void main(String[] args) {

        fullArr(arrInt);

        System.out.println();
        System.out.println("-----Задание 2.1-----");
        System.out.println(tassk1);
        System.out.println();
        long a = System.nanoTime();
        Arrays.sort(arrInt);
        arrInt2 = Arrays.copyOf(arrInt,arrInt.length);
        Arrays.equals(arrInt,arrInt2);
        whatTime(a);

        System.out.println();
        System.out.println("-----Задание 2.2-----");
        System.out.println(tassk2);
        long b = System.nanoTime();
        System.out.println();
        System.out.println("Линейный поиск - 20 элемент находится в ячейке " + linSearch(arrInt, 20));
        whatTime(b);
        long c = System.nanoTime();
        System.out.println("Двоичный поиск");
        binSearch(arrInt, 20);
        whatTime(c);

        System.out.println();
        System.out.println("-----Задание 2.3-----");
        System.out.println(tassk3);
        System.out.println();

        fullArr(task3);
        long d = System.nanoTime();
        Arrays.sort(task3);
        whatTime(d);
        timeSort = System.nanoTime() - d;

        System.out.println();
        System.out.println("-----Задание 2.4-----");
        System.out.println(tassk4);
        System.out.println();
        long i = System.nanoTime();
        bubbleSorter(task3, task3.length);
        System.out.print("Сортировка пузырьком ");
        whatTime(i);
        timeBuuble = System.nanoTime() - i;
        long f = System.nanoTime();
        System.out.print("Сортировка сорт ");
        Arrays.sort(task3);
        whatTime(f);

        System.out.println();
        System.out.println("-----Задание 2.5-----");
        System.out.println(tassk5);
        System.out.println();
        long g = System.nanoTime();
        selectSort(task3);
        whatTime(g);
        System.out.println();
        timeSelect = System.nanoTime() - g;
        System.out.println("Сортировка Сорт " + timeSort);
        System.out.println("Сортировка Пузырьком " + timeBuuble);
        System.out.println("Сортировка Выбором " + timeSelect);

        System.out.println();
        System.out.println("-----Задание 2.6-----");
        System.out.println(tassk6);
        long z = System.nanoTime();
        insertionSort(arrInt);
        whatTime(z);
        insertionSort = System.nanoTime() - z;
        System.out.println();
        System.out.println("Сортировка Сорт " + timeSort);
        System.out.println("Сортировка Пузырьком " + timeBuuble);
        System.out.println("Сортировка Выбором " + timeSelect);
        System.out.println("Сортировка Вставкой " + insertionSort);
    }



    private static void fullArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }
    }

    private static void whatTime(long a){
        System.out.println("Это заняло наносекунд " + (System.nanoTime() - a));
    }

    private static int linSearch(int arr[], int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element)
                return i;
        }
        return -1;
    }

    private static void binSearch(int[] arr, int item) {
        int position;
        int first = 0;
        int last = arr.length - 1;

        position = (first + last) / 2;

        while ((arr[position] != item) && (first <= last)) {
            if (arr[position] > item) {
                last = position - 1;
            } else {
                first = position + 1;
            }
            position = (first + last) / 2;
        }
        if (first <= last) {
            System.out.println(item + " является " + position + " элементом в массиве");
        } else System.out.println("Ошибка поиска");
    }

    private static void toSwap(int first, int second){
        int dummy = task3[first];
        task3[first] = task3[second];
        task3[second] = dummy;
    }

    public static void bubbleSorter(int[] a, int elems){
        for (int out = elems - 1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                if(a[in] > a[in + 1])
                    toSwap(in, in + 1);
            }
        }
    }

    public static void selectSort(int[] arr){
        for (int i = 0; i <arr.length; i++) {
            int min = arr[i];
            int minI = i;
            for (int j = i+1; j <arr.length; j++) {
                if (arr[j] <min) {
                    min = arr[j];
                    minI = j;
                }
            }
            if (i != minI) {
                int tmp = arr[i];
                arr[i] = arr[minI];
                arr[minI] = tmp;
            }
        }
    }

    private static void insertionSort(int arr[]) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i-1;

            while ((j > -1)&&(arr [j] > key )){
            arr [j+1] = arr [j];
            j--;
        }
            arr[j+1] = key;
        }
    }

    private static String tassk1 = "На основе программного кода из домашнего задания №1 реализуйте массив на основе существующих примитивных или ссылочных типов данных.\n" +
            "Выполните обращение к массиву и базовые операции класса Arrays.\n" +
            "Оценить выполненные методы с помощью базового класса System.nanoTime().";
    private static String tassk2 = "На основе написанного кода в задании 2.1 реализуйте линейный и двоичный поиск.\n" +
            "Оценить алгоритмы линейного и двоичного поиска с помощью базового класса System.nanoTime(), при необходимости расширьте уже существующий массив данных.";
    private static String tassk3 = "Создайте массив размером 400 элементов.\n" +
            "Выполните сортировку с помощью метода sort().\n" +
            "Оцените сортировку с помощью базового класса System.nanoTime().";
    private static String tassk4 = "На основе существующего массива данных из задания 2.3 реализуйте алгоритм сортировки пузырьком.\n" +
            "Оцените сортировку с помощью базового класса System.nanoTime().\n" +
            "Сравните время выполнения алгоритмы сортировки методом sort() из задания 2.1 и сортировку пузырьком.";
    private static String tassk5 = "На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом выбора.\n" +
            "Оцените сортировку с помощью базового класса System.nanoTime().\n" +
            "Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3 и 2.4.";
    private static String tassk6 = "На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом вставки.\n" +
            "Оцените сортировку с помощью базового класса System.nanoTime().\n" +
            "Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3, 2.4 и 2.5.";

}