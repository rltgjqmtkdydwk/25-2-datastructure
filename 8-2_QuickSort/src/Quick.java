public class Quick {
    public static int count = 0; // 비교 횟수 저장용 변수

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low)
            return;
        int j = partition(a, low, high);
        sort(a, low, j - 1); // 피벗보다 작은 구간
        sort(a, j + 1, high); // 피벗보다 큰 구간
    }

    private static int partition(Comparable[] a, int pivot, int high) {
        int i = pivot + 1;
        int j = high;
        Comparable p = a[pivot];
        while (true) {
            while (i < high && isless(a[i], p)) {
                i++;
                count++;
            } // 왼쪽 비교
            while (j > pivot && isless(p, a[j])) {
                j--;
                count++;
            } // 오른쪽 비교
            if (i >= j)
                break;
            swap(a, i, j);
        }
        swap(a, pivot, j);
        return j;
    }

    private static boolean isless(Comparable u, Comparable v) {
        count++; // 비교할 때마다 증가
        return (u.compareTo(v) < 0);
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}