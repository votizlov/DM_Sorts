package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Shell {
    static int stepCounter;
    static int innerSteps;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите длину массива ");
        int length = sc.nextInt();
        System.out.println("Введите массив ");
        int[] array = fillMassive(length);
        System.out.println();
        System.out.print("Your array: ");
        System.out.println(Arrays.toString(array));
        shellSort(array);
        System.out.println(stepCounter);
    }

    public static int[] fillMassive(int length) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = sc.nextInt();
        }
        return array;
    }
    public static void shellSort(int[] arr) {
        int h = 1;
        while (h * 3 < arr.length)
            h = h * 3 + 1;

        while (h >= 1) {
            innerSteps = 0;
            shellInnerSort(arr, h);
            h = h / 3;
            System.out.println(Arrays.toString(arr) + " " + innerSteps);
        }
        System.out.println("Was " + stepCounter + " steps");
    }

    private static void shellInnerSort(int[] arr, int h) {
        for (int i = h; i < arr.length; i++) {
            int deepInnerSteps = 0;
            for (int j = i; j >= h; j = j - h) {
                stepCounter++;
                innerSteps++;
                deepInnerSteps++;
                if (arr[j] < arr[j - h]) {
                    int buf = arr[j];
                    arr[j] = arr[j - h];
                    arr[j - h] = buf;
                } else break;
            }
            System.out.println("/- " + Arrays.toString(arr) + " " + deepInnerSteps);
        }
    }
}
