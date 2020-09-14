package com.vijay.designpatterns.behavioural;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Capture and externalize an Objects internal object state 
 * so that the obj can be restored to this state later if needed
 * ex ; database rollbacks by transaction manager
 * 
 * Basic building blocks are 1) Originator 2)Caretaker 3)Momento
 * 
 */
public class MementoDesignPatternImpl {

	public static void main(String args[])
	{
		// will generate bill by giving amount to billgen which is originator
		// will save bill to bill keeper
		// due to some wrong amount i will roll back a bill;
		
		BillGen billGen = new BillGen();
		Bill b1=billGen.genBill(100);
		
		System.out.println(b1.billNum);
		BillKeeper billKeeper = new BillKeeper();
		billKeeper.addBill(b1);
		
	    // recheck
		if(b1.getBillAmount()>90)
		{
			billGen.getBillNumberFromBill(  billKeeper.getBillByNum(b1.getBillNum()));
		}
		Bill b2=billGen.genBill(100);
		billKeeper.addBill(b2);
	}
	
}
// consider an example of bill
// each bill can be made a momemto
// Bill Creator is originator
// Bill keeper is caretaker

class Bill
{
	int billNum;
	int billAmount;
	
	public int getBillNum() {
		return billNum;
	}
	public void setBillNum(int billNum) {
		this.billNum = billNum;
	}
	public int getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(int billAmount) {
		this.billAmount = billAmount;
	}
	
	
}

class BillGen
{
	// state of bill
	static int billNum =0;
	public Bill genBill(int amount)
	{
		Bill bill= new Bill();
		bill.setBillAmount(amount);
		billNum=billNum+1;
		bill.setBillNum(billNum);
		//bill.
		return bill;
	}
	
	public void getBillNumberFromBill(Bill b)
	{
		//rejecting current bill , rolling bill number to back by one
		billNum=b.getBillNum()-1;
	}
}
class BillKeeper
{

	static Map<Integer,Bill> billList = new HashMap();
	
	public void addBill(Bill b)
	{
		billList.put(b.getBillAmount(),b);
		
	}
	
	public Bill getBillByNum(int billNum)
	{
		return billList.get(billNum);
	}
}