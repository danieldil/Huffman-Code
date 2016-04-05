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
			Node left = new Node(s.get(1),null,null,null);
			Node right = new Node(s.get(0),null,null,null);
//			}
//			else{
//				Node left = new Node(s.get(1),null,null);
//				Node right = new Node(s.get(0),null,null);
//			}
			head = new Node(null,left,right,s.get(1).letter + s.get(0).letter);
			nArray.add(head);
			//System.out.println(head);
			HuffmanCode add = 
			new HuffmanCode(s.get(1).letter + s.get(0).letter,s.get(1).prob+s.get(0).prob);
			s.remove(0);
			s.remove(0);
			//System.out.println(s);
			s.add(add);
			System.out.println(s);

			return nArray;
		}
		else{
			System.out.println("too small of a list");
		}
		return nArray;
	}
@SuppressWarnings("unchecked")
public static void main(String[] args){
	ArrayList<Node> nArray = new ArrayList<Node>();
	LinkedList<HuffmanCode> hList = new LinkedList<HuffmanCode>();
	LinkedList<HuffmanCode> hListcopy = new LinkedList<HuffmanCode>();
	hList.add(new HuffmanCode("a",.25));
	hList.add(new HuffmanCode("b",.15));
	hList.add(new HuffmanCode("c",.40));
	hList.add(new HuffmanCode("d",.20));
	hList.add(new HuffmanCode("e",.10));
	
	//make a copy of the list
	for(int i = 0; i < hList.size(); i++){
		hListcopy.add(new HuffmanCode("",0));
		hList.get(i).dlone(hListcopy.get(i));
	}
	
	
	while(hListcopy.size() >= 2)
	nArray = add2smallest(hListcopy,nArray);
	
	for(int i = nArray.size()-1; i >= 0 ; i--){
	System.out.println(nArray.get(i));
	System.out.println(i);
	
	}
	
//	for(int i=0;i<nArray.size();i++){
//		System.out.println(nArray.indexOf(i));
//	}
	
	
	
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
