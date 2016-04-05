package huffmanCode;

public class Node {
	public HuffmanCode data;
	public Node left;
	public Node right;
	public void set(HuffmanCode d, Node l, Node r){
		data = d;
		left = l;
		right =r;
	}
}
