/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashexample;

/**
 *
 * @author PeaceFull
 */
public class Employee 
{
	private int age ;
	
	public Employee( int age )
	{
		super();
		this.age = age;
	}
	/*if want to compare two objects based upon the equals() method 
        you have to override both hashCode() and equals() methods. */
        @Override
	public int hashCode()
	{
		return age;
	}
	
        @Override
	public boolean equals( Object obj )
	{
		boolean flag = false;
		Employee emp = ( Employee )obj;
		if( emp.age == age )
			flag = true;
		return flag;
	}
}
