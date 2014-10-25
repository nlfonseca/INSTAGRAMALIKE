package pt.insta.business;

import java.io.Serializable;
import java.util.Collection;
import java.util.Vector;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "")
public class PhotosList implements Serializable {
	@XmlElement(name = "")
	@XmlElementWrapper(name = "photos")
	private Collection<Photo> photos;
	
	public PhotosList() {
		photos = new Vector<Photo>();
	}
	
	public boolean add(Photo t) {
		return this.photos.add(t);
	}
	
	public Collection<Photo> getPhotos() {
		return photos;
	}
	
	public void setTags(Collection<Photo> photos) {
		this.photos = photos;
	}
}
