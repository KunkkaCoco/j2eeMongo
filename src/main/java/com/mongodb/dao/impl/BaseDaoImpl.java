package com.mongodb.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.dao.BaseDao;

@Service
public class BaseDaoImpl implements BaseDao {
	@Resource
	private MongoTemplate mongoTemplate;

	@Override
	public MongoTemplate mongoTemplate() {
		return mongoTemplate;
	}

	@Override
	public boolean exists(Query query, String collectionName) {
		return mongoTemplate().exists(query, collectionName);
	}

	@Override
	public long count(Query query, String collectionName) {
		return mongoTemplate().count(query, collectionName);
	}

	@Override
	public <T> List<T> find(Query query, Class<T> entityClass, String collectionName) {
		if (query == null) {
			return mongoTemplate().findAll(entityClass, collectionName);
		}
		return mongoTemplate().find(query, entityClass, collectionName);
	}

	@Override
	public void save(Object objectToSave, String collectionName) {
		mongoTemplate().save(objectToSave, collectionName);
	}

	@Override
	public void remove(Query query, String collectionName) {
		mongoTemplate().remove(query, collectionName);
	}

	@Override
	public void update(Query query, Update update, String collectionName) {
		mongoTemplate().updateMulti(query, update, collectionName);
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

}
