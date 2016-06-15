package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Project;

@Stateless
public class ProjectService {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void saveProject(Project project) {
		entityManager.persist(project);
	}
	
	public void removeProject(Project project) {
		entityManager.remove(entityManager.merge(project));
	}
	
	public List<Project> loadProjects() {
		
		return entityManager.createNamedQuery(Project.GET_ALL_PROJECTS, Project.class)
				.getResultList();
	}
}