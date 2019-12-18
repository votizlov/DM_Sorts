package com.company;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import java.util.LinkedList;

public class Main extends Application {

    int counter = 0;
    static int c = 0;

    public static void main(String[] args) {
        launch(args);
        // write your code hereколво сравнений и временная сложность
        long t = System.currentTimeMillis();
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setTitle("JavaFX Chart (Series)");

        LinkedList<Node> nodes = new LinkedList<>();
        for(int i = 0;i<5;i++) {
            nodes.add(new Node(c++));
        }
        int[][] m = new int[][]{
                {0,1,10,10,5},
                {1,0,2,10,10},
                {10,2,0,3,10},
                {10,10,3,0,4},
                {5,10,10,4,0}
        };
        printNodes(crascal(nodes,m));

        /*LinkedList<Node> level = new LinkedList<>();
        LinkedList<Node> nextLevel = new LinkedList<>();
        level.add(node);
        int depth = 3;
        int n = 0;
        for (int i = 0; i < depth; i++) {
            for (Node t : level
            ) {
                Node next = new Node(c++);
                Node next1 = new Node(c++);
                t.addConnection(next);
                t.addConnection(next1);
                nextLevel.add(next);
                nextLevel.add(next1);
            }
            level.clear();
            level.addAll(nextLevel);
            nextLevel.clear();
        }

        bfs(node);
        dfs(node);
*/



        NumberAxis x = new NumberAxis();
        NumberAxis y = new NumberAxis();
        int[] arr = new int[10000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = i;
        }

        LineChart<Number, Number> numberLineChart = new LineChart<Number, Number>(x, y);
        numberLineChart.setTitle("Series");
        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        XYChart.Series series3 = new XYChart.Series();
        XYChart.Series series4 = new XYChart.Series();
        XYChart.Series series5 = new XYChart.Series();
        XYChart.Series series6 = new XYChart.Series();
        XYChart.Series series7 = new XYChart.Series();
        XYChart.Series series8 = new XYChart.Series();

        ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
        ObservableList<XYChart.Data> datas2 = FXCollections.observableArrayList();
        ObservableList<XYChart.Data> datas3 = FXCollections.observableArrayList();
        ObservableList<XYChart.Data> datas4 = FXCollections.observableArrayList();
        ObservableList<XYChart.Data> datas5 = FXCollections.observableArrayList();
        ObservableList<XYChart.Data> datas6 = FXCollections.observableArrayList();
        ObservableList<XYChart.Data> datas7 = FXCollections.observableArrayList();
        ObservableList<XYChart.Data> datas8 = FXCollections.observableArrayList();
        long t;
        for (int i = 0; i < arr.length + 1; i++) {
            linearSearch(arr, 11000);
            datas.add(new XYChart.Data(i, c));
            c=0;
            binarySearch(arr, 11000);
            datas2.add(new XYChart.Data(i, c));
            c=0;
        }
        for (int i = 2; i < 10000; i++) {
            arr = new int[i];
            for (int j = 0; j < i; j++) {
                arr[j] = j;
            }
            bubbleSort(arr);
            datas3.add(new XYChart.Data(i, c));
            c=0;

            ShellSort shellSort = new ShellSort();
            shellSort.sort(arr);
            datas4.add(new XYChart.Data(i, c));
            c=0;

            insertionSort(arr);
            datas5.add(new XYChart.Data(i, c));
            c=0;

            insertionSort(arr);
            datas6.add(new XYChart.Data(i, c));
            c=0;
            sortArray(arr);
            datas7.add(new XYChart.Data(i, c));
            c=0;
            quickSort(arr, 0, 1);
            datas8.add(new XYChart.Data(i, c));
        }

        series1.setData(datas);
        series2.setData(datas2);
        series3.setData(datas3);
        series4.setData(datas4);
        series5.setData(datas5);
        series6.setData(datas6);
        series7.setData(datas7);
        series8.setData(datas8);


        Scene scene = new Scene(numberLineChart, 600, 600);
        numberLineChart.getData().add(series1);
        numberLineChart.getData().add(series2);
        numberLineChart.getData().add(series3);
        numberLineChart.getData().add(series4);
        numberLineChart.getData().add(series5);
        numberLineChart.getData().add(series6);
        numberLineChart.getData().add(series7);
        numberLineChart.getData().add(series8);
        stage.setScene(scene);

        stage.show();
    }

    public static int linearSearch(int arr[], int elementToSearch) {
        for (int index = 0; index < arr.length; index++) {c++;
            if (arr[index] == elementToSearch){c++;
                return index;
            }
        }
        return -1;
    }

    public static int binarySearch(int arr[], int elementToSearch) {

        int firstIndex = 0;
        int lastIndex = arr.length - 1;

        // условие прекращения (элемент не представлен)
        while (firstIndex <= lastIndex) {c++;
            int middleIndex = (firstIndex + lastIndex) / 2;
            // если средний элемент - целевой элемент, вернуть его индекс
            c+=3;
            if (arr[middleIndex] == elementToSearch) {
                return middleIndex;
            }

            // если средний элемент меньше
            // направляем наш индекс в middle+1, убирая первую часть из рассмотрения
            else if (arr[middleIndex] < elementToSearch){
                firstIndex = middleIndex + 1;}
                // если средний элемент больше
                // направляем наш индекс в middle-1, убирая вторую часть из рассмотрения
            else if (arr[middleIndex] > elementToSearch){
                lastIndex = middleIndex - 1;}
            c++;
        }
        return -1;
    }

