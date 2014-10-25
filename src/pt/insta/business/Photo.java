package pt.insta.business;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "")
public class Photo implements Serializable {
	private String id;
	private File photoFile;
	private ArrayList<String> tags;
	private String likes;
	private String views;
	private String ownerid;
	private String ownerusername;
	private String date;
	private Collection<Comment> comments;
	
	public Photo() {
		setId(null);
		setFile(null);
		setTags(null);
		setLikes(null);
		setViews(null);
		setOwnerId(null);
		setOwnerUsername(null);
		setDate(null);
		setComments(null);
	}
	
	// GET
	public String getId() {
		return id;
	}
	
	public File getPhotoFile() {
		return photoFile;
	}
	
	public ArrayList<String> getTags() {
		return tags;
	}
	
	public String getLikes() {
		return likes;
	}
	
	public String getViews() {
		return views;
	}
	
	public String getOwnerId() {
		return ownerid;
	}
	
	public String getOwnerUsername() {
		return ownerusername;
	}
	
	public String getDate() {
		return date;
	}
	
	public Collection<Comment> getComments() {
		return comments;
	}
	
	//SET
	public void setId(String i) {
		this.id = i;
	}
	
	public void setFile(File f) {
		this.photoFile = f;
	}
	
	public void setTags(ArrayList<String> t) {
		this.tags = t;
	}
	
	public void setLikes(String l) {
		this.likes = l;
	}
	
	public void setViews(String v) {
		this.views = v;
	}
	
	public void setOwnerId(String oId) {
		this.ownerid = oId;
	}
	
	public void setOwnerUsername(String oUsername) {
		this.ownerusername = oUsername;
	}
	
	public void setDate(String d) {
		this.date = d;
	}
	
	public void setComments(Collection<Comment> c) {
		this.comments = c;
	}
}
