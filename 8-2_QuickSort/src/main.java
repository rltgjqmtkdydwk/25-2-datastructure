public class main {
	public static void main(String[] args) {
		String[] best = { "1", "2", "3", "4", "5", "6" };
		String[] worst = { "6", "5", "4", "3", "2", "1" };

		System.out.print("정렬 (최상) : ");
		Quick.count = 0;
		Quick.sort(best);
		printArray(best);
		System.out.println("count = " + Quick.count);

		System.out.print("정렬 (최악) : ");
		Quick.count = 0;
		Quick.sort(worst);
		printArray(worst);
		System.out.println("count = " + Quick.count);
	}

	public static void printArray(Object[] a) {
		for (Object x : a)
			System.out.print(x + "  ");
		System.out.println();
	}
}
