package HuffmanPackage;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text to encode: ");
        String inputText = scanner.nextLine();
        if(inputText.isEmpty()){
            System.out.println("Please enter some text to encode.");
        }
        try{
            Huffman huffman = new Huffman(inputText);
            String encodedText = huffman.encode();
            System.out.println("\nEncoded Text: " +encodedText);

            System.out.println("\nHuffman Codes: ");
            huffman.printCodes();

            String originalText = huffman.decode(encodedText);
            System.out.println("\nDecoded Text: " + originalText);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}



