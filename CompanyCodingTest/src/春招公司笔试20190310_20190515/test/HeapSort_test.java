package 春招公司笔试20190310_20190515.test;

/**
 * @author tankInternshipInterview
 * @create 2019/02/15 10:39
 */
public class HeapSort_test {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length <= 2) {
            return;
        }
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            heapInsert(i, arr);
        }
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }

    }

    public static void heapInsert(int i, int[] arr) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
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
            if(larger == index){
                break;
            }
            swap(arr, index, larger);
            index = larger;
            left = 2 * index + 1;


        }
    }
}
