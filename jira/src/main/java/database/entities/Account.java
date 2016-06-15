package database.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;
	private Status status;

	private String role;

	private long lastLoginTime = 0;

	public Account() {
	}

	public Account(Long id, String name, Status status, String role, long lastLoginTime) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.role = role;
		this.lastLoginTime = lastLoginTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public long getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	// Date lastLogin = new Date(lastLoginTime);
	// long timestamp = new Date(lastLogin.getTime());

	// long val = 1346524199000l;
	// Date date=new Date(val);
	// SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yy");
	// String dateText = df2.format(lastLogin);
	// System.out.println(dateText);

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static String getCurrentTimeStamp() {
		long val = 1346524199000l;
		SimpleDateFormat currDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date(val);
		String strDate = currDate.format(now);
		return strDate;

		// format = new SimpleDateFormat("dd MMMM yyyy zzzz", Locale.ENGLISH);
		// DateToStr = format.format(curDate);
		// System.out.println(DateToStr);
	}
}
