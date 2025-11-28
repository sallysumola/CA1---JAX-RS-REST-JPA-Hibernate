package com.example.dit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


import com.example.dao.UserDAO;
import com.example.dao.EmissionDAO;
import com.example.dao.CategoryDAO;
import com.example.dit.model.User;
import com.example.dit.model.Emission;
import com.example.dit.model.Category;

@Path("/Greenhouse")
public class EmissionService {
	
    
 //// user !!! //
	
	//gets all members from Db using xml
	
	//test
	@GET
	@Path("/hello")
	@Produces("text/plain")
	public String hello () {
		return "hello";
	}

	@GET
    @Path("/usersfromDB")
    @Produces("application/xml")
    public List<User> listUserXML(){
        UserDAO dao = new UserDAO();
        return dao.getAllUsers();
    }
	
	//the same but with json
	@GET
    @Path("/usersJSONfromDB")
    @Produces("application/json")
    public List<User> listUsersJSON(){
       UserDAO dao = new UserDAO();
        return dao.getAllUsers();
    }
	@GET//get user by their username in XML
    @Path("/userfromDBJSON/{username}")
    @Produces("application/json")
    public User getUserByusernameFromDBXML(@PathParam("username")String username){
		UserDAO dao = new UserDAO();
		return dao.getUserByUsername(username);		
    }
	
	//create a new memeber using json - register
	
	@POST
	@Path("/newUser")
    @Consumes("application/json")
    public String addMemberToDBJSON(User user){
		UserDAO dao = new UserDAO();
		dao.persist(user);
		return "User is added: "+user.getUsername();	
    }
//update user
	@PUT
    @Path("/updateUser/")
    @Produces("application/json")
    public User updateUser(User user){
		UserDAO dao = new UserDAO();
		return dao.merge(user);	
    }
	
	//delete by their usernme
	@DELETE
    @Path("/deleteMember/{username}")
    @Produces("text/plain")
    public String deleteMember(@PathParam("username")String username){
		UserDAO dao = new UserDAO();
		User user = dao.getUserByUsername(username);
		dao.removeUser(user);	
		return "User  "+username+" deleted";
    }
	
/// ==========================
//------- Emission --------\\
//----------------------------
	
	//CREATING An emission
	@POST
	@Path("/newEmission")
    @Consumes("application/json")
    public String addEmission(Emission emission){
		EmissionDAO dao = new EmissionDAO();
		dao.persist(emission);
		return "This emission has been added to the database (json)";///+emission.getDescription();	
    }

	@GET//listing all emissions plans but xml
	@Path("/emissionXMLfromDB")
	@Produces("application/json")
	public List <Emission> ListPlansXML(){
		EmissionDAO dao = new EmissionDAO ();
		return dao.getAllEmissions();
		 // return Member ;
    }

	
	@GET//listing plans but with jjson
    @Path("/EmisionJSONfromDB")
    @Produces("application/json")
    public List<Emission> ListEmissionsJSON(){
       EmissionDAO dao = new EmissionDAO();
	return dao.getAllEmissions();
	}
	
@GET
@Path("/EmissionfromDBJSON/{id}")//-
@Produces("application/json")
public Emission getEmissionByIdJSON(@PathParam("Id") int Id) {
	EmissionDAO dao = new EmissionDAO();
	        return dao.getEmissionById(Id);
	    }
	
        
@DELETE
@Path("/deleteEmission/{id}")
@Produces("text/plain")
public String removeEmission(@PathParam("Id")int Id){
	EmissionDAO dao = new EmissionDAO();
	EmissionDAO emissionDAO = new EmissionDAO();
	Emission emission = dao.getEmissionById(Id);
	dao.removeEmission(emission);	
	return "Emission! "+emission.getCode()+" deleted";//do later
}

@PUT
@Path("/updateEmission/")
@Produces("application/json")
public Emission updateEmission(Emission emission){
	EmissionDAO dao = new EmissionDAO();
	return dao.merge(emission);	
}

	
////Category\\\\\
	
@GET//listing category but with jjson
@Path("/CategoryJSONfromDB")
@Produces("application/json")
public List<Category> ListCategoryJSON(){
   CategoryDAO dao = new CategoryDAO();
return dao.getAllCategorys();
}

@GET//listing category but with jjson
@Path("/CategoryJSONfromDB/{code}")
@Produces("application/json")
public Category getCategoryByIdJSON(@PathParam("code") String code) {
	CategoryDAO dao = new CategoryDAO();
	        return dao.getCategoryByCode(code);
	    }










}
	
