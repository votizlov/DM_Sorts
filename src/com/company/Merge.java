package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Merge {
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
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
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
    public static void mergeSort(int arr[], int l, int r) {
        stepCounter++;
        if (l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            mergeArrays(arr, l, mid, r);
        }
    }

    public static void mergeArrays(int arr[], int l, int m, int r) {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (i = 0; i < n1; i++)
            L[i] = arr[l + i];

        for (j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];

        i = 0;
        j = 0;
        k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
