package entities;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = Project.GET_ALL_PROJECTS, query = "SELECT p from Project p")
public class Project {
	public final static String GET_ALL_PROJECTS = "GET_ALL_PROJECTS";
	private Long id;
	private String project;
	private String fte;
	private String currentId;
	private int capacity;
	
	public Project (){	
		
	}

	public Project(Long id, String project, String fte, String currentId, int capacity) {
		super();
		this.project = project;
		this.fte = fte;
		this.id = id;
		this.currentId = currentId;
		this.capacity = capacity;
	}	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getFte() {
		return fte;
	}

	public void setFte(String fte) {
		this.fte = fte;
	}

	public String getCurrentId() {
		return currentId;
	}

	public void setCurrentId(String currentId) {
		this.currentId = currentId;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
}
