public class QuickSort {
    private static void swap(int[] array, int firstIndex, int secondIndex) {    
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    private static int pivot(int[] array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if (array[i] > array[swapIndex]) {
                swap(array, i, swapIndex);
                swapIndex++;
            }
        }
        swap(array, pivotIndex, swapIndex);
        return swapIndex;
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = pivot(array, left, right);
            quickSort(array, left, pivotIndex -1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    public static void quickSortCall(int[] array) {
        quickSort(array, 0, array.length-1);
    }
} 