/**
 * 
 */
package test.aba.perso.couche.dao;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import aba.perso.couche.dao.entite.TaskEntite;

/**
 * @author ali
 *
 */
@ContextConfiguration(locations={ "classpath:config/dataSourcesContext.xml" }) 
@RunWith(SpringJUnit4ClassRunner.class) 
@TestExecutionListeners(value = DependencyInjectionTestExecutionListener.class)
@TransactionConfiguration(defaultRollback=true, transactionManager="transactionManager")
@Transactional
public class AjouterTaskDaoTest {

	 @Test
	 public void test2(){
		 
		 EntityManager em = null;
		 
		 try {
			 EntityManagerFactory emf = Persistence.createEntityManagerFactory("aba-hibernate-jpa-spring-v1_PU");
			 em = emf.createEntityManager();
			 EntityTransaction et = em.getTransaction();
			 et.begin();
			 
			 assertNotNull(em);

		        TaskEntite person = new TaskEntite();
		        person.setDateTask(Calendar.getInstance().getTime());
		        person.setNomTask("Nom_Test");
		        em.persist(person);
		        
		        System.out.println(person.getIdTask());

		        TaskEntite p = (TaskEntite)em.find(TaskEntite.class, 1);
		        System.out.println(person.getIdTask());

		        assertNotNull(p);
		} catch (Exception e) {
			 System.out.println("ERREUR");
		}
		 finally{
			if( em != null){
			    em.clear();
			}
		 }
		 
		 
		 
		 
		 
//	        EntityManagerFactory factory = Persistence.createEntityManagerFactory("aba-hibernate-jpa-spring-v1_PU");
//	        EntityManager theManager = factory.createEntityManager();
//	        theManager .getTransaction().begin();
//	        assertNotNull(theManager);
//
//	        TaskEntite person = new TaskEntite();
//	        person.setDateTask(Calendar.getInstance().getTime());
//	        person.setNomTask("Nom_Test");
//	        theManager.persist(person);
//	        
//	        System.out.println(person.getIdTask());
//
//	        TaskEntite p = (TaskEntite)theManager.find(TaskEntite.class, 1);
//	        System.out.println(person.getIdTask());
//
//	        assertNotNull(p);
	    }
}
