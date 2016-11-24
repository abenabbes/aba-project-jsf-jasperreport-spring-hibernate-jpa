/**
 * 
 */
package aba.perso.couche.dao;

import aba.perso.couche.dao.entite.TaskEntite;
import aba.perso.couche.generic.IGenericDAO;

/**
 * @author ali
 *
 */
public interface ITaskDao extends IGenericDAO<TaskEntite>{
	
	 public void ajouterEntite(TaskEntite entity);

}
