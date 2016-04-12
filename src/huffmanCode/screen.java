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
          ovalSize = 40;
          ovalCentery = ovalY+17;
          ovalCenterx = ovalX+23;
          leftOvalx = ovalX -40;
          leftOvaly = ovalCentery+70;
          rightOvalx = ovalX + 40;
          rightOvaly = ovalCentery+70;  
      }
	  public void setNode(Node x){
		  this.x = x;
	  }
	  public void init() {
		  	
		  text = "I'm a simple applet";
	      setBackground(Color.black);
	      setSize(900, 500);
	      ArrayList<Node> nArray = new ArrayList<Node>();
	      LinkedList<HuffmanCode> hList = new LinkedList<HuffmanCode>();

	  	hList.add(new HuffmanCode("q",.29));
	  	hList.add(new HuffmanCode("j",.11));
	  	hList.add(new HuffmanCode("k",.14));
	  	hList.add(new HuffmanCode("y",.26));
	  	hList.add(new HuffmanCode("r",.19));
	  	hList.add(new HuffmanCode("m",.17));
	  	hList.add(new HuffmanCode("b",.67));
	  	

	        
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
	  public void d(Graphics g, Node q,int count){
		  	if(count == 0){
		  		leftOvalx -=90;
		  		rightOvalx +=90;
		  	}
		  	count++;
			x = q;
		  	label = x.data.letter.toCharArray();
	      	labelleft = x.left.data.letter.toCharArray();
	      	labelright = x.right.data.letter.toCharArray();
	      
	        System.out.println("Paint");
	        g.setColor(Color.red);
	        g.drawString(text, 15, 25);
	        g.setColor(Color.white);
	        //left line
	        g.drawLine(ovalCenterx,ovalCentery,leftOvalx+30,leftOvaly);
	        //right line
	        g.drawLine(ovalCenterx,ovalCentery,rightOvalx+19,rightOvaly);
	        g.setColor(Color.green);
	        //draw the root
	        g.fillOval(ovalX, ovalY, ovalSize, ovalSize);
	        if(q.right.data.prob != -1.0 && q.left.data.prob != -1.0 || count == 1)
	        	g.setColor(Color.yellow);
	        //draw left circle
	        if(count == -8)
	        	g.setColor(Color.yellow);
	        g.fillOval(leftOvalx,leftOvaly, ovalSize, ovalSize);
	        //draw right circle
	        g.fillOval(rightOvalx,rightOvaly, ovalSize, ovalSize);

	        g.setColor(Color.white);
	        g.setColor(Color.black);
	        //draw root label
	        g.drawChars(label,0,label.length,ovalX+ovalP,ovalY+ovalP);	        
	        
	        if(labelleft != null)
	        	g.drawChars(labelleft,0,labelleft.length,leftOvalx+ovalP,leftOvaly+ovalP);
	        if(labelright != null)
	        	g.drawChars(labelright,0,labelright.length,rightOvalx+ovalP,rightOvaly+ovalP);
		  	
			if(q.left.data.prob == -1 && q.right.data.prob == -1){
				System.out.println("eneter the both ?");
				x = root;
				setRootCoord(width/2 -25,15);
				setRootCoord(leftOvalx-90,leftOvaly);
				d(g,q.left,-9);
		  		x = root;
		  		setRootCoord(width/2 -25,15);
		  		setRootCoord(rightOvalx+90,rightOvaly);
		  		d(g,q.right,-9);
		  		//count++;
			}
			else if(q.left.data.prob == -1.0 && q.right.data.prob != -1.0){
				System.out.println("hello from left");
				setRootCoord(leftOvalx,leftOvaly);
				d(g,q.left,-9);
			}
			else if(q.right.data.prob == -1.0 && q.left.data.prob != -1.0){
				System.out.println("hello from right"); 
				setRootCoord(rightOvalx,rightOvaly);
				d(g,q.right,-9);
			  	  //x = q.right;
				  
			}
			else if(q.right.data.prob != -1.0 && q.left.data.prob != -1.0){
				System.out.println("hellofsdjkl");
				//return;
				//x = q;  
				//return;
			}
	  }
	  public void paint(Graphics g){
		  x = root;
		  setRootCoord(width/2 -25,15);
		  d(g,x,0);
	  }
	  

}
