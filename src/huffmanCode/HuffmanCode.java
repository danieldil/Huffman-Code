package huffmanCode;
import java.util.*;
public class HuffmanCode implements Comparable<HuffmanCode>{
	String letter;
	double prob;
	public HuffmanCode(String iletter, double iprob){
		letter = iletter;
		prob = iprob;
	}
	public String toString(){
		return "\nletter:"+ this.letter + " probability: "+this.prob+ "\n";
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
	public static void add2smallest(LinkedList<HuffmanCode> s,ArrayList<Node> nArray){
		Collections.sort(s);
		if(s.size() >= 2){
			Node head;
			Node left = new Node(s.get(1),null,null);
			Node right = new Node(s.get(0),null,null);
			head = new Node(null,left,right);
			nArray.add(head);
			System.out.println(head);
			HuffmanCode add = 
			new HuffmanCode(s.get(1).letter + s.get(0).letter,s.get(1).prob+s.get(0).prob);
			s.remove(0);
			s.remove(0);
			//System.out.println(s);
			s.addFirst(add);
			//System.out.println(s);
			System.out.println(nArray);
		}
		else{
			System.out.println("too small of a list");
		}
	}
public static void main(String[] args){
	ArrayList<Node> nArray = new ArrayList<Node>();
	LinkedList<HuffmanCode> hList = new LinkedList<HuffmanCode>();
	hList.add(new HuffmanCode("a",.220));
	hList.add(new HuffmanCode("b",.660));
	hList.add(new HuffmanCode("c",.150));
	hList.add(new HuffmanCode("d",.290));
	hList.add(new HuffmanCode("e",.610));
	hList.add(new HuffmanCode("f",.100));
	hList.add(new HuffmanCode("g",.299));
	hList.add(new HuffmanCode("h",.860));
	hList.add(new HuffmanCode("i",.920));
	
	while(hList.size() > 2)
	add2smallest(hList,nArray);
	
	for(int i=0;i<nArray.size();i++){
		System.out.println(nArray.indexOf(i));
	}
	
	
	
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
