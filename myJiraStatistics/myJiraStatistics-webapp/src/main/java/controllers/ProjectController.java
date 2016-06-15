package controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import entities.Project;
import services.ProjectService;

@Named
@SessionScoped
public class ProjectController implements Serializable{
	private static final long serialVersionUID = 1L;
	@EJB
	private ProjectService projectService;
	
	List<Project> projects= new ArrayList<>();
	
	Project projectToBeSaved;
	
	List<Project> filteredMessages;
	

	@PostConstruct
	public void init() {
		projects = projectService.loadProjects();
		/*Project p = new Project(1L,"ed","df");
		projects.add(p);*/
		projectToBeSaved = new Project();
		
		//mockup
		if (projects == null) {  
			projects = new ArrayList<Project>(); 
        for (int i = 0; i < 10; i++) {  
        	Project project = new Project();  
        	project.setProject("project " +  i);  
        	project.setFte("fte 1" + i); 
        	//project.setTextLength(((i * 10) + 10) + "");  
        	project.setCurrentId("ID" + i);  
        	projects.add(project);  
        }  
		}
		
	}
	
	public void saveProject(){
		projectService.saveProject(projectToBeSaved);
		projects.add(projectToBeSaved);		
		projectToBeSaved = new Project();
	}


	public List<Project> getProjects() {
		return projects;
	}


	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project getProjectToBeSaved() {
		return projectToBeSaved;
	}

	public void setProjectToBeSaved(Project projectToBeSaved) {
		this.projectToBeSaved = projectToBeSaved;
	}
	
	public List<Project> getFilteredMessages() {
		return filteredMessages;
	}

	public void setFilteredMessages(List<Project> filteredMessages) {
		this.filteredMessages = filteredMessages;
	}
	
	public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edited", ((Project) event.getObject()).getCurrentId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Project) event.getObject()).getCurrentId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
		
}
