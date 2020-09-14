package com.vijay.designpatterns.behavioural;

import java.util.ArrayList;
import java.util.List;

/*
 * An object(Observable) maintains a list of its dependents 
 * called observers and notifies them automatically of any state changes
 * 
 * so a Observable which has updates , 
 * it should maintain a list of observers which can are waiting for updates
 * if there is a update then it should call the observers and give info to them
 * https://www.baeldung.com/java-observer-pattern
 */
public class ObservorDesignPatternImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 University jntu = new  University();
		 College bvrit = new Bvrit();
		 College vnr= new VNR();
		 jntu.addCollege(bvrit);
		 jntu.addCollege(vnr);
		 jntu.setNotification("tommorow is holiday");
		 jntu.updateNotification();
		 jntu.setNotification("exams are postponed");
		 jntu.updateNotification();
	}

}

// university  is observable
// colleges are Observers

class University
{
	List<College> collegeList = new ArrayList();
	
	String notification;

	public void addCollege(College college)
	{
		collegeList.add(college);
	}
	public void removeCollege(College college)
	{
		collegeList.remove(college);
	}
	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}
	public void updateNotification()
	{
		for(College college :collegeList)
		{
			college.analyzeUniNot(notification);
		}
	}
}

interface College
{
	public void analyzeUniNot(String notification);
	
}

class Bvrit implements College
{

	@Override
	public void analyzeUniNot(String notification) {
		// TODO Auto-generated method stub
		System.out.println("students of bvrit notification from uni->"+notification);
	}
	
}

class VNR implements College
{
	public void analyzeUniNot(String notification) {
		// TODO Auto-generated method stub
		System.out.println("students of VNR notification from uni ->"+notification);
	}
	
}
