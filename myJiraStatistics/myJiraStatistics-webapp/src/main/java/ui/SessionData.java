package ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import entities.StatisticsData;
import services.ExternalDataService;

@Named
@SessionScoped
public class SessionData implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private ExternalDataService externalData;
	
	private List<StatisticsData> dataList;
	
	private StatisticsData dataToBeSaved;
	
	private List<StatisticsData> allData;

	@PostConstruct
	public void init() {
		
		dataList = new ArrayList<StatisticsData>();
		
		//Mockup Data
		dataList.add(new StatisticsData(1L, "Connect", "Support", 151, 300));
		dataList.add(new StatisticsData(2L, "Connect", "User Story", 115, 200));
		dataList.add(new StatisticsData(3L, "Connect", "Service Requests", 157, 600));
		dataList.add(new StatisticsData(4L, "SOM", "Support", 125, 100));
		dataList.add(new StatisticsData(5L, "SOM", "Incident", 135, 230));
		dataList.add(new StatisticsData(6L, "SOM", "Support", 111, 360));
		dataList.add(new StatisticsData(7L, "SOM", "Story", 110, 312));
		dataList.add(new StatisticsData(8L, "Connect", "User Story", 153, 213));
		dataList.add(new StatisticsData(9L, "Connect", "Spike", 105, 206));
		dataList.add(new StatisticsData(10L, "Connect", "Support", 119, 295));
		
		for(StatisticsData d: dataList){
			//externalData.saveStatisticsData(d);
		}
//		ExternalDataService data = findData(6L);
//		    System.out.println("# " + data);
		
		dataToBeSaved = new StatisticsData();
		allData = externalData.loadStatisticsData();
//		
//		for(StatisticsData dl: dataList){
//			if (!allData.contains(dl)){
//				externalData.saveStatisticsData(dl);				
//			}			
//		}
	}

	
	public List<StatisticsData> getDataList() {
		return dataList;
	}


	public void setDataList(List<StatisticsData> dataList) {
		this.dataList = dataList;
	}


	public List<StatisticsData> getAllData() {
		return allData;
	}


	public void setAllData(List<StatisticsData> allData) {
		this.allData = allData;
	}

	public StatisticsData getDataToBeSaved() {
		return dataToBeSaved;
	}
	
	public void setDataToBeSaved(StatisticsData dataToBeSaved) {
		this.dataToBeSaved = dataToBeSaved;
	}

	public void saveNewData() {
		externalData.saveStatisticsData(dataToBeSaved);
		dataToBeSaved = new StatisticsData();
	}
	
	public void removeData(StatisticsData data) {
		externalData.removeStatisticsData(data);
		allData = externalData.loadStatisticsData();
	}
	
	public void logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		System.out.println("User logout");
	}
	

	 /**
	   * Gets an entity manager
	   */
//	  private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
//	  
//	  @Inject
//	  private static EntityManager em = emf.createEntityManager();
	
	
//	@PostConstruct
//	public void init() {
//		externalDataList = new ArrayList<StatisticsData>();
//		
//		//Mockup Data
//		externalDataList.add(new StatisticsData(1L, "Connect", "Support", 151, 300));
//		externalDataList.add(new StatisticsData(2L, "Connect", "User Story", 115, 200));
//		externalDataList.add(new StatisticsData(3L, "Connect", "Service Requests", 157, 600));
//		externalDataList.add(new StatisticsData(4L, "SOM", "Support", 125, 100));
//		externalDataList.add(new StatisticsData(5L, "SOM", "Incident", 135, 230));
//		externalDataList.add(new StatisticsData(6L, "SOM", "Support", 111, 360));
//		externalDataList.add(new StatisticsData(7L, "SOM", "Story", 110, 312));
//		externalDataList.add(new StatisticsData(8L, "Connect", "User Story", 153, 213));
//		externalDataList.add(new StatisticsData(9L, "Connect", "Spike", 105, 206));
//		externalDataList.add(new StatisticsData(9L, "Connect", "Support", 119, 295));
//		
//		ExternalDataService data = findData(6L);
//		    System.out.println("# " + data);
//		
//	}
//	  /**
//	   * Persists the data to the database
//	   */
//	  private static void persistData(ExternalDataService data) {
//	    em.persist(data);
//	  }
//	  
//	  /**
//	   * Finds the data from the database
//	   */
//	  private static ExternalDataService findData(Long id) {
//	    return em.find(ExternalDataService.class, id);
//	  }

	  
	//test prime faces  
	public String sayHello() {
		return "Hello World!!!";
	}
}
