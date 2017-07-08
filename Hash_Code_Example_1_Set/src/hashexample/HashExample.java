/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashexample;

import java.util.HashSet;

/**
 *
 * @author PeaceFull
 */
public class HashExample {

    /**
     * @param args the command line arguments
     */
    
    

    public static void main(String[] args) {
               Employee emp1 = new Employee(23,"deiva");
		Employee emp2 = new Employee(24,"kumar");
		Employee emp3 = new Employee(25,"vignesh");
		Employee emp4 = new Employee(26,"prasanna");
		Employee emp5 = new Employee(22,"prasanna");
                
                System.out.println(emp1.hashCode());
                
                System.out.println(emp2.hashCode());
                System.out.println(emp3.hashCode());
                System.out.println(emp4.hashCode());
                System.out.println(emp5.hashCode());
               
		HashSet<Employee> hs = new HashSet<Employee>();
		hs.add(emp1);
		hs.add(emp2);
		hs.add(emp3);
		hs.add(emp4);
		hs.add(emp5);
		
		System.out.println("HashSet Size--->>>"+hs.size());
		System.out.println("hs.contains( new Emp(25))--->>>"+hs.contains(new Employee(25,"vignesh")));
		System.out.println("hs.remove( new Emp(24)--->>>"+hs.remove( new Employee(24,"kuma")));
		System.out.println("Now HashSet Size--->>>"+hs.size());
    }
}
    


