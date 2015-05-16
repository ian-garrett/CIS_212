//Ian Garrett, Assignment4, igarrett@uoregon.edu, CIS 212 Fall 2014
//Creates GUI interface
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
	private static PaintPanel _paintPanel;
	public static void main(String[] args) {
		//Full Frame
		JFrame frame = new JFrame("Main");
		frame.setLayout(new BorderLayout());
		
		//Color Panel
		JPanel buttonPanel1= new JPanel();
		
		//Size Panel
		JPanel buttonPanel2 = new JPanel();
		buttonPanel1.setLayout(new GridLayout(4,1));
		buttonPanel2.setLayout(new GridLayout(4,1));
		
		//Paint Canvas
		_paintPanel = new PaintPanel();
		_paintPanel.setPreferredSize(new Dimension(400, 400));		
		frame.add(_paintPanel, BorderLayout.CENTER);
		frame.add(buttonPanel1, BorderLayout.WEST);
		frame.add(buttonPanel2, BorderLayout.EAST);
		
		//COLOR BUTTONS
		JButton blackButton =  new JButton("Black");
		blackButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				_paintPanel.setBlack();
			}
		});
		JButton blueButton =  new JButton("Blue");
		blueButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				_paintPanel.setBlue();
			}
		});
		JButton redButton =  new JButton("Red");
		redButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				_paintPanel.setRed();
			}
		});
		JButton greenButton =  new JButton("Green");
		greenButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				_paintPanel.setGreen();
			}
		});
		
		//SIZE BUTTONS
		JButton smallButton =  new JButton("Small");
		smallButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				_paintPanel.setSmall();
			}
		});
		JButton mediumButton =  new JButton("Medium");
		mediumButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				_paintPanel.setMedium();
			}
		});
		JButton largeButton =  new JButton("Large");
		largeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				_paintPanel.setLarge();
			}
		});
		
		//CLEAR BUTTON
		JButton clearButton =  new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				_paintPanel.clearPaint();
			}
		});
		
		//Populate the button panels
		buttonPanel1.add(blackButton);
		buttonPanel1.add(blueButton);
		buttonPanel1.add(redButton);
		buttonPanel1.add(greenButton);
		buttonPanel2.add(smallButton);
		buttonPanel2.add(mediumButton);
		buttonPanel2.add(largeButton);
		buttonPanel2.add(clearButton);
		
		//Pack, set close operation, set visible
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.setVisible(true);
	}

}