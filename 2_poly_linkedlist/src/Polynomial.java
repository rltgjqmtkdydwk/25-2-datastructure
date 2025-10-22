// Polynomial.java ------------------------------------------------------------------------

public class Polynomial {
    ListNode head;

    public Polynomial() {
        head = null;
    }

    public void insertNode(int coef, int expo) {
        ListNode node = new ListNode(coef, expo);
        if (head == null) {
            head = node;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }

    public void print() {
        if (head == null) {
            System.out.println("0");
        } else {
            ListNode current = head;
            StringBuilder sb = new StringBuilder();
            boolean printed = false; // 한 항이라도 출력했는지

            // 마지막 노드 전까지
            while (current != null) {
                int c = current.coef;
                int e = current.expo;

                if (c != 0) { // 0 계수 스킵
                    String term = formatTerm(Math.abs(c), e); // 부호 제외한 항 표기
                    if (!printed) {
                        // 첫 항: 부호 처리
                        if (c < 0)
                            sb.append("- ").append(term);
                        else
                            sb.append(term);
                        printed = true;
                    } else {
                        if (c < 0)
                            sb.append(" - ").append(term);
                        else
                            sb.append(" + ").append(term);
                    }
                }
                current = current.next;
            }

            // 모든 계수가 0이면 0 출력
            if (!printed) {
                System.out.println("0");
                return;
            }

            System.out.println(sb.toString());
        }
    }

    // 계수의 절댓값과 지수로 항 문자열 생성 (부호 제외)
    private String formatTerm(int absCoef, int expo) {
        if (expo == 0)
            return String.valueOf(absCoef);
        if (expo == 1)
            return absCoef + "X";
        return absCoef + "X^" + expo;
    }
}
