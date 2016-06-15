package database.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.inject.Named;

@Named
@SessionScoped
public class ProjectView implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String console;
	   
    private String project;  
    private List<SelectItem> projects;
    
    
    @PostConstruct
    public void init() {
        //projects
        SelectItemGroup g1 = new SelectItemGroup("Search Engine");
        g1.setSelectItems(new SelectItem[] {
        		new SelectItem("Spike", "Spike"), 
        		new SelectItem("Incident", "Incident"), 
        		new SelectItem("Bug", "Bug"),
        		new SelectItem("Support", "Support"),
        		new SelectItem("Story", "Story"),
        		new SelectItem("ServiceRequest", "ServiceRequest")       		
        });
         
        SelectItemGroup g2 = new SelectItemGroup("SOM");
        g2.setSelectItems(new SelectItem[] {
        		new SelectItem("Story", "Story"), 
        		new SelectItem("Spike", "Spike"), 
        		new SelectItem("Support", "Support"),
        		new SelectItem("Bug", "Bug"),
        		new SelectItem("Incident", "Incident"),
        		new SelectItem("Training&Workshops", "Bug")
        
        });
         
        SelectItemGroup g3 = new SelectItemGroup("Connect");
        g3.setSelectItems(new SelectItem[] {
        		new SelectItem("Story", "Story"), 
        		new SelectItem("Spike", "Spike"), 
        		new SelectItem("Support", "Support"),
        		new SelectItem("Environment setup & prep activities", "Environment setup & prep activities")
        		
       });
        
        projects = new ArrayList<SelectItem>();
        projects.add(g1);
        projects.add(g2);
        projects.add(g3);
        
    }


	public String getConsole() {
		return console;
	}


	public void setConsole(String console) {
		this.console = console;
	}


	public String getProject() {
		return project;
	}


	public void setProject(String project) {
		this.project = project;
	}


	public List<SelectItem> getProjects() {
		return projects;
	}

        
}
