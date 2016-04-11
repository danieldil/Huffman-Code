package huffmanCode;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;


public class screen extends Applet {
	  String text = "I'm a simple applet";
	  Node x;//the root
	  int count = 0;
	  int width = 900;
      int ovalX = width/2 -25;
      int ovalY = 15;
      char[] label;
      char[] labelleft;
      char[] labelright;
      int ovalP = 20;
      int ovalSize = 50;
      int ovalCentery = ovalY+17;
      int ovalCenterx = ovalX+23;
      int leftOvalx = ovalX -40;
      int leftOvaly = ovalCentery+90;
      int rightOvalx = ovalX + 40;
      int rightOvaly = ovalCentery+90;
      Node root;
      public void setRootCoord(int x, int y){
    	  ovalX = x;
    	  ovalY = y;
          ovalP = 20;
          ovalSize = 50;
          ovalCentery = ovalY+17;
          ovalCenterx = ovalX+23;
          leftOvalx = ovalX -40;
          leftOvaly = ovalCentery+90;
          rightOvalx = ovalX + 40;
          rightOvaly = ovalCentery+90;
    	  
      }
	  public void setNode(Node x){
		  this.x = x;
	  }
	  public void paint3(Graphics g){
		  g.drawLine(1, 1, 50, 50);
	  }
	  public void init() {
		  	
		  text = "I'm a simple applet";
	      setBackground(Color.black);
	      setSize(900, 500);
	      ArrayList<Node> nArray = new ArrayList<Node>();
	      LinkedList<HuffmanCode> hList = new LinkedList<HuffmanCode>();
	      HuffmanCode d = new HuffmanCode("d",.3);
	      HuffmanCode a = new HuffmanCode("a",.5);
	      HuffmanCode c = new HuffmanCode("c",.2);
	      hList.add(d);
	      hList.add(a);
	      hList.add(c);
	        
	      while(hList.size() >= 2)
	    	  nArray = HuffmanCode.add2smallest(hList,nArray);
	    	
	      HuffmanCode.makeTreeF(nArray);
	      root = nArray.get(nArray.size()-1);
	      x = root;
	      x.printTree(0,' ');
	      //System.out.println(x);
  
	  }
	  public void start() {
	        System.out.println("starting...");
	  }
	  public void stop() {
	        System.out.println("stopping...");
	  }
	  public void destroy() {
	        System.out.println("preparing to unload...");
	  }
	  public void d(Graphics g, Node q){
		  
			x = q;
		  	label = x.data.letter.toCharArray();
	      	labelleft = x.left.data.letter.toCharArray();
	      	labelright = x.right.data.letter.toCharArray();
	      
		  
	        System.out.println("Paint");
	        g.setColor(Color.black);
	        //g.drawRect(0, 0, getSize().width -1,getSize().height -1);
	        g.setColor(Color.red);
	        g.drawString(text, 15, 25);
	        g.setColor(Color.white);
	        //left line
	        g.drawLine(ovalCenterx,ovalCentery,leftOvalx+30,leftOvaly);
	        //right line
	        g.drawLine(ovalCenterx,ovalCentery,rightOvalx+19,rightOvaly);
	        g.setColor(Color.green);
	        //draw left circle
	        g.fillOval(leftOvalx,leftOvaly, ovalSize, ovalSize);
	        //draw right circle
	        g.fillOval(rightOvalx,rightOvaly, ovalSize, ovalSize);
	        //draw the root
	        g.fillOval(ovalX, ovalY, ovalSize, ovalSize);
	        g.setColor(Color.white);
	        g.setColor(Color.black);
	        //draw root label
	        g.drawChars(label,0,label.length,ovalX+ovalP,ovalY+ovalP);	        
	        
	        if(labelleft != null)
	        g.drawChars(labelleft,0,labelleft.length,leftOvalx+ovalP,leftOvaly+ovalP);
	        if(labelright != null)
	        g.drawChars(labelright,0,labelright.length,rightOvalx+ovalP,rightOvaly+ovalP);
		  	
	        //x = q;
			if(q.left.data.prob == -1 && q.right.data.prob == -1){
				System.out.println("eneter the while loop?");
		  		d(g,q.left);
		  		d(g,q.right);
		  		count++;
			}
			else if(q.left.data.prob == -1.0 && q.right.data.prob != -1.0){
				setRootCoord(leftOvalx,leftOvaly);
				d(g,q.left);
			  	  //x = q.left;
			  System.out.println("hello from left");
				  //System.out.println(x.left.left+" is x double left");
			}
			else if(q.right.data.prob == -1.0 && q.left.data.prob != -1.0){
			  //setRootCoord(rightOvalx,rightOvaly);
			  	  d(g,q.right);
			  	  //x = q.right;
				  System.out.println("hello from right");
			}
			else if(q.right.data.prob != -1.0 && q.left.data.prob != -1.0){
				  x = q;  
			}
	  }
	  public void paint(Graphics g){
		  
		  System.out.println(x);
		  System.out.println(x.left+"APPLE");
		  System.out.println(x.right+"rAPPLE");
		  d(g,x);
	  }
	  

}
