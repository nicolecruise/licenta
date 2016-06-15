package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.StatisticsData;

@Stateless
public class ExternalDataService {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void saveStatisticsData(StatisticsData data) {
		entityManager.persist(data);
	}
	
	public void removeStatisticsData(StatisticsData data) {
		entityManager.remove(entityManager.merge(data));
	}
	
	public List<StatisticsData> loadStatisticsData() {
		
		return entityManager.createNamedQuery(StatisticsData.GET_ALL_Data, StatisticsData.class)
				.getResultList();
	}
}



