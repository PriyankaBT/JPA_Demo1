package com.app.pl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.app.entities.Fruit;

public class FruitDemo {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU1");
	static EntityManager em = emf.createEntityManager();

	public static void main(String[] args) {

		Fruit f1 = new Fruit(1, "Mango", "Yellow", 550.00d, "Medium", true);

		em.getTransaction().begin();

		em.persist(f1);

		em.getTransaction().commit();

		Fruit managedfruit = em.find(Fruit.class, 1);
		System.out.println(" obj found with id " + managedfruit.getFruitid());
		System.out.println(managedfruit);

		Fruit f2 = new Fruit(2, "Orange", "Orange", 200.00d, "Medium", true);

		em.getTransaction().begin();
		em.persist(f2);
		em.flush();
		em.getTransaction().commit();

		managedfruit = em.find(Fruit.class, 2); // find managed instance by id
		System.out.println(" obj found with id " + managedfruit.getFruitid());
		System.out.println(managedfruit);

		f2 = new Fruit(3, "Grapse", "Green", 200.00d, "Medium", false);
		em.getTransaction().begin();
		em.persist(f2);

		em.flush();
		em.getTransaction().commit();

		Fruit f = em.find(Fruit.class, 1);

		System.out.println(f);
		if (f != null) {
			f.setColor("Green");
		}
		em.getTransaction().begin();
		em.merge(f);
		em.getTransaction().commit();
		System.out.println(f);
//		System.out.println("Detaching f");
//		em.detach(f);
//		System.out.println("Contains after detach ? "+em.contains(f));
//		System.out.println("is is in db??"+em.find(Fruit.class, 1));

//		System.out.println("Removing f");
//		em.getTransaction().begin();
//		em.remove(f);
//		em.getTransaction().commit();
//		System.out.println("Contains after remove ? "+em.contains(f));
//		System.out.println(em.find(Fruit.class, 3));

		Fruit obj = new Fruit();
		obj.setFruitid(4);
		obj.setFname("BANANA");
		obj.setColor("YellowWhite");
		obj.setSeedpresent(false);
		obj.setPrice(40.00d);
		obj.setSize("Medium");
		System.out.println(obj);

		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();

//		String str= "Select f1 From Fruit f1 where f1.color='YellowGreen'";
//		
//		Query q1 = em.createQuery(str);
//		
//		Fruit res= (Fruit) q1.getSingleResult();
//		
//		System.out.println("Query result : "+res);
//		
		String clr = "YellowWhite";
       
		//FruitDemo.getFruitByColor(clr);
		
		Query q= em.createNamedQuery("getFruitbyPrice");
		List<String> fruits = q.getResultList();
		
		System.out.println(fruits);
		
		 q= em.createNamedQuery("getFruitPrice");
		 q.setParameter("name1", "BANANA");
		double fruitprice = (double) q.getSingleResult();
		
		System.out.println("PRICE OF FRUIT ="+fruitprice);
		
		em.close();
		emf.close();

	}

	public static void getFruitByColor(String clr) {
		String str = "Select f1 From Fruit f1 where f1.color=:incolor";

		TypedQuery<Fruit> q1 = em.createQuery(str, Fruit.class);

		q1.setParameter("incolor", clr);

		// Fruit res= q1.getSingleResult();
		List<Fruit> res = q1.getResultList();

		System.out.println("Query result : " + res);

	}

}
