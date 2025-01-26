package HuffmanPackage;

public class Leaf extends Node {
    private final char character;
    // Constructor
    public Leaf(char character, int frequency) {
        super(frequency);
        this.character = character;
    }
    // Getter for character
    public char getCharacter() {
        return character;
    }
    // Override equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Leaf leaf = (Leaf) o;

        return character == leaf.character;
    }
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) character;
        return result;
    }
}

