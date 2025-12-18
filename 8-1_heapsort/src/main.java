public class main {
	public static void main(String[] args) {
		String[] a = { "90", "60", "80", "50", "30", "40", "70", "10", "20" };
		System.out.println("초기 배열: ");
		printArray(a);

		Heap.sort(a);

		System.out.print("정렬 결과: ");
		printArray(a);
	}

	public static void printArray(Object[] a) {
		for (Object x : a)
			System.out.print(x + " ");
		System.out.println();
	}
}
