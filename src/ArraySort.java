
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArraySort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements you ant to sort :");
        int len = sc.nextInt();
        int[] arr = new int[len];
        int[] arrTemp = new int[len];
        System.out.print("Enter " + len + " elements seperated by space: ");
        try {
            for (int i = 0; i < len; i++) {
                arr[i] = sc.nextInt();
            }
            System.arraycopy(arr, 0, arrTemp, 0, len);
            long bsa = bubbleSortAscend(arrTemp);

            System.arraycopy(arr, 0, arrTemp, 0, len);
            long isa = insertionSortAscend(arrTemp);

            System.arraycopy(arr, 0, arrTemp, 0, len);
            long hsa = HeapSort.sortAscend(arrTemp);

            System.arraycopy(arr, 0, arrTemp, 0, len);
            long qsa = quickSortAscend(arrTemp, 0, arrTemp.length - 1);

            System.arraycopy(arr, 0, arrTemp, 0, len);
            long msa = mergeSortAscend(arrTemp, 0, arrTemp.length - 1);

            System.arraycopy(arr, 0, arrTemp, 0, len);
            long bsd = bubbleSortDescend(arrTemp);

            System.arraycopy(arr, 0, arrTemp, 0, len);
            long isd = insertionSortDescend(arrTemp);

            System.arraycopy(arr, 0, arrTemp, 0, len);
            long hsd = HeapSort.sortDescend(arrTemp);

            System.arraycopy(arr, 0, arrTemp, 0, len);
            long qsd = quickSortDescend(arrTemp, 0, arrTemp.length - 1);

            System.arraycopy(arr, 0, arrTemp, 0, len);
            long msd = mergeSortDescend(arrTemp, 0, arrTemp.length - 1);
            
            long[] timeArray =  {(bsa + bsd) / 2, (isa + isd) / 2, (hsa + hsd) / 2, (qsa + qsd) / 2, (msa + msd) / 2};
            long tim = 0;
            int pos = 0;
            for (int i  = 0; i < 5; i++) {
                if (tim != 0) {
                    if (timeArray[i] < tim) {
                        tim = timeArray[i];
                        pos = i;
                    }
                } else {
                    tim = timeArray[i];
                }
            }
            switch(pos) {
                case 0 :
                    System.out.println("\nThe Bubble sort took the shortest time :" + timeArray[pos]);
                    break;
                case 1 :
                    System.out.println("\nThe Insertion sort took the shortest time :" + timeArray[pos]);
                    break;
                case 2 :
                    System.out.println("\nThe Heap sort took the shortest time :" + timeArray[pos]);
                    break;
                case 3 :
                    System.out.println("\nThe Quick sort took the shortest time :" + timeArray[pos]);
                    break;
                case 5 :
                    System.out.println("\nThe Merge sort took the shortest time :" + timeArray[pos]);
                    break;
            }
            
        } catch (InputMismatchException e) {
            System.out.print("Please enter digits only. Try again ");
            main(new String[]{});
        }
    }

    private static long bubbleSortAscend(int[] arr) {
        long start = System.nanoTime();
        bubbleSortAscendTemp(arr);
        long end = System.nanoTime();
        long timeTaken = end - start;
        System.out.println("Sorting of the given array in Ascending order using Bubble sort took " + timeTaken + " nano seconds");
        return timeTaken;
    }
    private static void bubbleSortAscendTemp(int[] arr) {
        int temp = 0;
        int len = arr.length;
        
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < (len - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    private static long bubbleSortDescend(int[] arr) {
        long start = System.nanoTime();
        
        long end = System.nanoTime();
        long timeTaken = end - start;
        System.out.println("Sorting of the given array in Descending order using Bubble sort took " + timeTaken + " nano seconds");
        return timeTaken;
    }
    private static void bubbleSortDescendTemp(int[] arr) {
        int len = arr.length;
        int temp = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < (len - i); j++) {
                if (arr[j - 1] < arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    private static long insertionSortAscend(int[] arr) {
        long start = System.nanoTime();
        insertionSortAscendTemp(arr);
        long end = System.nanoTime();
        long timeTaken = end - start;
        System.out.println("Sorting of the given array in Ascending order using Insertion sort took " + timeTaken + " nano seconds");
        return timeTaken;
    }
    private static void insertionSortAscendTemp(int[] arr) {
        int len = arr.length;
        int temp = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
    private static long insertionSortDescend(int[] arr) {
        long start = System.nanoTime();
        insertionSortDescendTemp(arr);
        long end = System.nanoTime();
        long timeTaken = end - start;
        System.out.println("Sorting of the given array in Descending order using Insertion sort took " + timeTaken + " nano seconds");
        return timeTaken;
    }
    private static void insertionSortDescendTemp(int[] arr) {
        int len = arr.length;
        int temp = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] > arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
    static long quickSortAscend(int[] numbers, int low, int high) {
        long start = System.nanoTime();
        quickSortAscendTemp(numbers, low, high);
        long end = System.nanoTime();
        long timeTaken = end - start;
        System.out.println("Sorting of the given array in Ascending order using Quick sort took " + timeTaken + " nano seconds");
        return timeTaken;
    }

    private static void quickSortAscendTemp(int[] numbers, int low, int high) {
        int i = low;
        int j = high;
        int temp;
        int middle = numbers[(low + high) / 2];

        while (i < j) {
            while (numbers[i] < middle) {
                i++;
            }
            while (numbers[j] > middle) {
                j--;
            }
            if (i <= j) {
                temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSortAscendTemp(numbers, low, j);
        }
        if (i < high) {
            quickSortAscendTemp(numbers, i, high);
        }
    }

    public static long quickSortDescend(int[] numbers, int low, int high) {
        long start = System.nanoTime();
        quickSortdescendTemp(numbers, low, high);
        long end = System.nanoTime();
        long timeTaken = end - start;
        System.out.println("Sorting of the given array in Descending order using Quick sort took " + timeTaken + " nano seconds");
        return timeTaken;
    }

    private static void quickSortdescendTemp(int[] numbers, int low, int high) {
        int i = low;
        int j = high;
        int temp;
        int middle = numbers[(low + high) / 2];

        while (i < j) {
            while (numbers[i] > middle) {
                i++;
            }
            while (numbers[j] < middle) {
                j--;
            }
            if (j >= i) {
                temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSortdescendTemp(numbers, low, j);
        }
        if (i < high) {
            quickSortdescendTemp(numbers, i, high);
        }
    }

    private static long mergeSortAscend(int[] num, int i, int j) {
        long start = System.nanoTime();
        mergeSortAscendTemp(num, i, j);
        long end = System.nanoTime();
        long timeTaken = end - start;
        System.out.println("Sorting of the given array in Ascending order using Merge sort took " + timeTaken + " nano seconds");
        return timeTaken;
    }

    private static void mergeSortAscendTemp(int[] num, int i, int j) {
        int low = i;
        int high = j;

        if (low >= high) {
            return;
        }

        int middle = (low + high) / 2;

        mergeSortAscendTemp(num, low, middle);
        mergeSortAscendTemp(num, middle + 1, high);

        int end_low = middle;
        int start_high = middle + 1;

        while ((low <= end_low) && (start_high <= high)) {

            if (num[low] < num[start_high]) {

                low++;
            } else {

                int Temp = num[start_high];

                for (int k = start_high - 1; k >= low; k--) {

                    num[k + 1] = num[k];
                }

                num[low] = Temp;
                low++;
                end_low++;
                start_high++;
            }
        }
    }

    private static long mergeSortDescend(int[] num, int i, int j) {
        long start = System.nanoTime();
        mergeSortDescendTemp(num, i, j);
        long end = System.nanoTime();
        long timeTaken = end - start;
        System.out.println("Sorting of the given array in Descending order using Merge sort took " + timeTaken + " nano seconds");
        return timeTaken;
    }

    private static void mergeSortDescendTemp(int[] num, int i, int j) {
        int low = i;
        int high = j;

        if (low >= high) {
            return;
        }

        int middle = (low + high) / 2;

        mergeSortDescendTemp(num, low, middle);
        mergeSortDescendTemp(num, middle + 1, high);

        int end_low = middle;
        int start_high = middle + 1;

        while ((low <= end_low) && (start_high <= high)) {

            if (num[low] > num[start_high]) {

                low++;
            } else {

                int Temp = num[start_high];

                for (int k = start_high - 1; k >= low; k--) {

                    num[k + 1] = num[k];
                }

                num[low] = Temp;
                low++;
                end_low++;
                start_high++;
            }
        }
    }
}

class HeapSort {

    private static int[] a;
    private static int n;
    private static int left;
    private static int right;
    private static int largest;

    public static void buildheap(int[] a) {
        n = a.length - 1;
        for (int i = n / 2; i >= 0; i--) {
            maxheap(a, i);
        }
    }

    public static void maxheap(int[] a, int i) {
        left = 2 * i;
        right = 2 * i + 1;

        if (left <= n && a[left] > a[i]) {
            largest = left;
        } else {
            largest = i;
        }

        if (right <= n && a[right] > a[largest]) {
            largest = right;
        }
        if (largest != i) {
            exchange(i, largest);
            maxheap(a, largest);
        }
    }

    public static void exchange(int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static long sortAscend(int[] myarray) {
        long start = System.nanoTime();
        a = myarray;
        buildheap(a);
        for (int i = n; i > 0; i--) {
            exchange(0, i);
            n = n - 1;
            maxheap(a, 0);
        }
        long end = System.nanoTime();
        long timeTaken = end - start;
        System.out.println("Sorting of the given array in Ascending order using Heap sort took " + timeTaken + " nano seconds");
        return timeTaken;
    }

    public static long sortDescend(int[] array) {
        long start = System.nanoTime();
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            RepairTop(array, array.length - 1, i);
        }
        for (int i = array.length - 1; i > 0; i--) {
            Swap(array, 0, i);
            RepairTop(array, i - 1, 0);
        }
        long end = System.nanoTime();
        long timeTaken = end - start;
        System.out.println("Sorting of the given array in Descending order using Heap sort took " + timeTaken + " nano seconds");
        return timeTaken;
    }

    private static void RepairTop(int[] array, int bottom, int topIndex) {
        int tmp = array[topIndex];
        int succ = topIndex * 2 + 1;
        if (succ < bottom && array[succ] > array[succ + 1]) {
            succ++;
        }

        while (succ <= bottom && tmp > array[succ]) {
            array[topIndex] = array[succ];
            topIndex = succ;
            succ = succ * 2 + 1;
            if (succ < bottom && array[succ] > array[succ + 1]) {
                succ++;
            }
        }
        array[topIndex] = tmp;
    }

    private static void Swap(int[] array, int left, int right) {
        int tmp = array[right];
        array[right] = array[left];
        array[left] = tmp;
    }
}
