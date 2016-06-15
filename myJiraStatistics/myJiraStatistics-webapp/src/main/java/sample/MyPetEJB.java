package sample;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MyPetEJB {

	@PersistenceContext
	private EntityManager entityManager;

	public void saveMyPet(MyPet pet) {
		entityManager.persist(pet);
	}
	
	public void removeMyPet(MyPet pet) {
		entityManager.remove(entityManager.merge(pet));
	}
	
	public List<MyPet> loadMyPets() {
		return entityManager.createNamedQuery(MyPet.GET_ALL_PETS, MyPet.class)
				.getResultList();
	}
}
