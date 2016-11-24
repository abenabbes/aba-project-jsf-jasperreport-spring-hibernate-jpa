/**
 * 
 */
package aba.perso.couche.service;

import aba.perso.couche.dao.entite.TaskEntite;

/**
 * @author ali
 *
 */
public interface ITaskService {
	
	/**
	   * Ajouter une task
	   *
	   * @param task task 
	   */
	  public void ajouterTask(TaskEntite task);

}
