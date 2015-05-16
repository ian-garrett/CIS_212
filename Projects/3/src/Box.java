//Ian Garrett, Assignment2, igarrett@uoregon.edu, CIS 212 Fall 2014
public class Box implements AreaMeasurable {
	
	private double _length;
	private double _width;
	private double _height;
	
	public Box(double length, double width, double height) { //better way of doing this?
		_length = length;
		_width = width;
		_height = height;	
	}
	
	public double getArea() {
		return ((_length*_width)*2+(_length*_height)*2+(_height*_width)*2);
	}

}
