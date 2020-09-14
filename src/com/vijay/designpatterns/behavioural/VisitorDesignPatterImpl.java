package com.vijay.designpatterns.behavioural;

/*
 * visitor pattern :
 * Separate algorithm from object  to add new operation to existing object .
 *  just modify the algo not the object.
 *  if you need to perform ops across a separate set of objs migth be the pattern for you 
 *  
 *  Aop is vistor 
 *  it creates an external class that uses data in the other class
 *  what is proxy then?
 *  
 *  
 *  
 *  visitor , concreteVisitor , Element , Concrete Element.
 *  
 *  when to use :  distinct and unrelated ops to perform across the structure of obj
 *  
 *  element accepts a visitor
 *  visitor is given element data and he gives output.
 *  
 *  Employee and tax advisor
 *  tax advisor commes to employee and takes his data and gives tax 
 *  seems like cyclic dependency so use setters.
 */
public class VisitorDesignPatterImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeInt softEmp = new SoftwareEmployee();
		 softEmp.setSalary(60000);
		TaxAdvisor ta1 = new TaxAdvisor1();
		TaxAdvisor ta2 = new TaxAdvisor2();
		
		softEmp.callTaxAdvisor(ta1);
		softEmp.callTaxAdvisor(ta2);
		
	}

}

interface EmployeeInt
{
	public void callTaxAdvisor(TaxAdvisor t);
	public int getSalary();
	public void setSalary(int salary);
}
interface TaxAdvisor
{
	public void employeeData(EmployeeInt emp);
	public void calculateTax();
}

class SoftwareEmployee implements  EmployeeInt
{
	int salary;
	
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public void callTaxAdvisor(TaxAdvisor taxAdv) {
		// TODO Auto-generated method stub
		taxAdv.employeeData(this);
		taxAdv.calculateTax();
	}
	
}

class TaxAdvisor1 implements TaxAdvisor
{
	 EmployeeInt emp;
	@Override
	public void employeeData(EmployeeInt emp) {
		// TODO Auto-generated method stub
		this.emp=emp;
	}
	
	public void calculateTax()
	{
		System.out.println("tax is"+(emp.getSalary()/8));
	}
	
}
class TaxAdvisor2 implements TaxAdvisor
{
	 EmployeeInt emp;
	@Override
	public void employeeData(EmployeeInt emp) {
		// TODO Auto-generated method stub
		this.emp=emp;
	}
	
	public void calculateTax()
	{
		System.out.println("tax is"+(emp.getSalary()/4));
	}
	
}
