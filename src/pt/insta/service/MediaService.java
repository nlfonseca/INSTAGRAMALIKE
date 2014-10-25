package pt.insta.service;

import java.io.File;
import java.net.UnknownHostException;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.types.ObjectId;

import pt.insta.business.Comment;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

@Path("/media")
public class MediaService {
	
	// ===========================================
	// GET
	// ===========================================
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getCenas(
			@DefaultValue("1.60") @QueryParam("h") double height,
			@DefaultValue("60.0") @QueryParam("w") double weight) {

		double imc = 20;
		return Response.ok(imc).build();
	}
	
	
	// ===========================================
	// POST
	// ===========================================
	@POST
	@Path("/{photoID}/comments")
	public Response saveComment(
			@PathParam("photoID") String photoID,
			@FormParam("userID") String userID,
			@FormParam("commentText") String commentText) throws UnknownHostException {
		
		MongoClient mongoClient = new MongoClient("localhost" , 27017);
		DB db = mongoClient.getDB("insta");
		DBCollection collPhotos = db.getCollection("photos");
		
		Comment c = new Comment(userID, commentText);
		
		BasicDBObject obj = new BasicDBObject("comments", new BasicDBObject().append(c.getUID(), c.getText()));
		// comments : {c.getUID() : c.getText(), ... }
		BasicDBObject updateQuery = new BasicDBObject("$push", obj);
        
        ObjectId pID = new ObjectId(photoID);
    	BasicDBObject searchQuery = new BasicDBObject().append("_id", pID); // { _id: "asihdakshds" }
    	
    	collPhotos.update(searchQuery, updateQuery);
		
		mongoClient.close();
		
		return Response.status(200).entity("OK").build();
	}
	
	@POST
	@Path("/{photoID}/likes")
	public Response makeLike(
			@PathParam("photoID") String photoID,
			@FormParam("userID") String userID) throws UnknownHostException {
		
		MongoClient mongoClient = new MongoClient("localhost" , 27017);
		DB db = mongoClient.getDB("insta");
		DBCollection collPhotos = db.getCollection("photos");
		
		BasicDBObject obj = new BasicDBObject();
        obj.append("likes", userID); // { likes: 12873612 }
        
        BasicDBObject updateQuery = new BasicDBObject("$push", obj);
        
        ObjectId pID = new ObjectId(photoID);
    	BasicDBObject searchQuery = new BasicDBObject().append("_id", pID);
    	
    	collPhotos.update(searchQuery, updateQuery);
		
		mongoClient.close();
		
		return Response.status(200).entity("OK").build();
	}
	
	@POST
	@Path("/{photoID}/views")
	public Response addView(
			@PathParam("photoID") String photoID) throws UnknownHostException {
		
		MongoClient mongoClient = new MongoClient("localhost" , 27017);
		DB db = mongoClient.getDB("insta");
		DBCollection collPhotos = db.getCollection("photos");
		
		BasicDBObject updateQuery = new BasicDBObject().append("$inc", new BasicDBObject().append("views", 1));
        
        ObjectId pID = new ObjectId(photoID);
    	BasicDBObject searchQuery = new BasicDBObject().append("_id", pID);
    	
    	collPhotos.update(searchQuery, updateQuery);
		
		mongoClient.close();
		
		return Response.status(200).entity("OK").build();
	}
}
