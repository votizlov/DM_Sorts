package com.company;
import java.util.Arrays;
import java.util.Scanner;

 class InsertionBinary {
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
        insertionBinarySort(array);
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
    private static void insertionBinarySort(int[] arr) {
        int pos;
        int key;
        for (int i = 1; i < arr.length; i++) {
            innerSteps = 0;
            key = arr[i];
            pos = binarySearch(0, i - 1, key, arr);
            for (int j = i; j > pos; j--) {
                arr[j] = arr[j - 1];
            }
            arr[pos] = key;
            System.out.print(Arrays.toString(arr));
            System.out.println(" " + innerSteps);
        }
        System.out.println("Was " + stepCounter + "steps");
    }

    private static int binarySearch(int low, int high, int key, int[] a) {
        int mid;
        while (low <= high) {
            innerSteps++;
            stepCounter++;
            mid = (low + high) / 2;
            if (key > a[mid])
                low = mid + 1;
            else if (key < a[mid])
                high = mid - 1;
            else
                return mid;
        }
        return low;
    }
}
