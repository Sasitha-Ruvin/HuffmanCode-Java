package HuffmanPackage;

public class Node implements Comparable<Node> {
    private final int frequency;
    private Node left;
    private Node right;

    // Constructor for leaf node
    public Node(int frequency) {
        this.frequency = frequency;
    }

    // Constructor for internal node
    public Node(Node left, Node right) {
        this.frequency = left.frequency + right.frequency;
        this.left = left;
        this.right = right;
    }

    public int getFrequency() {
        return frequency;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.frequency, other.frequency);
    }
}
