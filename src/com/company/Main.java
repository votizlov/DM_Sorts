package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code hereколво сравнений и временная сложность
    }

    public static int linearSearch(int arr[], int elementToSearch) {

        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == elementToSearch)
                return index;
        }
        return -1;
    }

    public static int binarySearch(int arr[], int elementToSearch) {

        int firstIndex = 0;
        int lastIndex = arr.length - 1;

        // условие прекращения (элемент не представлен)
        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            // если средний элемент - целевой элемент, вернуть его индекс
            if (arr[middleIndex] == elementToSearch) {
                return middleIndex;
            }

            // если средний элемент меньше
            // направляем наш индекс в middle+1, убирая первую часть из рассмотрения
            else if (arr[middleIndex] < elementToSearch)
                firstIndex = middleIndex + 1;

                // если средний элемент больше
                // направляем наш индекс в middle-1, убирая вторую часть из рассмотрения
            else if (arr[middleIndex] > elementToSearch)
                lastIndex = middleIndex - 1;

        }
        return -1;
    }

    public int[] insertionSort(int[] data){
            for
    i in

    range(len(data)):
    j =i -1
    key =data[i]
            while data[j]>
    key and
    j >=0:
    data[j +1]=data[j]
    j -=1
    data[j +1]=key
	return data;}

    public int[] insertion_binary(int[] data){
            for
    i in

    range(len(data)):
    key =data[i]
    lo,hi =0,i -1
            while lo<hi:
    mid =lo +(hi -lo) // 2
            if key<data[mid]:
    hi =mid
			else:
    lo =mid +1
            for
    j in

    range(i, lo +1, -1):
    data[j]=data[j -1]
    data[lo]=key
	return data;
}
public int[] bubbleSort(int[] mas) {
    boolean isSorted = false;
    int buf;
    while (!isSorted) {
        isSorted = true;
        for (int i = 0; i < mas.length - 1; i++) {
            if (mas[i] > mas[i + 1]) {
                isSorted = false;

                buf = mas[i];
                mas[i] = mas[i + 1];
                mas[i + 1] = buf;
            }
        }
    }
}

    public class ShellSort
    {
        public void sort (int[] arr)
        {
            for (int inc = arr.length / 2; inc >= 1; inc = inc / 2)
                for (int step = 0; step < inc; step++)
                    insertionSort (arr, step, inc);
        }

        private void insertionSort (int[] arr, int start, int inc)
        {
            int tmp;
            for (int i = start; i < arr.length - 1; i += inc)
                for (int j = Math.min(i+inc, arr.length-1); j-inc >= 0; j = j-inc)
                    if (arr[j - inc] > arr[j])
                    {
                        tmp = arr[j];
                        arr[j] = arr[j-inc];
                        arr[j-inc] = tmp;
                    }
                    else break;
        }
    }

    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;//завершить выполнение если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }

    public int [] sortArray(int[] arrayA){ // сортировка Массива который передается в функцию
        // проверяем не нулевой ли он?
        if (arrayA == null) {
            return null;
        }
        // проверяем не 1 ли элемент в массиве?
        if (arrayA.length < 2) {
            return arrayA; // возврат в рекурсию в строки ниже см комменты.
        }
        // копируем левую часть от начала до середины
        int [] arrayB = new int[arrayA.length / 2];
        System.arraycopy(arrayA, 0, arrayB, 0, arrayA.length / 2);

        // копируем правую часть от середины до конца массива, вычитаем из длины первую часть
        int [] arrayC = new int[arrayA.length - arrayA.length / 2];
        System.arraycopy(arrayA, arrayA.length / 2, arrayC, 0, arrayA.length - arrayA.length / 2);

        // рекурсией закидываем поделенные обе части обратно в наш метод, он будет крутится до тех пор,
        // пока не дойдет до 1 элемента в массиве, после чего вернется в строку и будет искать второй такой же,
        // точнее правую часть от него и опять вернет его назад
        arrayB = sortArray(arrayB); // левая часть возврат из рекурсии строкой return arrayA;
        arrayC = sortArray(arrayC); // правая часть возврат из рекурсии строкой return arrayA;

        // далее опять рекурсия возврата слияния двух отсортированных массивов
        return mergeArray(arrayB, arrayC);
    }

    public int [] mergeArray(int [] arrayA, int [] arrayB) {

        int [] arrayC = new int[arrayA.length + arrayB.length];
        int positionA = 0, positionB = 0;

        for (int i = 0; i < arrayC.length; i++) {
            if (positionA == arrayA.length){
                arrayC[i] = arrayB[i - positionB];
                positionB++;
            } else if (positionB == arrayB.length) {
                arrayC[i] = arrayA[i - positionA];
                positionA++;
            } else if (arrayA[i - positionA] < arrayB[i - positionB]) {
                arrayC[i] = arrayA[i - positionA];
                positionB++;
            } else {
                arrayC[i] = arrayB[i - positionB];
                positionA++;
            }
        }
        return arrayC;
        }
}
