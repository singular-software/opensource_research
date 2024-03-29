package com.zhaogang.other.arithmetic;

import org.apache.commons.lang3.StringUtils;

/**
 * @author weiguo.liu
 * @date 2021/4/15
 * @description
 */
public class Sort1 {
    private static int[] arr = {5, 5, 3, 1, 8, 2, 8, 4, 3, 9, 9};

    public static void main(String[] args) {
        // bubbleSort();
        // selectSort();
        // insertSort();
        // shellSort();

        // mergeSort(arr, 0, arr.length - 1);
        // printResult("mergeSort");

        fastSort(arr, 0, arr.length - 1);
        printResult("fastSort");
    }

    private static void bubbleSort() {
        int maxIndex = arr.length - 1;
        for (int i = 0; i < maxIndex; i++) {
            for (int j = 0; j < maxIndex - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    swap(j, j + 1);
                }
            }
        }

        printResult();
    }

    private static void selectSort() {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                swap(minIndex, i);
            }
        }

        printResult();
    }

    private static void insertSort() {
        for (int i = 1; i < arr.length - 1; i++) {
            int tar = arr[i];
            int tarIndex = i;
            while (tarIndex > 0 && tar < arr[tarIndex - 1]) {
                arr[tarIndex] = arr[--tarIndex];
            }
            arr[tarIndex] = tar;
        }
        printResult();
    }

    private static void shellSort() {
        int h = 1;
        while (h < arr.length / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {
            for (int i = h; i < arr.length; i++) {
                int tar = arr[i];
                int tarIndex = i;
                while (tarIndex > h - 1 && arr[tarIndex - h] > tar) {
                    arr[tarIndex] = arr[tarIndex - h];
                    tarIndex = tarIndex - h;
                }
                arr[tarIndex] = tar;
            }
            h = (h - 1) / 3;
        }

        printResult();
    }

    private static void mergeSort(int[] arr, int low, int high) {
        int mid = (low + high) / 2;

        if (low < high) {
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            toMerProcess(arr, low, mid, high);
        }
    }

    private static void toMerProcess(int[] arr, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int tmpIndex = 0;
        while (left <= mid && right <= high) {
            tmp[tmpIndex++] = arr[left] < arr[right] ? arr[left++] : arr[right++];
        }

        while (left <= mid) {
            tmp[tmpIndex++] = arr[left++];
        }

        while (right <= high) {
            tmp[tmpIndex++] = arr[right++];
        }

        System.arraycopy(tmp, 0, arr, low, tmp.length);
    }

    private static void fastSort(int[] arr, int low, int high) {
        int left = low;
        int right = high;
        int pivot = arr[left];
        int tarIndex = left;

        while (left < right) {
            while (left < right && pivot <= arr[right]) {
                right--;
            }

            if (left < right) {
                arr[tarIndex] = arr[right];
                tarIndex = right;
            }

            while (left < right && pivot <= arr[left]) {
                left++;
            }

            if (left < right) {
                arr[tarIndex] = arr[left];
                tarIndex = left;
            }
        }

        arr[tarIndex] = pivot;

        if (left - low > 1) {
            fastSort(arr, low, left - 1);
        }

        if (high - right > 1) {
            fastSort(arr, right + 1, high);
        }
    }

    private static void swap(int from, int to) {
        int tmp = arr[from];
        arr[from] = arr[to];
        arr[to] = tmp;
    }

    private static void printResult(String name) {
        System.out.print(
            ">> " + (StringUtils.isBlank(name) ? Thread.currentThread().getStackTrace()[2].getMethodName() : name)
                + " result: ");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void printResult() {
        System.out.print(">> " + Thread.currentThread().getStackTrace()[2].getMethodName() + " result: ");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
