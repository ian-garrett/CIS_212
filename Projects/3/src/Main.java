//Ian Garrett, Assignment2, igarrett@uoregon.edu, CIS 212 Fall 2014
import java.util.ArrayList;
import java.util.Random;
public class Main {
	//Part 3 
	public static void main(String[] args) {
		ArrayList<AreaMeasurable> arr_list = new ArrayList<AreaMeasurable>();
		int circle_count = 0;
		int rectangle_count = 0;
		int square_count = 0;
		int sphere_count = 0;
		int box_count = 0;
		int cube_count = 0;
		
		for (int i =0; i < 1000; i++) {
			double random = Math.random();
			if (random<(.16666)) {
				arr_list.add(new Circle(nextRandomDouble()));
				circle_count += 1;
			}
			else if (random<(.16666*2)) {
				arr_list.add(new Rectangle(nextRandomDouble(),nextRandomDouble()));
				rectangle_count += 1;
			}
			else if (random<(.5)) {
				arr_list.add(new Square(nextRandomDouble()));
				square_count += 1;
			}
			else if (random<(.16666*4)) {
				arr_list.add(new Sphere(nextRandomDouble()));
				sphere_count += 1;
			}
			else if (random<(.16666*5)) {
				arr_list.add(new Box(nextRandomDouble(),nextRandomDouble(),nextRandomDouble()));
				box_count += 1;
			}
			else {
				arr_list.add(new Cube(nextRandomDouble()));
				cube_count += 1;
			}
				
		
		}
		System.out.print("cirles: ");
		System.out.print(circle_count);
		System.out.print(" rects: ");
		System.out.print(rectangle_count);
		System.out.print(" squares: ");
		System.out.print(square_count);
		System.out.print(" boxes: ");
		System.out.print(box_count);
		System.out.print(" cubes: ");
		System.out.print(cube_count);
		System.out.print("\n\nsum: ");
		System.out.print(calculateSum(arr_list));
	}
	//Part 1
	private static double nextRandomDouble() {
		Random random_num = new Random();
		double chance = random_num.nextDouble();
		return chance;
	}
	
	//Part 2
	private static double calculateSum(ArrayList<AreaMeasurable> arraylist) {
		double result = 0;
		for (int i = 0; i < arraylist.size(); i++) {
			AreaMeasurable a = arraylist.get(i);
			result += a.getArea();
			
		}
		return result;
	}

}
