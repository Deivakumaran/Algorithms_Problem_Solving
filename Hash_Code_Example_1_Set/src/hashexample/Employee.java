/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashexample;

import java.util.Objects;

/**
 *
 * @author PeaceFull
 */
public class Employee 
{
    
        private String name;
	private int age ;
	
	public Employee( int age,String name )
	{
		super();
		this.age = age;
                this.name=name;
	}
	/*if want to compare two objects based upon the equals() method 
        you have to override both hashCode() and equals() methods. */
        @Override
	public int hashCode()
	{
		return Objects.hash(name,age);
	}
	
        @Override
	public boolean equals( Object obj )
	{
		boolean flag = false;
		Employee emp = ( Employee )obj;
		if( Objects.equals(name,emp.name) &&(Objects.equals(age,emp.age))) 
			flag = true;
		return flag;
	}
}
