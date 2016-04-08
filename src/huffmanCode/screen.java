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
	        int ovalX = width/2 -25;
	        int ovalY = 15;
	        int ovalP = 20;
	        int ovalCentery = 35;
	        int ovalCenterx = width/2 -2;
	        int leftOvalx = width/2-2 - 50 -ovalP;
	        int leftOvaly = 35 +90;
	        int rightOvalx = width/2 -2+50-ovalP;
	        int rightOvaly = 35+90;
	        g.setColor(Color.white);
	        //left line
	        g.drawLine(ovalCenterx,ovalCentery,leftOvalx+30,leftOvaly);
	        //
	        g.drawLine(width/2-2,35,width/2-2 + 50,35 +90);
	        //
	        g.setColor(Color.green);
	        g.fillOval(leftOvalx,leftOvaly, 50, 50);
	        g.fillOval(width/2-2 + 50 -ovalP,35 +90, 50, 50);
	        //draw the root
	        g.fillOval(width/2 -25, 15, 50, 50);
	        g.setColor(Color.white);
	        g.setColor(Color.BLACK);
	        g.drawChars(label,0,label.length,ovalX+ovalP,ovalY+ovalP);	        
	        g.drawChars(labelleft,0,label.length,leftOvalx+ovalP,leftOvaly+ovalP);
	        g.drawChars(labelright,0,label.length,rightOvalx+ovalP,rightOvaly+ovalP);
	        System.out.println(labelleft);


	  }

}
