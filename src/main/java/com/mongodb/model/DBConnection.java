package com.mongodb.model;

import java.net.UnknownHostException;

import javax.annotation.PostConstruct;

import com.mongodb.DB;
import com.mongodb.Mongo;

public class DBConnection {

	private DB mongoDB;

	public DBConnection() {
		super();
	}

	@PostConstruct
	public void afterCreate() {
		String mongoHost = "127.0.0.1";
		String mongoPort = "27001";
		String mongoUser = "strongloop";
		String mongoPassword = "rocks";
		String mongoDBName = "restexample";
		int port = Integer.decode(mongoPort);

		Mongo mongo = null;
		try {
			mongo = new Mongo(mongoHost, port);
		} catch (UnknownHostException e) {
			System.out.println("Couldn't connect to MongoDB: " + e.getMessage() + " :: " + e.getClass());
		}

		mongoDB = mongo.getDB(mongoDBName);

		if (mongoDB.authenticate(mongoUser, mongoPassword.toCharArray()) == false) {
			System.out.println("Failed to authenticate DB ");
		}

	}

	public DB getDB() {
		return mongoDB;
	}

}