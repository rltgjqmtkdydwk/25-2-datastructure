public class main {

    public static void main(String[] args) {

        Node<String> n1 = new Node<>("+", null, null);
        Node<String> n2 = new Node<>("1", null, null);
        Node<String> n3 = new Node<>("2", null, null);
        n1.setLeft(n2);
        n1.setRight(n3); // n1의 왼쪽 자식-> n2, n1의 오른쪽 자식-> n3

        Node<String> n4 = new Node<>("-", null, null);
        Node<String> n5 = new Node<>("4", null, null);
        Node<String> n6 = new Node<>("3", null, null);
        n4.setLeft(n5);
        n4.setRight(n6);

        Node<String> root = new Node<>("*", null, null);
        root.setLeft(n1);
        root.setRight(n4);

        BinaryTree<String> t = new BinaryTree<>(); // 이진 트리 객체 t 생성
        t.setRoot(n1); // t의 루트 노드를 n1으로

        System.out.println("트리 노드 수  = " + t.size(t.getRoot()));
        System.out.println("트리 높이     = " + t.height(t.getRoot()));
        System.out.printf("전위 순회:  ");
        t.preorder(t.getRoot());
        System.out.printf("\n중위 순회:  ");
        t.inorder(t.getRoot());
        System.out.printf("\n후위 순회:  ");
        t.postorder(t.getRoot());
        System.out.printf("\n레벨 순회:  ");
        t.levelorder(t.getRoot());
        System.out.println();

        System.out.printf("결과 : " + t.evaluate(t.getRoot()) + "\n");
    }
}
