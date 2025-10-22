
// Polynomial.java
// --------------------------------------------------------------------------------

import java.util.ArrayList;

public class Polynomial {

	private ArrayList<Integer> coefArray = new ArrayList<>();
	private ArrayList<Integer> expoArray = new ArrayList<>();
	int lastCoef = 0;

	public void insertArray(int coef, int expo) {
		if (expo == 0) {
			lastCoef += coef;
		} else {
			coefArray.add(coef);
			expoArray.add(expo);
		}
	}

	public int getCoef(int index) {
		return coefArray.get(index);
	}

	public int getExpo(int index) {
		return expoArray.get(index);
	}

	public int getSize() {
		return coefArray.size();
	}

	public void print() {
		StringBuilder sb = new StringBuilder();
		boolean printed = false;

		for (int i = 0; i < coefArray.size(); i++) {
			int coef = coefArray.get(i);
			int expo = expoArray.get(i);

			// X^0인 경우, 자연수만 출력하기 위한 처리
			if (coef == 0)
				continue;

			String term = formatTerm(Math.abs(coef), expo);

			if (!printed) {
				// 첫 항 부호 처리
				if (coef < 0)
					sb.append("- ").append(term);
				else
					sb.append(term);
				printed = true;
			} else {
				if (coef < 0)
					sb.append(" - ").append(term);
				else
					sb.append(" + ").append(term);
			}
		}

		// 상수항
		if (lastCoef != 0) {
			if (!printed) {
				if (lastCoef < 0)
					sb.append("- ").append(Math.abs(lastCoef));
				else
					sb.append(lastCoef);
				printed = true;
			} else {
				if (lastCoef < 0)
					sb.append(" - ").append(Math.abs(lastCoef));
				else
					sb.append(" + ").append(lastCoef);
			}
		}

		// 모든 항이 0이면 0 출력
		if (!printed) {
			System.out.println("0");
			return;
		}

		System.out.println(sb.toString());
	}

	// 계수의 절댓값과 지수로 항 문자열 생성 (부호 제외)
	private String formatTerm(int absCoef, int expo) {
		if (expo == 1)
			return absCoef + "X";
		return absCoef + "X^" + expo;
	}
}
