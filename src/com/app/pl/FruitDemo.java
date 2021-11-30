package com.app.pl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.app.entities.Fruit;

public class FruitDemo {

	public static void main(String[] args) {
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPA-PU1");
		EntityManager em= emf.createEntityManager();
		
//		Fruit f1= new Fruit(1,"Mango","Yellow",550.00d,"Medium",true);
//		
//		em.getTransaction().begin();
//		
//		em.persist(f1);
//		
//		em.getTransaction().commit();
		
		Fruit managedfruit = em.find(Fruit.class, 1);  
		System.out.println(" obj found with id "+ managedfruit.getFruitid());
		System.out.println(managedfruit);
		
//		em.getTransaction().begin();
//		
//		Fruit f2= new Fruit(2,"Orange","Orange",200.00d,"Medium",true);
//		em.persist(f2);
//
//		em.flush();
//		em.getTransaction().commit();
//		
//		
//		 managedfruit = em.find(Fruit.class, 2);  // find managed instance by id
//		 System.out.println(" obj found with id "+ managedfruit.getFruitid());
//			System.out.println(managedfruit);
			
//			
//			em.getTransaction().begin();
//			
//			Fruit f2= new Fruit(3,"Grapse","Green",200.00d,"Medium",false);
//			em.persist(f2);
//
//			em.flush();
//			em.getTransaction().commit();
//		
		Fruit f = em.find(Fruit.class, 1);
		System.out.println(f);
		if(f != null) {
			f.setColor("YellowGreen");
		}
		em.getTransaction().begin();
		em.merge(f);
		em.getTransaction().commit();
		System.out.println(f);
		System.out.println("Detaching f");
		em.detach(f);
		System.out.println("Contains after detach ? "+em.contains(f));
		System.out.println("is is in db??"+em.find(Fruit.class, 1));
		
		
		
//		System.out.println("Removing f");
//		em.getTransaction().begin();
//		em.remove(f);
//		em.getTransaction().commit();
//		System.out.println("Contains after remove ? "+em.contains(f));
//		System.out.println(em.find(Fruit.class, 3));
		
		
		
		em.close();
		emf.close();

	}

}
