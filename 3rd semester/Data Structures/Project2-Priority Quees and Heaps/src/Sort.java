//quicksort algorithm

public class Sort {

    static void quickSort(int[] a, int p, int r) {
        if (p>r) return;
        int pivot = partition(a,p,r);
        quickSort(a,p, pivot - 1);
        quickSort(a, pivot + 1,r);
    }

    //pivot index
    private static int partition(int[] a, int left, int right) {
        int p = left; //pivot's index
        int pivot = a[left];//pivot's value
        for (int i = left + 1; i <= right; i++) {
            if (a[i] > pivot) {
                p++;
                swap(a, i, p);
            }
        }
        swap(a, p, left);
        return p;
    }


    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}