    public int[] insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {c++;
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {c++;
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    /*public int[] insertion_binary(int[] data){
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
}*/
    public int[] bubbleSort(int[] mas) {
        boolean isSorted = false;
        int buf;
        while (!isSorted) {c++;
            isSorted = true;
            for (int i = 0; i < mas.length - 1; i++) {c++;
                if (mas[i] > mas[i + 1]) {c++;
                    isSorted = false;

                    buf = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = buf;
                }
            }
        }
        return mas;
    }


    public class ShellSort {
        public void sort(int[] arr) {
            for (int inc = arr.length / 2; inc >= 1; inc = inc / 2) {c++;
                for (int step = 0; step < inc; step++) {c++;
                    insertionSort(arr, step, inc);
                }
            }
        }

        private void insertionSort(int[] arr, int start, int inc) {
            int tmp;
            for (int i = start; i < arr.length - 1; i += inc) {c++;
                for (int j = Math.min(i + inc, arr.length - 1); j - inc >= 0; j = j - inc) {c++;
                    c++;
                    if (arr[j - inc] > arr[j]) {
                        tmp = arr[j];
                        arr[j] = arr[j - inc];
                        arr[j - inc] = tmp;
                    } else break;
                }
            }
        }
    }

    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;//завершить выполнение если длина массива равна 0
        c++;
        if (low >= high)
            return;//завершить выполнение если уже нечего делить
c++;
        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {c++;
            while (array[i] < opora) {c++;
                i++;
            }

            while (array[j] > opora) {c++;
                j--;
            }

            if (i <= j) {//меняем местамиc++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части

        c++;
        if (low < j)
            quickSort(array, low, j);
        c++;
        if (high > i)
            quickSort(array, i, high);
    }

    public int[] sortArray(int[] arrayA) { // сортировка Массива который передается в функцию
        // проверяем не нулевой ли он?
        c++;
        if (arrayA == null) {
            return null;
        }
        // проверяем не 1 ли элемент в массиве?
        c++;
        if (!(arrayA.length < 2)) {
            return arrayA; // возврат в рекурсию в строки ниже см комменты.
        }
        // копируем левую часть от начала до середины
        int[] arrayB = new int[arrayA.length / 2];
        System.arraycopy(arrayA, 0, arrayB, 0, arrayA.length / 2);

        // копируем правую часть от середины до конца массива, вычитаем из длины первую часть
        int[] arrayC = new int[arrayA.length - arrayA.length / 2];
        System.arraycopy(arrayA, arrayA.length / 2, arrayC, 0, arrayA.length - arrayA.length / 2);

        // рекурсией закидываем поделенные обе части обратно в наш метод, он будет крутится до тех пор,
        // пока не дойдет до 1 элемента в массиве, после чего вернется в строку и будет искать второй такой же,
        // точнее правую часть от него и опять вернет его назад
        arrayB = sortArray(arrayB); // левая часть возврат из рекурсии строкой return arrayA;
        arrayC = sortArray(arrayC); // правая часть возврат из рекурсии строкой return arrayA;

        // далее опять рекурсия возврата слияния двух отсортированных массивов
        return mergeArray(arrayB, arrayC);
    }

    public int[] mergeArray(int[] arrayA, int[] arrayB) {

        int[] arrayC = new int[arrayA.length + arrayB.length];
        int positionA = 0, positionB = 0;

        for (int i = 0; i < arrayC.length; i++) { c++;
            c+=3;
            if (positionA == arrayA.length) {
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

    public void dfs(Node root) {
        LinkedList<Node> path = new LinkedList<>();
        path.add(root);
        for (Node t : root.getConnections()
        ) {
            visit(t, path);
        }
    }

    private void visit(Node root, LinkedList<Node> path) {
        path.add(root);
        printNodes(path);
        for (Node t : root.getConnections()
        ) {
            if (!path.contains(t)) {
                visit(t, path);
            }
        }
        path.removeLast();
    }

    public void bfs(Node root) {
        LinkedList<Node> level = new LinkedList<>();
        LinkedList<Node> nextLevel = new LinkedList<>();
        LinkedList<Node> visited = new LinkedList<>();
        level.add(root);
        visited.add(root);
        visit2(level, nextLevel, visited);
    }

    private void visit2(LinkedList<Node> level, LinkedList<Node> nextLevel, LinkedList<Node> visited) {
        for (Node t : level
        ) {
            for (Node t1 : t.getConnections()
            ) {
                if (!visited.contains(t1))
                    nextLevel.add(t1);
            }
        }
        if (nextLevel.size() != 0) {
            level.clear();
            level.addAll(nextLevel);
            nextLevel.clear();
        }
    }

    public LinkedList<Node> crascal(LinkedList<Node> nodes, int[][] adjacencyMatrix) {
        LinkedList<Node> path = new LinkedList<>();
        int t = findMin(nodes, adjacencyMatrix);
        while (path.size() != nodes.size()-1) {
            t = findMin(nodes, adjacencyMatrix);
            if (!path.contains(nodes.get(t))) {
                path.add(nodes.get(findMin(nodes, adjacencyMatrix)));
                System.out.println("a");
            }
            removeNode(adjacencyMatrix, t);
        }
        return path;
    }

    private int findMin(LinkedList<Node> nodes, int[][] m) {
        int min = 10;
        int minI = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] < min&&m[i][j]!=0) {
                    min = m[i][j];
                    minI = i;
                }
            }
        }
        return minI;
    }


    private void printNodes(LinkedList<Node> list) {
        for (Node t : list
        ) {
            System.out.print(t.toString() + " ");
        }
        System.out.println();
    }

    private void removeNode(int[][] adjacencyMatrix, int n) {
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[0].length; j++) {
                if(i==n||j==n){
                    adjacencyMatrix[i][j] = 0;
                }
            }
        }
    }
}
