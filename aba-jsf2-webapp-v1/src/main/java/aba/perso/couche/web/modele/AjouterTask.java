/**
 * 
 */
package aba.perso.couche.web.modele;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aba.perso.couche.dao.entite.TaskEntite;
import aba.perso.couche.service.ITaskService;


/**
 * @author ali
 *
 */
@Component
@ManagedBean
@ViewScoped
public class AjouterTask {
	
	// ============ ATTRIBUTS
	/** Logger */
	private static Logger LOGGER = LoggerFactory.getLogger(AjouterTask.class);
	
	
	/** Lobjet valeur de la Vue*/
	private TaskEntite taskDto;
	
	
	/** couche service*/
	@Autowired
	private ITaskService taskService;
	
	 /** Creates a new instance of Form */
//	public AjouterTask() {
//		taskDto = new TaskEntite();
//	}
	
	@PostConstruct
	public void init(){
		this.taskDto = new TaskEntite();
	}

	// ============ METHODES
	
	/**
	 * Methode pour ajouter .
	 * @return
	 */
	public String submit(){
		LOGGER.debug("DEBUT du bean manager : [submit]");
		
//		TaskEntite taskAjouter = new TaskEntite();
//		taskAjouter.setDateTask(taskDto.getDateTask());
//		taskAjouter.setNomTask(taskDto.getNomTask());
//		taskAjouter.setIdTask(888999L);
		
		//Ajouter
		taskService.ajouterTask(this.taskDto);
		
		LOGGER.debug("FIN du bean manager : [submit]");
		
	    return "SUCESS";
	  }

	
	// ============ GETTER && SETTER
	public TaskEntite getTaskDto() {
		return taskDto;
	}

	public void setTaskDto(TaskEntite taskDto) {
		this.taskDto = taskDto;
	}

	public ITaskService getTaskService() {
		return taskService;
	}

	public void setTaskService(ITaskService taskService) {
		this.taskService = taskService;
	}

}
