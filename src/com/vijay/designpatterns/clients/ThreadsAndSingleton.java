package com.vijay.designpatterns.clients;

import com.vijay.designpatterns.creational.SingletonPatternImplementation;

public class ThreadsAndSingleton {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new CustomThread());
		Thread t2 = new Thread(new CustomThread());
		Thread t3 = new Thread(new CustomThread());
		Thread t4 = new Thread(new CustomThread());
		t1.start();
	   // t1.join(100);
		t2.start();
		t3.start();
		t4.start();
	}

	
}

class CustomThread implements Runnable
	{

	@Override
	public void run(){
		// TODO Auto-generated method stub
		int count =0;
		while(count <100)
		{
			count++;
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(SingletonPatternImplementation.getSingletonPatternImplementation().hashCode());
		}
	}
		
	}