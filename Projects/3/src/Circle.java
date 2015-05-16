//Ian Garrett, Assignment2, igarrett@uoregon.edu, CIS 212 Fall 2014
import java.math.*;
public class Circle implements AreaMeasurable {
	
	private double _radius;
	
	public Circle(double radius) {
		_radius = radius;
	}
	public double getArea() {
		return (Math.PI*Math.pow(_radius, 2));
	}

}
