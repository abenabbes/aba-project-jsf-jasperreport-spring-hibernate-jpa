/**
 * 
 */
package aba.perso.couche.web.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author ali
 *
 */
public class TaskDto implements Serializable{

	//ATTRIBUTS
	/**
	 * Serializable.
	 */
	private static final long serialVersionUID = 326264958577951567L;
	private Long idTask;
	private String nomTask;
	private Date dateTask;
	private List<String> listeElements;
	
	//GETTER et SETTER
	public Long getIdTask() {
		return idTask;
	}
	public void setIdTask(Long idTask) {
		this.idTask = idTask;
	}
	public String getNomTask() {
		return nomTask;
	}
	public void setNomTask(String nomTask) {
		this.nomTask = nomTask;
	}
	public List<String> getListeElements() {
		return listeElements;
	}
	public void setListeElements(List<String> listeElements) {
		this.listeElements = listeElements;
	}
	public Date getDateTask() {
		return dateTask;
	}
	public void setDateTask(Date dateTask) {
		this.dateTask = dateTask;
	}
}
