package huffmanCode;
import java.util.*;
public class HuffmanCode implements Comparable<HuffmanCode>{
	char letter;
	double prob;
	public HuffmanCode(char iletter, double iprob){
		letter = iletter;
		prob = iprob;
	}
	public String toString(){
		return "\nletter:"+ this.letter + " probability: "+this.prob+ "\n";
	}
	public boolean isLessThan(HuffmanCode s){
		if(prob<s.prob){
			return true;
		}
		else{
			return false;
		}
	}
	public void swap(HuffmanCode s){
		char temp = letter;
		double tempd = prob;
		letter = s.letter;
		prob = s.prob;
		s.letter = temp;
		s.prob = tempd;
	}
public static void main(String[] args){
	LinkedList<HuffmanCode> hList = new LinkedList<HuffmanCode>();
	hList.add(new HuffmanCode('a',.22));
	hList.add(new HuffmanCode('b',.66));
	hList.add(new HuffmanCode('c',.12));
	
	System.out.println("before sort " +hList);
	Collections.sort(hList);
	System.out.println("after "+ hList);
}
@Override
public int compareTo(HuffmanCode o) {
	if(this.prob == o.prob)
	return 0;
	if(this.prob>o.prob){
		return 1;}
	else
		return -1;
}
}
