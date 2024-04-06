package Java;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arrayBubble = { 5, 4, 3, 2, 1 };
        System.out.println("Ordenamiento por el método burbuja");

        BubbleSort.bubbleSort(arrayBubble);
        System.out.println(Arrays.toString(arrayBubble));


        int[] arrayInsertion = { 51, 4, 32, 12, 1 };
        InsertionSort.insertionSort(arrayInsertion);

        System.out.println("Ordenamiento por inserción");
        System.out.println(Arrays.toString(arrayInsertion));

        int[] arrayMerge = { 85, 24, 63, 45, 17, 31, 96, 50 };
        System.out.println("Ordenamiento rápido");

        MergeSort.mergeSort(arrayMerge, 0, arrayMerge.length - 1);
        System.out.println(Arrays.toString(arrayMerge));

        int[] arrayQuick = { 40, 70, 30, 80, 60, 20 };
        System.out.println("Ordenamiento rápido");
        QuickSort.quickSort(arrayQuick, 0, arrayQuick.length - 1);
        System.out.println(Arrays.toString(arrayQuick));

        int[] arraySelection = { 15, 49, 93, 51, 7 };
        SelectionSort.selectionSort(arraySelection);

        System.out.println("Ordenamiento por selección");
        System.out.println(Arrays.toString(arraySelection));
        
    }
}