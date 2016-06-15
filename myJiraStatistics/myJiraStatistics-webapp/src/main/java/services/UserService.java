package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.User;

@Stateless
public class UserService {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void saveUser(User user) {
		entityManager.persist(user);
		
	}
	
	public void removeUser(User user) {
		entityManager.remove(entityManager.merge(user));
	}
	
	public List<User> loadUsers() {
		
		return entityManager.createNamedQuery(User.GET_ALL_USERS, User.class)
				.getResultList();
	}
}



