package pt.insta.business;

import java.io.Serializable;
import java.util.Collection;
import java.util.Vector;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "")
public class UserList implements Serializable {
	@XmlElement(name = "")
	@XmlElementWrapper(name = "users")
	private Collection<User> users;
	
	public UserList() {
		users = new Vector<User>();
	}
	
	public boolean add(User u) {
		return this.users.add(u);
	}
	
	public Collection<User> getUsers() {
		return users;
	}
	
	public void setUsers(Collection<User> users) {
		this.users = users;
	}
}
