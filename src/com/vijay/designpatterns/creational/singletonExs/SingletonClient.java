package com.vijay.designpatterns.creational.singletonExs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SingletonClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println(BillPubgSingletonImpl.getInstance().hashCode());
			System.out.println(BillPubgSingletonImpl.getInstance().hashCode());
			System.out.println(BillPubgSingletonImpl.getInstance().hashCode());
			
			EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
			System.out.println(enumSingleton.getValue());
			enumSingleton.setValue(3);
			System.out.println(enumSingleton.getValue());
			System.out.println(enumSingleton.hashCode());
			EnumSingleton enumSingleton2 = EnumSingleton.INSTANCE;
			System.out.println(enumSingleton2.getValue());
			System.out.println(enumSingleton2.hashCode());
			
			SIngletonSerializable singleSerializable =SIngletonSerializable.getInstance();
			
			// serialize and deserialize
			
			try {
			  ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
		                "filename.ser"));
		        out.writeObject(singleSerializable);
		        out.close();
		        ObjectInput in = new ObjectInputStream(new FileInputStream(
		                "filename.ser"));
		        SIngletonSerializable instanceTwo = (SIngletonSerializable) in.readObject();
		        in.close();
		        System.out.println(singleSerializable.hashCode());
		        System.out.println(instanceTwo.hashCode());
			}
			catch(Exception e)
			{
				
			}
		        
	}

}
