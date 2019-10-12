/*
 * Tencent is pleased to support the open source community by making BlueKing available.
 * Copyright (C) 2017-2018 THL A29 Limited, a Tencent company. All rights reserved.
 * Licensed under the MIT License (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * http://opensource.org/licenses/MIT
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */

package 牛油面试手撕;

import java.util.Arrays;

/**
 * 排序四件套
 *
 * @author fakertan
 * @version V1.0
 * @date 2019/8/19
 */
public class 排序四件套
{
    public static void main(String[] args)
    {
        int[] arr = {4, 2, 1, 3, 5};
//        bubbleSort(arr);
//        quickSort(arr);
//        heapSort(arr);
        mergeSort(arr);
    }

    private static void bubbleSort(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
            boolean isChanged = false;
            for (int j = arr.length - 1; j > i; j--)
            {
                if (arr[j] < arr[j - 1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    isChanged = true;
                }
            }
            if (!isChanged)
            {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr)
    {
        if (arr == null || arr.length < 2)
        {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int l, int r)
    {
        if (r > l)
        {
            int p = partition(arr, l, r);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, r);
        }
    }

    private static int partition(int[] arr, int l, int r)
    {
        int pivot = arr[l];
        while (l < r)
        {
            while (l < r && arr[r] >= pivot)
            {
                r--;
            }
            arr[l] = arr[r];
            while (l < r && arr[l] <= pivot)
            {
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = pivot;
        return l;
    }

    private static void heapSort(int[] arr)
    {
        if (arr == null || arr.length < 2)
        {
            return;
        }
        int size = arr.length;
        for (int i = 0; i < size; i++)
        {
            heapInsert(arr, i);
        }
        swap(arr, 0, --size);
        while (size > 0)
        {
            heapify(arr, size);
            swap(arr, 0, --size);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void heapInsert(int[] arr, int index)
    {
        while (arr[index] > arr[(index - 1) / 2])
        {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void heapify(int[] arr, int size)
    {
        int left = 0;
        while (left < size)
        {
            int largest = 2 * left + 1 < size ? (arr[left] < arr[2 * left + 1] ? 2 * left + 1 : left) : left;
            largest = 2 * left + 2 < size ? (arr[largest] < arr[left + 2] ? 2 * left + 2 : largest): largest;
            if(largest == left){
                break;
            }
            swap(arr, largest, left);
            left = largest;
        }
    }

    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void mergeSort(int[] arr)
    {
        if (arr == null || arr.length < 2)
        {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int l, int r)
    {
        if (l < r)
        {
            int mid = l + ((r - l) >> 1);
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right)
    {
        int l = left, r = right, l1 = mid, r1 = mid + 1;
        int[] copy = new int[r - l + 1];
        int i = 0;
        while (l <= l1 && r1 <= r)
        {
            if (arr[l] < arr[r1])
            {
                copy[i++] = arr[l++];
            }else{
                copy[i++] = arr[r1++];
            }
        }
        while (l <= l1)
        {
            copy[i++] = arr[l++];
        }
        while (r1 <= r)
        {
            copy[i++] = arr[r1++];
        }
        i = 0;
        for (int j = left; j <= right; j++)
        {
            arr[j] = copy[i++];
        }
    }
}
