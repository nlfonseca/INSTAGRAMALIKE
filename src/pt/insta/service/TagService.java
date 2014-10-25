package pt.insta.service;

import java.io.File;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;

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

import pt.insta.business.Comment;
import pt.insta.business.Photo;
import pt.insta.business.PhotosList;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

@Path("/tags")
public class TagService {
	// ===========================================
	// GET
	// ===========================================
	/**
	 * 
	 * @param tagName
	 * @return list of tags with "tagName"
	 * @throws UnknownHostException
	 */

	@GET
	@Path("/{tagName}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getPhotosTag(@PathParam("tagName") String tagName) throws UnknownHostException {
		
		MongoClient mongoClient = new MongoClient("localhost" , 27017);
		DB db = mongoClient.getDB("insta");
		DBCollection collection = db.getCollection("photos");
		
		DBObject query = (DBObject) JSON.parse("{ 'tags': { $in: ['" + tagName + "'] } }");
		
		DBCursor cursor = collection.find(query);
		
		PhotosList photosList = new PhotosList();
		
		while(cursor.hasNext()) {
			DBObject next = cursor.next();
			Photo t = new Photo();
			
			t.setId((String) next.get("_id"));
//			t.setFile((File) next.get("photo"));
//			t.setTags((ArrayList<String>) next.get("tags"));
//			t.setLikes((String) next.get("likes"));
//			t.setViews((String) next.get("views"));
//			t.setOwnerId((String) next.get("ownerid"));
//			t.setOwnerUsername((String) next.get("ownerusername"));
//			t.setDate((String) next.get("date"));
//			t.setComments((Collection<Comment>) next.get("_id"));
			
			photosList.add(t);
		}
		
		mongoClient.close();
		
		return Response.ok(photosList).build();
	}
	
	// ===========================================
	// POST
	// ===========================================
}
