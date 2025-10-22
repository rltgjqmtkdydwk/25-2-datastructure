public class Hanoi {
    static int count = 0;

    static void move(int n, char from, char to, char tmp) {
        if (n == 1) {
            count++;
            System.out.println(count + " 원판" + n + " 이동 : " + from + " -> " + to);

        } else {
            move(n - 1, from, tmp, to);
            count++;
            System.out.println(count + " 원판" + n + " 이동 : " + from + " -> " + to);
            move(n - 1, tmp, to, from);
        }
    }

    public static void main(String[] args) {

        move(3, 'A', 'B', 'C');

    }

}