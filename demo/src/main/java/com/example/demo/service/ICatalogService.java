package com.example.demo.service;

import java.util.List;

import com.example.demo.model.CatalogItem;

public interface ICatalogService {
	 public   String insert(CatalogItem item);
     public   List<CatalogItem>  getAll(int pageNo, int pageSize, boolean asc, String... props);
     public   CatalogItem  getById(String id);
}
