public class Heap {
	public static void sort(Comparable[] a) {
		int n = a.length;

		// 힙 구성 (Heapify)
		for (int i = n / 2 - 1; i >= 0; i--) {
			downheap(a, i, n);
		}
		System.out.print("힙 구성 후: ");
		printArray(a);

		// 정렬 단계
		for (int i = n - 1; i > 0; i--) {
			swap(a, 0, i); // 루트(최댓값)와 마지막 원소 교환
			System.out.print("swap 후 (" + (n - i) + "단계): ");
			printArray(a);
			downheap(a, 0, i); // 남은 구간에 대해 downheap
		}
	}

	private static void downheap(Comparable[] a, int p, int heapSize) {
		while (2 * p + 1 < heapSize) {
			int s = 2 * p + 1; // 왼쪽 자식
			if (s + 1 < heapSize && isless(a[s], a[s + 1]))
				s++; // 오른쪽 자식이 더 크면 선택
			if (!isless(a[p], a[s]))
				break; // 부모가 더 크면 종료
			swap(a, p, s);
			p = s;
		}
	}

	private static boolean isless(Comparable i, Comparable j) {
		return (i.compareTo(j) < 0);
	}

	private static void swap(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private static void printArray(Comparable[] a) {
		for (Comparable x : a)
			System.out.print(x + " ");
		System.out.println();
	}
}
