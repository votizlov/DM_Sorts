package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Quicksort {
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
        quickSort(array, 0, array.length - 1);
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
    public static void quickSort(int[] array, int low, int high) {
        if (low >= high)
            return;
        int pivot = array[low];
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < pivot) {
                stepCounter++;
                i++;
            }
            while (array[j] > pivot) {
                stepCounter++;
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            stepCounter++;
        quickSort(array, low, j);
        if (high > i)
            quickSort(array, i, high);
    }
}
