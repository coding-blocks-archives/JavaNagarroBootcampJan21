package L71_Huffman;

public class Client {

	public static void main(String[] args) {

		String str = "aaaabbcddddd";
		Huffman huffman = new Huffman(str);

		System.out.println(huffman.encode("dabd"));
		System.out.println(huffman.decode("0111010"));
	}
}
