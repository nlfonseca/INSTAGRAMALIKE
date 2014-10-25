package pt.insta.business;

public class Comment {
	private String userID;
	private String text;
	
	public Comment(String uID, String txt) {
		userID = uID;
		text = txt;
	}
	
	// GET
	public String getUID() {
		return this.userID;
	}
	
	public String getText() {
		return this.text;
	}
	
	// SET
	public void setUID(String id) {
		this.userID = id;
	}
	
	public void setText(String txt) {
		this.text = txt;
	}
}
