package com.company;


import java.util.Arrays;

public class Main {

    private static int[] arrInt = new int[1000];
    private static int[] arrInt2 = new int[1000];
    private static int[] task4 = new int[400];


    public static void main(String[] args) {

        fullArr(arrInt);

        System.out.println();
        System.out.println("Задание 2.1");
        System.out.println("На основе программного кода из домашнего задания №1 реализуйте массив на основе существующих примитивных или ссылочных типов данных.\n" +
                "Выполните обращение к массиву и базовые операции класса Arrays.\n" +
                "Оценить выполненные методы с помощью базового класса System.nanoTime().");
        System.out.println();
        long a = System.nanoTime();
        Arrays.sort(arrInt);
        arrInt2 = Arrays.copyOf(arrInt,arrInt.length);
        Arrays.equals(arrInt,arrInt2);
        whatTime(a);

        System.out.println();
        System.out.println("Задание 2.2");
        System.out.println("На основе написанного кода в задании 2.1 реализуйте линейный и двоичный поиск.\n" +
                "Оценить алгоритмы линейного и двоичного поиска с помощью базового класса System.nanoTime(), при необходимости расширьте уже существующий массив данных.");
        long b = System.nanoTime();
        System.out.println();
        System.out.println("Линейный поиск - 500 элемент находится в ячейке " + linSearch(arrInt, 500));
        whatTime(b);
        long c = System.nanoTime();
        System.out.println("Двоичный поиск");
        binSearch(arrInt, 500);
        whatTime(c);

        System.out.println();
        System.out.println("Задание 2.3");
        System.out.println("Создайте массив размером 400 элементов.\n" +
                "Выполните сортировку с помощью метода sort().\n" +
                "Оцените сортировку с помощью базового класса System.nanoTime().");
        System.out.println();

        int[] arr3 = new int[400];
        fullArr(arr3);
        long d = System.nanoTime();
        Arrays.sort(arr3);
        whatTime(d);

        System.out.println();
        System.out.println("Задание 2.4");
        System.out.println("На основе существующего массива данных из задания 2.3 реализуйте алгоритм сортировки пузырьком.\n" +
                "Оцените сортировку с помощью базового класса System.nanoTime().\n" +
                "Сравните время выполнения алгоритмы сортировки методом sort() из задания 2.1 и сортировку пузырьком.");
        System.out.println();
        fullArr(task4);
        long i = System.nanoTime();
        bubbleSorter(task4, task4.length);
        System.out.print("Сортировка пузырьком ");
        whatTime(i);
        long f = System.nanoTime();
        System.out.print("Сортировка сорт ");
        Arrays.sort(task4);
        whatTime(f);

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
        int dummy = task4[first];
        task4[first] = task4[second];
        task4[second] = dummy;
    }

    public static void bubbleSorter(int[] a, int elems){
        for (int out = elems - 1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                if(a[in] > a[in + 1])
                    toSwap(in, in + 1);
            }
        }
    }
}