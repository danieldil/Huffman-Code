package huffmanCode;

import java.util.ArrayList;

public class Node {
	public HuffmanCode data;
	public Node left;
	public Node right;
	String label = "-1";
	ArrayList<Character> bit = new ArrayList<Character>();
	public Node(){
		this.data = new HuffmanCode();
		this.left = null;
		this.right= null;
		this.label = "null";
	}
	public Node(HuffmanCode d, Node l, Node r, String s){
		data = d;
		left = l;
		right = r;
		label = s;
	}
	public void set(HuffmanCode d, Node l, Node r){
		data = d;
		left = l;
		right = r;
	}
	public void printBin(){
		
	}
	public void printTree(int counter,char side){
		//If i was called by left i will add a 0
		counter++;
		if(this.left.data.prob == -1 && this.right.data.prob == -1 && this.label.length()!=1){
			this.right.bit.add('1');
			this.left.bit.add('0');
			System.out.println(this);
			this.left.printTree(counter,'l');
			this.right.printTree(counter,'r');
		}
		if(this.left.data.prob == -1.0 && this.right.data.prob != -1.0){
			this.right.bit.add('1');
			this.left.bit.add('0');
			System.out.println(this + "my left is -1");
			this.left.printTree(counter,'l');
		}
		if(this.left.data.prob != -1.0 && this.right.data.prob == -1.0){
			this.right.bit.add('1');
			this.left.bit.add('0');
			System.out.println(this + "my right is -1");
			this.right.printTree(counter,'r');
		}
		if(this.right.data.prob != -1.0 && this.left.data.prob != -1.0 ){
			this.left.bit.add('0');
			this.right.bit.add('1');
			System.out.println(this);
			System.out.println(this.left+ " " + this.right);
		}
	}
	public String toString(){
		String s;
		if(this.right != null){
			s = 
			String.valueOf((
					"      "+
					this.label+" "+this.bit+
					"\n"+
					this.left.data.prob+ 
					//this.left.data.letter+ 
					"   _   "+ 
					this.right.data.prob+
					"\n"+
					this.left.bit.toString()+
					"   _  "+
					this.right.bit.toString()+
					"\n"
					//this.right.data.letter
					));
		}
		else{
			s = String.valueOf(this.left.data.prob);
		}
		return s;
	}
}
