package HuffmanPackage;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Huffman {
    private Node root;
    private final String text;
    private Map<Character, Integer> charFrequencies;
    private final Map<Character, String> huffmanCodes;

    public Huffman(String text) {
        this.text = text;
        fillCharFrequenciesMap();
        huffmanCodes = new HashMap<>();

        if(charFrequencies.size() == 1){
            throw new IllegalArgumentException("Text must contain more than one unique character.");
        }

    }
    private void fillCharFrequenciesMap(){
        charFrequencies = new HashMap<>();
        for (char character: text.toCharArray()){
            Integer integer = charFrequencies.get(character);
            charFrequencies.put(character, integer != null ? integer + 1 : 1);
        }
    }
    public String encode() {
        if(charFrequencies.isEmpty()){
            return "";
        }
        Queue<Node> queue = new PriorityQueue<>();
        charFrequencies.forEach((character, frequency) ->
                queue.add(new Leaf(character, frequency))
                );
        while (queue.size() > 1){
            queue.add(new Node(queue.poll(), queue.poll()));
        }
        generateHuffmanCodes(root = queue.poll(), "");
        return getEncodedText();
    }

    public void generateHuffmanCodes(Node node, String code){
        if(node instanceof Leaf){
            huffmanCodes.put(((Leaf) node).getCharacter(), code);
            return;
        }
        generateHuffmanCodes(node.getLeft(), code.concat("0"));
        generateHuffmanCodes(node.getRight(), code.concat("1"));
    }

    public String getEncodedText(){
        StringBuilder sb = new StringBuilder();
        for (char character : text.toCharArray()){
            sb.append(huffmanCodes.get(character));
        }
        return  sb.toString();
    }

    public String decode(String encodedText){
        StringBuilder sb = new StringBuilder();
        Node current = root;
        for (char character : encodedText.toCharArray()){
            current = character == '0' ? current.getLeft() : current.getRight();
            if(current instanceof Leaf){
                sb.append(((Leaf) current).getCharacter());
                current = root;
            }
        }
        return sb.toString();
    }
    public void printCodes(){
        huffmanCodes.forEach((character, code) ->
                System.out.println(character + ": " + code)
        );
    }
}
