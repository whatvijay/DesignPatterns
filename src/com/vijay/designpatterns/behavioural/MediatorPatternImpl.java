package com.vijay.designpatterns.behavioural;

/*
 * Objects no longer communicate with each other instead do it through a mediator object
 * promotes loose coupling
 * example chat app where everyone interacts with chat app
 */
/*
 * when to use
 * Comprehension 
 * Decoupled
 * Simple Obj protocols
 * limits sub classing
 * 
 * when not to use : if design is not proper and is complex
 * 
 * GFG
 * Advantage

    It limits subclassing. A mediator localizes behavior that otherwise would be distributed among several objects. Changing this behaviour requires subclassing Mediator only, Colleague classes can be reused as is.

Disadvantage

    It centralizes control. The mediator pattern trades complexity of interaction for complexity in the mediator. Because a mediator encapsulates protocols, it can become more complex than any individual colleague. This can make the mediator itself a monolith that’s hard to maintain

 */
public class MediatorPatternImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
