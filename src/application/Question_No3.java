//Student name: Showan Simkhada
//Student ID: 17459655
//Pledge of Honor: I pledge by honor that this program is solely my own work.

package application;

public class Question_No3 {

	public static void main(String[] args) 
	{
		// creating two arrays
		Rectangle[] rectangleArray1 =
			{
					new Rectangle("white", 4, 3),
					new Rectangle("red", 9, 5),
					new Rectangle("purple", 3, 6),
					new Rectangle("orange", 15, 10),
					new Rectangle("black", 4, 14),
			};
		Rectangle[] rectangleArray2 =
			{
					new Rectangle("pink", 3, 4),
					new Rectangle("red", 10, 2),
					new Rectangle("white", 8, 5),
					new Rectangle("blue", 14, 4),
					new Rectangle("bindle", 10, 15),
			};
		int count = 0;
		int count1 = 0;
		for(int i = 0; i < rectangleArray1.length; i++)
		{
			for (int j = 0; j < rectangleArray2.length; j++)
			{
				if(rectangleArray1[i].getColour() == rectangleArray2[j].getColour())
				{
					count++;
				}
				if(rectangleArray1[i].getPerimeter() == rectangleArray2[j].getPerimeter())
				{
					count1++;
				}
			}
		}
		System.out.println("There are " + count + " rectangle objects with overlapping colours between the two arrays.");
		System.out.println("There are " + count1 + " rectangle objects with overlapping perimeters between the two arrays.");
	}

}

// creating the sub class which uses the main class
class Rectangle extends Shape
{
	private double height;
	private double width;
	Rectangle(String colour, double height, double width)
	{
		// calling the supper class
		super(colour);
		this.height = height;
		this.width = width;
	}
	
	public double getHeight()
	{
		return height;
	}
	
	public void setHeight(double height)
	{
		this.height = height;
	}
	
	public double getWidth()
	{
		return width;
	}
	
	public void setWidth(double width)
	{
		this.width = width;
	}
	
	@Override public String getShapeType()
	{
		return ("Rectangle");
	}
	
	public double getPerimeter()
	{
		double per = 0;
		per = 2*(getWidth() + getHeight());
		return (per);
	}
}

// creating the super class shape
class Shape
{
	private String colour;
	// creating the shape constructor with one parameters
	Shape(String colour)
	{
		this.colour = colour;
	}
	
	// creating getters and setters for the color
	public String getColour()
	{
		return(colour);
	}
	
	public void setColour(String colour)
	{
		this.colour = colour;
	}
	
	// return method which returns the value of the string
	public String getShapeType()
	{
		return ("General Shape");
	}
}
