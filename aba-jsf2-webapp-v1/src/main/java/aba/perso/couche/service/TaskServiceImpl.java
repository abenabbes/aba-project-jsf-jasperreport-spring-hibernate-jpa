/**
 * 
 */
package aba.perso.couche.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aba.perso.couche.dao.ITaskDao;
import aba.perso.couche.dao.entite.TaskEntite;

/**
 * @author ali
 *
 */
@Service
public class TaskServiceImpl implements ITaskService {

	//============= ATTRIBUTS
	/** Logger */
	private static Logger LOGGER = LoggerFactory.getLogger(TaskServiceImpl.class);
	
	/** Appel àla couche DAO*/
	@Autowired
	private ITaskDao taskDao;
	
	@Override
	//@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void ajouterTask(TaskEntite task) {
		
		LOGGER.debug("DEBUT du service : [ajouterTask]");
		taskDao.ajouterEntite(task);
		LOGGER.debug("FIN du service : [ajouterTask]");
		
	}

}
