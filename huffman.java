
import java.util.*;

class Node {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
        left = right = null;
    }
}

public class huffman {

    static void printCodes(Node root, String code) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + code);
            return;
        }

        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of characters:");
        int n = sc.nextInt();

        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> a.freq - b.freq
        );

        for (int i = 0; i < n; i++) {
            System.out.println("Enter character and its frequency:");
            char ch = sc.next().charAt(0);
            int freq = sc.nextInt();

            pq.add(new Node(ch, freq));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            Node newNode = new Node('\0',
                left.freq + right.freq);

            newNode.left = left;
            newNode.right = right;

            pq.add(newNode);
        }

        System.out.println("Huffman Codes:");
        printCodes(pq.peek(), "");

        sc.close();
    }
}
