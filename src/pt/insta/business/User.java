package pt.insta.business;

import java.io.File;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "")
public class User implements Serializable {
	private String id;
	private File photoFile;
	private String username;
	
	public User() {
		setId(null);
		setPhotoFile(null);
		setUsername(null);
	}
	
	// GET
	public String getId() {
		return id;
	}
	
	public File getPhotoFile() {
		return photoFile;
	}
	
	public String getUsername() {
		return username;
	}
	
	//SET
	public void setId(String i) {
		this.id = i;
	}
	
	public void setPhotoFile(File f) {
		this.photoFile = f;
	}
	
	public void setUsername(String usernm) {
		this.username = usernm;
	}
}
