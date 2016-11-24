/**
 * 
 */
package aba.perso.couche.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import aba.perso.couche.dao.entite.TaskEntite;
import aba.perso.couche.generic.GenericDAOImpl;

/**
 * @author ali
 *
 */
@Repository
public class TaskDaoImpl extends GenericDAOImpl<TaskEntite> implements ITaskDao{

	//============= ATTRIBUTS
	/** Logger */
	private static Logger LOGGER = LoggerFactory.getLogger(TaskDaoImpl.class);
		
	/** Définition du gestionnaire d'entités */
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void ajouterEntite(TaskEntite entity) {
		
		LOGGER.debug("DEBUT persistansce");
//		StringBuilder sql = new StringBuilder();
//		   
//		sql.append("INSERT INTO " + TaskEntite.class.getSimpleName());
//		sql.append(" (ID_TASK, DATE_TASK, NOM_TASK)");
//		sql.append("VALUES (?, ?, ?)");
//		
//		entityManager.createNativeQuery(sql.toString());
		
		em.persist(entity);
		
		LOGGER.debug("FIN persistansce");
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	

}
