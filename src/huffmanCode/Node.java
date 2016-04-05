package huffmanCode;

public class Node {
	public HuffmanCode data;
	public Node left;
	public Node right;
	public Node(HuffmanCode d, Node l, Node r){
		data = d;
		left = l;
		right =r;
	}
	public void set(HuffmanCode d, Node l, Node r){
		data = d;
		left = l;
		right =r;
	}
	public String toString(){
		String s;
		if(this.right != null){
			s = String.valueOf((this.left.data.prob + "   " + this.right.data.prob));
		}
		else{
			s = String.valueOf(this.left.data.prob);
		}
		return s;
	}
}
