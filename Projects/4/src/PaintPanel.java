//Ian Garrett, Assignment4, igarrett@uoregon.edu, CIS 212 Fall 2014
//
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JPanel;

public class PaintPanel extends JPanel {
	private int POINT_SIZE = 10;
	private ArrayList<custPoints> _points;
	public Color _color;
	
	//Paint Component
	public PaintPanel() {
		_points = new ArrayList<custPoints>();
		_color = Color.BLACK;
		
		//Event Listeners, click and drag mouse
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent ev) {
				int x = ev.getX();
				int y = ev.getY();
				int size = POINT_SIZE;
				Color color = _color;
				_points.add(new custPoints(color,x,y,size));
				repaint();
				}
			});
		
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent ev) {
				int x = ev.getX();
				int y = ev.getY();
				int size = POINT_SIZE;
				Color color = _color;
				_points.add(new custPoints(color,x,y,size));
				repaint();
				}
			});
	}
			
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (custPoints custPoints : _points) {
			g.setColor(custPoints._color);
			g.fillOval(custPoints._x, custPoints._y, custPoints._size, custPoints._size);
		}
	
	}
	
	//Color Functions
	public void setBlue() {
		_color = Color.BLUE;
	}
	
	public void setGreen() {
		_color = Color.GREEN;
	}
	
	public void setRed() {
		_color = Color.RED;
	}
	
	public void setBlack() {
		_color = Color.BLACK;
	}
	
	//Size Functions
	public void setSmall() {
		POINT_SIZE = 5;
	}
	
	public void setMedium() {
		POINT_SIZE = 10;
	}
	
	public void setLarge() {
		POINT_SIZE = 15;
	}
	
	//Clear Function
	public void clearPaint() {
		_points = new ArrayList<custPoints>();
		repaint();
	}
}