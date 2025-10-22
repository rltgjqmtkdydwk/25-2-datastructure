class Node {
    int key, height;
    Node left, right;

    Node(int d) {
        key = d;
        height = 1;
    }
}

class AVLTree {
    Node root;

    int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // 회전 수행
        x.right = y;
        y.left = T2;

        // 높이 갱신
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // 회전 수행
        y.left = x;
        x.right = T2;

        // 높이 갱신
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    Node insert(Node node, int key) {
        if (node == null)
            return new Node(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node; // 중복 키 무시

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        // 불균형 발생 → 회전 수행
        if (balance > 1 && key < node.left.key)
            return rotateRight(node); // LL
        if (balance < -1 && key > node.right.key)
            return rotateLeft(node); // RR
        if (balance > 1 && key > node.left.key) {
            node.left = rotateLeft(node.left); // LR
            return rotateRight(node);
        }
        if (balance < -1 && key < node.right.key) {
            node.right = rotateRight(node.right); // RL
            return rotateLeft(node);
        }

        return node;
    }

    Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    Node delete(Node root, int key) {
        if (root == null)
            return root;

        if (key < root.key)
            root.left = delete(root.left, key);
        else if (key > root.key)
            root.right = delete(root.right, key);
        else {
            // 삭제 케이스
            if ((root.left == null) || (root.right == null)) {
                Node temp = (root.left != null) ? root.left : root.right;
                if (temp == null) {
                    temp = root;
                    root = null;
                } else {
                    root = temp;
                }
            } else {
                Node temp = minValueNode(root.right);
                root.key = temp.key;
                root.right = delete(root.right, temp.key);
            }
        }

        if (root == null)
            return root;

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        int balance = getBalance(root);

        // 불균형 발생 → 회전 수행
        if (balance > 1 && getBalance(root.left) >= 0)
            return rotateRight(root); // LL
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = rotateLeft(root.left); // LR
            return rotateRight(root);
        }
        if (balance < -1 && getBalance(root.right) <= 0)
            return rotateLeft(root); // RR
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rotateRight(root.right); // RL
            return rotateLeft(root);
        }

        return root;
    }

    // 트리를 나무 형태로 출력
    void printTree(Node root, String indent, boolean last) {
        if (root != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "     ";
            } else {
                System.out.print("L----");
                indent += "|    ";
            }
            System.out.println(root.key);
            printTree(root.left, indent, false);
            printTree(root.right, indent, true);
        }
    }

    void print() {
        printTree(root, "", true);
    }
}

public class AVL {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        int[] inserts = { 6, 5, 4, 2, 3 };
        int[] deletes = { 6, 2 };

        System.out.println("=== 삽입 과정 ===");
        for (int x : inserts) {
            tree.root = tree.insert(tree.root, x);
            System.out.println("Insert " + x + ":");
            tree.print();
            System.out.println();
        }

        System.out.println("=== 삭제 과정 ===");
        for (int x : deletes) {
            tree.root = tree.delete(tree.root, x);
            System.out.println("Delete " + x + ":");
            tree.print();
            System.out.println();
        }
    }
}
