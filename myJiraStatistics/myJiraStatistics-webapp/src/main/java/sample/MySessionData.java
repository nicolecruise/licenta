
package sample;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class MySessionData implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private MyPetEJB myPetEJB;
	
	private MyPet petToBeSaved;
	
	private List<MyPet> pets;

	private int count;

	@PostConstruct
	public void init() {
		petToBeSaved = new MyPet();
		count = 0;
		pets = myPetEJB.loadMyPets();
	}

	public List<MyPet> getPets() {
		return pets;
	}	
	
	public int getCount() {
		return count;
	}

	public void increaseCount() {
		count++;
	}

	public String navigateToSetings() {
		if (count > 10) {
			return "settings";
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Insuficient counts"));
			return null;
		}
	}

	public void saveMyPet() {
		myPetEJB.saveMyPet(petToBeSaved);
		petToBeSaved = new MyPet();
	}
	
	public void removeMyPet(MyPet pet) {
		myPetEJB.removeMyPet(pet);
		pets = myPetEJB.loadMyPets();
	}
	
	public void logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}

	@PreDestroy
	public void cleanUp() {
		System.out.println("Session ended! with count: " + count);
	}
	
	public MyPet getPetToBeSaved() {
		return petToBeSaved;
	}
	
	public void setPetToBeSaved(MyPet petToBeSaved) {
		this.petToBeSaved = petToBeSaved;
	}
}





















//package sample;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
//import javax.faces.application.FacesMessage;
//import javax.faces.context.FacesContext;
//import javax.faces.view.ViewScoped;
//import javax.inject.Named;
//
//@Named
//@ViewScoped
//public class MySessionData implements Serializable {
//
//	private static final long serialVersionUID = 1L;
//	private MyPetEJB
//
//	private List<MyPet> pets;
//
//	private int count;
//
//	@PostConstruct
//	public void init() {
//		count = 0;
//		pets = new ArrayList<MyPet>();
//		pets.add(new MyPet("Kiki", "CAT", 3));
//		pets.add(new MyPet("Jojo", "MONKEY", 2));
//		pets.add(new MyPet("Peanuts", "DOG", 5));
//		pets.add(new MyPet("Arnold", "COBRA", 2));
//		pets.add(new MyPet("Lucky", "<script>alert('Hello! I am an alert box!!');</script>", 3));
//	}
//
//	public List<MyPet> getPets() {
//		return pets;
//	}	
//	
//	public int getCount() {
//		return count;
//	}
//
//	public void increaseCount() {
//		count++;
//	}
//
//	public String navigateToSetings() {
//		if (count > 10) {
//			return "settings";
//		} else {
//			FacesContext context = FacesContext.getCurrentInstance();
//			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Insuficient counts"));
//			return null;
//		}
//	}
//	
//	public void saveMyPet(){
//		
//	}
//
//	public void logout() {
//		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
//	}
//
//	@PreDestroy
//	public void cleanUp() {
//		System.out.println("Session ended! with count: " + count);
//	}
//}