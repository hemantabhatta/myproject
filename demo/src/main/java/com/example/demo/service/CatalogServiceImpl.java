package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.model.CatalogItem;
import com.example.demo.repo.ICatalogRepo;

@Service
public class CatalogServiceImpl implements ICatalogService {

	@Autowired
	private ICatalogRepo repo;
	
	@Autowired
    private MongoTemplate mongoTemplate;
	
	@Override
	public String insert(CatalogItem item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CatalogItem> getAll(int pageNo, int pageSize, boolean asc, String... props) {
		 //create Pageable object having inputs
		Pageable pageable=PageRequest.of(pageNo,pageSize,asc?Direction.ASC:Direction.DESC,props);
		Page<CatalogItem> page=repo.findAll(pageable);
//		System.out.println("list data "+page.getContent());
		return page.getContent();
	}

	@Override
	public CatalogItem getById(String id) {
		ObjectId oid = new ObjectId(id);
		CatalogItem item = mongoTemplate.findById(oid, CatalogItem.class);
//		Optional<CatalogItem> item=repo.findById(oid);
//		
//		System.err.println("item "+item.get());

		return item;
	}

}
