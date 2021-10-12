package control;
import model.*;
import model.arrayContainers.queues.StaticQeueWithArray;

public class SimpleTest {
	
	public static void main(String[] args) {
		
		StaticQeueWithArray<Integer> qeue = new StaticQeueWithArray<Integer>(Integer.class, 100);
		
		for(int i=0; i<50; i++) {
			
			qeue.push(i);
			
		}
		
		System.out.println(qeue);
		System.out.println("La posicion 0 contiene:");
		System.out.println(qeue.get(0));
		for(int i=0; i<60; i++) {
			qeue.push(i+50);
			
		}
		System.out.println(qeue);
		System.out.println("La posicion 50 contiene:");
		System.out.println(qeue.get(50));
		for(int i  = 0; i<50; i++) {
			System.out.println("Se elimina el numero:" + qeue.pop());
		}
		System.out.println(qeue);
		System.out.println(qeue.pop());
		for(int i=0; i<50; i++) {
			qeue.push(i+100);
			
		}
		
		//qeue.clean();
		System.out.println(qeue);
		System.out.println(qeue.pop());
		
	}
	
}
