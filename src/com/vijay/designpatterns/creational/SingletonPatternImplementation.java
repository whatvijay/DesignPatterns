package com.vijay.designpatterns.creational;

/*
 * it has to give same instance always. So creation of new object should be limited to one.
 * so new operator has to be called only once when there is no instance
 * 
 */
/*
 * when to use - use it when we are interacting with resources like database logging email e.t.c
 * 
 *
 */
//https://dzone.com/articles/all-about-the-singleton
//https://dzone.com/articles/singleton-design-pattern-%E2%80%93
//https://dzone.com/articles/singleton-design-pattern-%E2%80%93 
//https://stackoverflow.com/questions/26949503/how-exactly-is-the-logger-a-singleton-and-how-are-different-log-files-created-i 
/*
 * when to avoid - avoid the pattern 
 * unit tests - creates problems during mocks
 * violates cohesiveness principle
 * serializable  -it will create 2 objects so implement with extra care
 * classloaders - it will give a singleton for each classloader
 */

public class SingletonPatternImplementation {

	  static SingletonPatternImplementation singletonPatternImplementation ;
	 
	 //making it private to ensure no other class will be able to call it
	 private SingletonPatternImplementation()
	 {
		
		 
	 }
	 
	 //expose object to outside world through getter
	 // since it should called directly we use static
	 //should we use synchronized?
	 //thread safety
	 
	 public static SingletonPatternImplementation getSingletonPatternImplementation()
	 {
		//ensuring construction of object happens only once
		 if(null == singletonPatternImplementation)
		 {
			 //sync()
			 // if(null == singletonPatternImplementation)
			singletonPatternImplementation= new SingletonPatternImplementation();
		 }
		 return singletonPatternImplementation;
	 }
}
