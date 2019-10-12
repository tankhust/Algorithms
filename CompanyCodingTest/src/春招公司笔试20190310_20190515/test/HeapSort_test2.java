package 春招公司笔试20190310_20190515.test;

/**
 * @author tankInternshipInterview
 * @create 2019/02/15 11:07
 */
public class HeapSort_test2 {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;
        while (size > 0) {
            swap(arr, 0, size);
            heapify(arr, 0, --size);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void heapify(int[] arr, int index, int size) {
        int left = 2 * index + 1;
        while (left < size) {
            int larger = left + 1 < size && arr[left] < arr[left + 1] ? left + 1 : left;
            larger = arr[index] < arr[larger] ? larger : index;
            if (larger == index) {
                break;
            }
            swap(arr, index, larger);
            index = larger;
            left = 2 * larger + 1;
        }
    }
}
