package huffmanCode;

public class Node {
	public HuffmanCode data;
	public Node left;
	public Node right;
	String label;
	public Node(HuffmanCode d, Node l, Node r, String s){
		data = d;
		left = l;
		right = r;
		label = s;
	}
	public void set(HuffmanCode d, Node l, Node r){
		data = d;
		left = l;
		right =r;
	}
	public String toString(){
		String s;
		if(this.right != null){
			s = 
			String.valueOf((
					"   "+
					this.label+
					"\n"+
					this.left.data.prob+ 
					//this.left.data.letter+ 
					"   _   "+ 
					this.right.data.prob
					//this.right.data.letter
					));
		}
		else{
			s = String.valueOf(this.left.data.prob);
		}
		return s;
	}
}
