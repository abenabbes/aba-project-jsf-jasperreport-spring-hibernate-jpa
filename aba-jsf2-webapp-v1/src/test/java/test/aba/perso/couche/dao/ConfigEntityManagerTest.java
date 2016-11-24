/**
 * 
 */
package test.aba.perso.couche.dao;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author ali
 *
 */
public class ConfigEntityManagerTest {

	public static void main(String[] args) throws NamingException {
	   
//		Properties env = new Properties();
//	    env.put("java.naming.factory.initial","com.sun.jndi.cosnaming.CNCtxFactory");
//
//	    Context ctx = new InitialContext(env);
	    
		// cr�er l'Entity Manager suffit � construire la couche JPA 
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("aba-hibernate-jpa-spring-v1_PU"); 

	    EntityManager em=emf.createEntityManager(); 

	    // lib�ration ressources 
	    em.close(); 

	    emf.close(); 

	}
}
