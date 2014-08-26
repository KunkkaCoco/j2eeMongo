package com.mongodb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.dao.BaseDao;
import com.mongodb.service.BaseService;

@Service("baseService")
public class BaseServiceImpl implements BaseService {

	@Autowired
	private BaseDao baseDao;

	@Override
	public boolean exists(Query query, String collectionName) {
		return baseDao.exists(query, collectionName);
	}

	@Override
	public long count(Query query, String collectionName) {
		return baseDao.count(query, collectionName);
	}

	@Override
	public <T> List<T> find(Query query, Class<T> entityClass, String collectionName) {
		return baseDao.find(query, entityClass, collectionName);
	}

	@Override
	public void save(Object objectToSave, String collectionName) {
		baseDao.save(objectToSave, collectionName);
	}

	@Override
	public void remove(Query query, String collectionName) {
		baseDao.remove(query, collectionName);
	}

	@Override
	public void update(Query query, Update update, String collectionName) {
		baseDao.update(query, update, collectionName);
	}

}
