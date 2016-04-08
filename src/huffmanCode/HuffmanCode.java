package huffmanCode;
import java.util.*;


public class HuffmanCode implements Comparable<HuffmanCode>{
	String letter;
	double prob;
	public HuffmanCode(String iletter, double iprob){
		letter = iletter;
		prob = iprob;
	}
	public HuffmanCode() {
		letter = "-1";
		prob = -1;
	}
	public String toString(){
		return "\nletter:"+ this.letter + " probability: "+this.prob+ "\n";
	}
	public void dlone(HuffmanCode suspect){
		suspect.letter = letter;
		suspect.prob = prob;
	}
	public boolean isLessThan(HuffmanCode s){
		if(prob < s.prob){
			return true;
		}
		else{
			return false;
		}
	}
	public void swap(HuffmanCode s){
		String temp = letter;
		double tempd = prob;
		letter = s.letter;
		prob = s.prob;
		s.letter = temp;
		s.prob = tempd;
	}
	public static ArrayList<Node> add2smallest(LinkedList<HuffmanCode> s,ArrayList<Node> nArray){
		Collections.sort(s);
		if(s.size() >= 2){
			
			Node head;
//			if(s.size()<1){
			Node left = new Node(s.get(1),new Node(),new Node(),null);
			Node right = new Node(s.get(0),new Node(),new Node(),null);
//			}
//			else{
//				Node left = new Node(s.get(1),null,null);
//				Node right = new Node(s.get(0),null,null);
//			}
			head = new Node(new HuffmanCode(),left,right,s.get(1).letter + s.get(0).letter);
			nArray.add(head);
			//System.out.println(head);
			HuffmanCode add = 
			new HuffmanCode(s.get(1).letter + s.get(0).letter,s.get(1).prob+s.get(0).prob);
			s.remove(0);
			s.remove(0);
			//System.out.println(s);
			s.add(add);
			//System.out.println(s);

			return nArray;
		}
		else{
			System.out.println("too small of a list");
		}
		return nArray;
	}
	public static void makeTreeF(ArrayList<Node> n){
		if(n.size() == 1){
			return;
		}
		String first = n.get(0).label;
		String includer = null;
		int includerIndex = -1;
		for(int i = 1; i < n.size();i++){
			if(n.get(i).label.contains(first)){
				includer = n.get(i).label;
				includerIndex = i;
				break;
			}
		}
		//we have found it's parent now let's see if the child is left or right
		if(n.get(0).label.charAt(0) == includer.charAt(0)){
			Node left = n.get(0);
			Node parent = n.get(includerIndex);
			parent.left = left;
			n.set(includerIndex, parent);
			//System.out.println(parent);
		}
		else{
			Node right = n.get(0);
			Node parent = n.get(includerIndex);
			parent.right = right;
			n.set(includerIndex, parent);	
			//System.out.println(parent);
		}
		System.out.println(includer + " is the includer");
		n.remove(0);
		makeTreeF(n);
	}
	public static void makeTree(ArrayList<Node> n){
		boolean left = false;
		boolean right = false;
		int lefti = -1;
		String firstletter = String.valueOf(n.get(n.size()-1).label.charAt(0));
		String lastletter = String.valueOf(n.get(n.size()-1).label.charAt(n.size()-1));
		
		for(int i = 0; i < n.size(); i++){
			if(n.get(i).label.contains(firstletter)){
			left = true;
			lefti = i;
			}
		}
		if(!left){
			right = true;
		}
		if(left){
			//search the whole list with the start letter to see if it exists before
			n.get(n.size()).left = n.get(lefti);
		}
	}
@SuppressWarnings("unchecked")
public static void main(String[] args){
	//JFrame frame = new JFrame(new JComponent());
	ArrayList<Node> nArray = new ArrayList<Node>();
	LinkedList<HuffmanCode> hList = new LinkedList<HuffmanCode>();
	LinkedList<HuffmanCode> hListcopy = new LinkedList<HuffmanCode>();
	hList.add(new HuffmanCode("a",.1));
	hList.add(new HuffmanCode("b",.2));
	hList.add(new HuffmanCode("c",.08));
	hList.add(new HuffmanCode("d",.02));
	hList.add(new HuffmanCode("e",.05));
	hList.add(new HuffmanCode("f",.05));
	hList.add(new HuffmanCode("g",.04));
	hList.add(new HuffmanCode("h",.03));
	hList.add(new HuffmanCode("i",.2));
	hList.add(new HuffmanCode("j",.23));
	
//	hList.add(new HuffmanCode("a",.21));
//	hList.add(new HuffmanCode("b",.09));
//	hList.add(new HuffmanCode("c",.01));
//	hList.add(new HuffmanCode("d",.33));
//	hList.add(new HuffmanCode("e",.36));
	
	
	//make a copy of the list
	for(int i = 0; i < hList.size(); i++){
		hListcopy.add(new HuffmanCode("",0));
		hList.get(i).dlone(hListcopy.get(i));
	}
	
	
	while(hListcopy.size() >= 2)
	nArray = add2smallest(hListcopy,nArray);
	
	makeTreeF(nArray);
	//System.out.println(nArray);
	System.out.println("\n");
	Node root = nArray.get(nArray.size()-1);
	//System.out.println(root.right);
	root.printTree(0);
	screen x = new screen();
	x.setNode(root);
	
	//nArray.get(nArray.size()-1).printTree(nArray.get(nArray.size()-1).right);
	//System.out.println(nArray.get(nArray.size()-1).right);
	
	
	
}
@Override
public int compareTo(HuffmanCode o) {
	if(this.prob == o.prob)
	return 0;
	if(this.prob > o.prob){
		return 1;}
	else
		return -1;
}
}
