package sample;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = MyPet.GET_ALL_PETS, query = "SELECT pet from MyPet pet")
//@NamedQuery(name = MyPet.GET_ALL_PETS, query = "SELECT pet from MyPet pet WHERE pet.type ='CAT'")
public class MyPet {

	public final static String GET_ALL_PETS = "GET_ALL_PETS";

	private Long id;
	private String name;
	private String type;
	private int age;

	public MyPet() {
	}

	public MyPet(String name, String type, int age) {
		super();
		this.name = name;
		this.type = type;
		this.age = age;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
