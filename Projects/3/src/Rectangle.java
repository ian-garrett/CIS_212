//Ian Garrett, Assignment2, igarrett@uoregon.edu, CIS 212 Fall 2014
public class Rectangle implements AreaMeasurable {
	
	private double _length;
	private double _width;
	
	public Rectangle(double length, double width) {
		_length = length;
		_width = width;
	}
	
	public double getArea() {
		return _length*_width;
	}

}
