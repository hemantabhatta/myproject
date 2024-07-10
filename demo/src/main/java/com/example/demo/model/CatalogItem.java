package com.example.demo.model;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.google.gson.JsonObject;

import lombok.Data;


@Document(collection = "jtv_cdn_catalogitem")
@Data

public class CatalogItem implements  Serializable   {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -4553086903147037430L;
	
	@Id
	private  ObjectId _id;
	
	
	private  String cust;
	private  String item_id;
	private  String type;
	private  String title;
	
	
	public CatalogItem() {
		super();
		System.out.println("Sport:: 0-param constructor");
		
	}


	@Override
	public String toString() {
		JsonObject json = new JsonObject();
		
		json.addProperty("id", _id.toString());
		json.addProperty("cust", cust);
		json.addProperty("item_id", item_id);
		json.addProperty("type", type);
		json.addProperty("title", title);
		return json.toString();
	}
	
}
