import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.MouseInfo;
import java.util.ArrayList;
import java.util.Scanner;

public class HashAssign2{
	private static HashTable<Emotionodes>emotions = new HashTable<Emotionodes>();
	
	public static void populate(HashTable emotions) throws IOException{
		Scanner inFile = new Scanner(new BufferedReader (new FileReader("creeper.txt")));
		
		String line;
		
		while(inFile.hasNextLine()){
			line = inFile.nextLine();
			emotions.add(new Emotionodes(line));
		}
		
	}
	
	public static void main(String[]args) throws IOException{
		populate(emotions);
		WindsorMap frame = new WindsorMap(emotions);	
	}
}

class Emotionodes{
	private int x, y, lH, hS, eB;
	private int hashCode;
	
	public Emotionodes(String info){
		String [] items = info.split(" ");
		x = Integer.parseInt(items[0]);
		y = Integer.parseInt(items[1]);
		lH = Integer.parseInt(items[2]);
		hS = Integer.parseInt(items[3]);
		eB = Integer.parseInt(items[4]);
		hashCode = x*1000 + y;
		
	}
	
	@Override
	public int hashCode(){return hashCode;}
	
	public int getX(){return x;}
	public int getY(){return y;}
	public int getLH(){return lH;}
	public int getHS(){return hS;}
	public int getEB(){return eB;}
	
}

class WindsorMap extends JFrame{ 
	MapPanel map;
	public int mx, my;
	boolean draw = false;
		
    public WindsorMap(HashTable emotions) {
		super("Windsor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);

		map = new MapPanel(this, emotions);
		add(map);


		setResizable(false);
		setVisible(true);
    }    
    
}

class MapPanel extends JPanel implements MouseListener{
	private Image back;
	private WindsorMap mainFrame;
	private int mx,my;
	private static HashTable<String>emotions = new HashTable<String>();
	
	public MapPanel(WindsorMap m, HashTable emotions){
		back = new ImageIcon("windsor.PNG").getImage();
		mainFrame = m;
		setSize(800,570);
		addMouseListener(this);
		this.emotions = emotions;
	}
	
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }
	
	public void show(){
		Point mouse = MouseInfo.getPointerInfo().getLocation();
		Point offset = getLocationOnScreen();
		System.out.println("("+(mouse.x-offset.x)+", "+(mouse.y-offset.y)+")");
	}
	
	public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {
    	mx = e.getX();
		my = e.getY();
		repaint();
    }
    
    public void paintComponent(Graphics g){ 	
    	g.drawImage(back,0,0,null);
    	int emotioncount = 0;
    	double LHcol, HScol, EBcol;
    	ArrayList<Emotionodes>emotionlist = new ArrayList<Emotionodes>();
    	
    	for(int i = -10; i < 10; i++){
    		for(int j = -10; j < 10; j++){
    			emotioncount = 0;
    			LHcol = 0;
    			HScol = 0;
    			EBcol = 0;
    			if(Math.pow(i,2)+Math.pow(j,2) <= 100){
    				int emotioncode = (mx+i)*1000+(my+j);
    				emotionlist = emotions.getAll(emotioncode);
    				for(Emotionodes emotion : emotionlist){
    					emotioncount++;
    					LHcol += emotion.getLH();
    					HScol += emotion.getHS();
    					EBcol += emotion.getEB();
    					LHcol = LHcol/emotioncount;
    					HScol = HScol/emotioncount;
    					EBcol = EBcol/emotioncount;
    				}
    				if(emotioncount > 0){
    					LHcol = (((LHcol+100)/(double)200.0)*225);
    					HScol = (((HScol+100)/(double)200.0)*225);
    					EBcol = (((EBcol+100)/(double)200.0)*225);
    					g.setColor(new Color((int)LHcol,(int)HScol,(int)EBcol));
    					g.drawRect((mx+i),(my+j),1,1);
    				}
    			}
    		}
    	}
    
    	
    }
}