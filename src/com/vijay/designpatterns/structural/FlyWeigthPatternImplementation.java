package com.vijay.designpatterns.structural;

import java.util.HashMap;
import java.util.Map;

/*
 * minimizes memory use by sharing as much data as possible with other similar objects
 * it is used when larger part of an objects state can be made external.
 * 
 * sharing what is sharable and computing what is not
 * intrinsic values (const and not stored in memory)
 * extrinsic are not constnt and need to be calculated on fly and not put in memory
 *  
 *  to implement flywiegth  we need flywietgth interface and its implementation(shares common values)
 * 
 * a factory(singleton) to return flywiegth objects.
 * state and strategy objects are implemented using flyweigth
 * use when
 * Requirement demands large amount of objects to be created
 * leave a low mem foot print
 * 
 * avoid there is no priority for memory
 * 
 */

/*
 * For Demo purpose take a example of fetching balls of different colors 
 * Will fetch 18 balls of 3 different colors by using only 3 objects .
 * 
 *
 */
public class FlyWeigthPatternImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BallFactory ballFactory = new BallFactory();
		Ball sampleBall;
		sampleBall =ballFactory.giveMeABall("RED");
		System.out.println(sampleBall.color+":"+sampleBall.hashCode());
		sampleBall =ballFactory.giveMeABall("GREEN");
		System.out.println(sampleBall.color+":"+sampleBall.hashCode());
		sampleBall =ballFactory.giveMeABall("BLUE");
		System.out.println(sampleBall.color+":"+sampleBall.hashCode());
		System.out.println("2 set");
		sampleBall =ballFactory.giveMeABall("RED");
		System.out.println(sampleBall.color+":"+sampleBall.hashCode());
		sampleBall =ballFactory.giveMeABall("GREEN");
		System.out.println(sampleBall.color+":"+sampleBall.hashCode());
		sampleBall =ballFactory.giveMeABall("BLUE");
		System.out.println(sampleBall.color+":"+sampleBall.hashCode());
		System.out.println("3 set");
		sampleBall =ballFactory.giveMeABall("RED");
		System.out.println(sampleBall.color+":"+sampleBall.hashCode());
		sampleBall =ballFactory.giveMeABall("GREEN");
		System.out.println(sampleBall.color+":"+sampleBall.hashCode());
		sampleBall =ballFactory.giveMeABall("BLUE");
		System.out.println(sampleBall.color+":"+sampleBall.hashCode());
		System.out.println("4 set");
		sampleBall =ballFactory.giveMeABall("RED");
		System.out.println(sampleBall.color+":"+sampleBall.hashCode());
		sampleBall =ballFactory.giveMeABall("GREEN");
		System.out.println(sampleBall.color+":"+sampleBall.hashCode());
		sampleBall =ballFactory.giveMeABall("BLUE");
		System.out.println(sampleBall.color+":"+sampleBall.hashCode());
		System.out.println("5 set");
		sampleBall =ballFactory.giveMeABall("RED");
		System.out.println(sampleBall.color+":"+sampleBall.hashCode());
		sampleBall =ballFactory.giveMeABall("GREEN");
		System.out.println(sampleBall.color+":"+sampleBall.hashCode());
		sampleBall =ballFactory.giveMeABall("BLUE");
		System.out.println(sampleBall.color+":"+sampleBall.hashCode());
		System.out.println("6 set");
		sampleBall =ballFactory.giveMeABall("RED");
		System.out.println(sampleBall.color+":"+sampleBall.hashCode());
		sampleBall =ballFactory.giveMeABall("GREEN");
		System.out.println(sampleBall.color+":"+sampleBall.hashCode());
		sampleBall =ballFactory.giveMeABall("BLUE");
		System.out.println(sampleBall.color+":"+sampleBall.hashCode());
	}
// observed same hash code for ball with same color in each set
}

interface BallInterface
{
	public String myColor(String color);
}

class Ball implements BallInterface
{

	String color;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String myColor(String color) {
		// TODO Auto-generated method stub
		this.color=color;
		return this.color;
	}
	
}
// we have to make this as singleton but for brevity and simplicity taking on core logic.
// making it singleton ensure only one set of objects are reused.
class BallFactory
{
	// it maintains a ballbag
	private Map<String,Ball> ballBag = new HashMap();
	
	public Ball giveMeABall(String color)
	{
		if(null !=ballBag && ballBag.containsKey(color))
		{
			return ballBag.get(color);
		}
		else
		{
			Ball newBall = new Ball();
			newBall.myColor(color);
			ballBag.put(color,newBall);
			return newBall;
		}
	}
}
