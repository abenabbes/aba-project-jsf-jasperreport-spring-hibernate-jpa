/**
 * 
 */
package aba.perso.couche.dao.entite;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author ali
 *
 */
@Entity
@Table(name="TASK")
public class TaskEntite implements Serializable{

	//ATTRIBUTS
	/** Serializable. */
	private static final long serialVersionUID = -546808427233159127L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_TASK", unique=true , nullable = false, updatable = false)
	private Long idTask;
	
	@Column(name = "NOM_TASK")
	private String nomTask;
	
	@Column(name = "DATE_TASK")
	@Temporal(TemporalType.DATE)
	private Date dateTask;

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

	public Date getDateTask() {
		return dateTask;
	}

	public void setDateTask(Date dateTask) {
		this.dateTask = dateTask;
	}

	@Override
	public String toString() {
		return "TaskEntite [idTask=" + idTask + ", nomTask=" + nomTask
				+ ", dateTask=" + dateTask + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateTask == null) ? 0 : dateTask.hashCode());
		result = prime * result + ((idTask == null) ? 0 : idTask.hashCode());
		result = prime * result + ((nomTask == null) ? 0 : nomTask.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskEntite other = (TaskEntite) obj;
		if (dateTask == null) {
			if (other.dateTask != null)
				return false;
		} else if (!dateTask.equals(other.dateTask))
			return false;
		if (idTask == null) {
			if (other.idTask != null)
				return false;
		} else if (!idTask.equals(other.idTask))
			return false;
		if (nomTask == null) {
			if (other.nomTask != null)
				return false;
		} else if (!nomTask.equals(other.nomTask))
			return false;
		return true;
	}

}
