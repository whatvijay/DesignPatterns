package com.vijay.designpatterns.behavioural;

/*
 * Define skeleton of algorithm but defer exact steps to a sub class
 * hollywood principle - dont call us we will call you
 * 
 * it requires abstract class and concrete class
 * 
 * when to use - when we need an algo structure 
 */
/*
 * let us have a template game with methods like scorePoint duration penalty
 */
public class TemplateDesignPatternImpl {

	public static void main(String args[])
	{
		Game gameF = new Football();
		Game gameC = new Cricket();
		gameF.duration();
		gameF.numOfPlayers();
		gameF.penalty();
		gameF.scorePoint();
		
		 gameC.duration();
		 gameC.numOfPlayers();
		 gameC.penalty();
		 gameC.scorePoint();
		
	}
}

abstract class Game
{
	abstract public void scorePoint();
	abstract public void duration();
	abstract public void penalty();
	public void numOfPlayers()
	{
		System.out.println("no of players is eleven");
	}
}

class Cricket extends Game
{

	@Override
	public void scorePoint() {
		// TODO Auto-generated method stub
		System.out.println("runs and wickets");
	}

	@Override
	public void duration() {
		// TODO Auto-generated method stub
		System.out.println("6 hours");
	}

	@Override
	public void penalty() {
		// TODO Auto-generated method stub
		System.out.println("noball,wideball,legbye");
		
	}
	
}
class Football extends Game
{

	@Override
	public void scorePoint() {
		// TODO Auto-generated method stub
		System.out.println("goal");
	}

	@Override
	public void duration() {
		// TODO Auto-generated method stub
		System.out.println("90 min");
		
	}

	@Override
	public void penalty() {
		// TODO Auto-generated method stub
		System.out.println("touch by hand");
	}
	
}
