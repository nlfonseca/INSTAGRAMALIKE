package pt.insta.service;

import java.io.File;
import java.net.UnknownHostException;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pt.insta.business.Photo;
import pt.insta.business.User;
import pt.insta.business.UserList;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

@Path("/user")
public class UserService {
	
	// ===========================================
	// GET
	// ===========================================
	/**
	 * 
	 * @param name
	 * @return list of users with "name"
	 * @throws UnknownHostException
	 */
	@GET
	@Path("/{name}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getUser(@PathParam("name") String name) throws UnknownHostException {
		
		MongoClient mongoClient = new MongoClient("localhost" , 27017);
		DB db = mongoClient.getDB("insta");
		DBCollection collection = db.getCollection("users");
		
		DBObject query = (DBObject) JSON.parse("{'username': '" + name + "'}");
		
		DBCursor cursor = collection.find(query);
		
		UserList usersList = new UserList();
		
		while(cursor.hasNext()) {
			DBObject next = cursor.next();
			User u = new User();
			
			u.setId((String) next.get("id"));
			u.setPhotoFile((File) next.get("photo"));
			u.setUsername((String) next.get("username"));
			
			usersList.add(u);
		}
		
		mongoClient.close();
		
		return Response.ok(usersList).build();
	}
	
	// ===========================================
	// POST
	// ===========================================
//	@POST
//	@Path("/{userID}/uploadPhoto")
//	public Response uploadPhoto(
//			@FormParam("photoFile") File photoFile,
//			@FormParam("photoTitle") String photoTitle,
//			@FormParam("description") String description) throws UnknownHostException {
//		
//		MongoClient mongoClient = new MongoClient("localhost" , 27017);
//		DB db = mongoClient.getDB("insta");
//		DBCollection collPhotos = db.getCollection("photos");
//		
//		// insert
//		
//		
//		mongoClient.close();
//		
//		return Response.status(200).entity("OK").build();
//	}
}
