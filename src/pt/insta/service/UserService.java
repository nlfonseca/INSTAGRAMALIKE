package pt.insta.service;

import java.io.File;
import java.net.UnknownHostException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

@Path("/user")
public class UserService {
	
	// ===========================================
	// GET
	// ===========================================
	
	
	// ===========================================
	// POST
	// ===========================================
	@POST
	@Path("/{userID}/uploadPhoto")
	public Response uploadPhoto(
			@FormParam("photoFile") File photoFile,
			@FormParam("photoTitle") String photoTitle,
			@FormParam("description") String description) throws UnknownHostException {
		
		MongoClient mongoClient = new MongoClient("localhost" , 27017);
		DB db = mongoClient.getDB("insta");
		DBCollection collPhotos = db.getCollection("photos");
		
		// insert
		
		
		mongoClient.close();
		
		return Response.status(200).entity("OK").build();
	}
}
