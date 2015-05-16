//Ian Garrett, Assignment2, igarrett@uoregon.edu, CIS 212 Fall 2014
import java.math.*;
public class Sphere implements AreaMeasurable {
	
	private double _radius;
	
	public Sphere(double radius) {
		_radius = radius;
	}
	
	public double getArea() {
		return 4*Math.PI*Math.pow(_radius, 2);
	}

}
