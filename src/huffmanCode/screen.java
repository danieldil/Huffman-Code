package huffmanCode;

import java.applet.Applet;
import java.awt.*;


public class screen extends Applet {
	  String text = "I'm a simple applet";
	  Node x;
	  HuffmanCode d;
	  int width = 900;
	  public void setNode(Node x){
		  this.x = x;
	  }
	  public void init() {
	        text = "I'm a simple applet";
	        setBackground(Color.black);
	        setSize(900, 500);
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
	  public void paint(Graphics g){
		  	
	        System.out.println("Paint");
	        g.setColor(Color.black);
	        g.drawRect(0, 0, getSize().width -1,getSize().height -1);
	        g.setColor(Color.red);
	        g.drawString(text, 15, 25);
	        d = new HuffmanCode("d",.3);
	        HuffmanCode a = new HuffmanCode("a",.5);
	        HuffmanCode c = new HuffmanCode("c",.2);
	        Node k = new Node(a, null, null, "9");
	        Node y = new Node(c, null, null, "6");
	        x = new Node(d, k,y,"dad");
	        System.out.println(x);
	        char[] label = x.data.letter.toCharArray();
	        char[] labelleft = x.left.label.toCharArray();
	        char[] labelright = x.right.label.toCharArray();
	        int ovalX = 100;//width/2 -25;
	        int ovalY = 150;
	        int ovalP = 20;
	        int ovalSize = 50;
	        int ovalCentery = ovalY+17;
	        int ovalCenterx = ovalX+23;
	        int leftOvalx = ovalX -40;
	        int leftOvaly = ovalCentery+90;
	        int rightOvalx = ovalX + 40;
	        int rightOvaly = ovalCentery+90;
	        g.setColor(Color.white);
	        //left line
	        g.drawLine(ovalCenterx,ovalCentery,leftOvalx+30,leftOvaly);
	        //right line
	        g.drawLine(ovalCenterx,ovalCentery,rightOvalx+19,rightOvaly);
	        //
	        g.setColor(Color.green);
	        //draw left circle
	        g.fillOval(leftOvalx,leftOvaly, ovalSize, ovalSize);
	        //draw right circle
	        g.fillOval(rightOvalx,rightOvaly, ovalSize, ovalSize);
	        //draw the root
	        g.fillOval(ovalX, ovalY, ovalSize, ovalSize);
	        g.setColor(Color.white);
	        g.setColor(Color.BLACK);
	        g.drawChars(label,0,label.length,ovalX+ovalP,ovalY+ovalP);	        
	        g.drawChars(labelleft,0,label.length,leftOvalx+ovalP,leftOvaly+ovalP);
	        g.drawChars(labelright,0,label.length,rightOvalx+ovalP,rightOvaly+ovalP);
	        System.out.println(labelleft);


	  }

}
