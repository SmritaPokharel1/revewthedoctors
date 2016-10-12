package com.reviewthedoctors.repository;

import org.springframework.data.repository.CrudRepository;

import com.reviewthedoctors.model.entity.Document;

//todo write java doc
public interface DocumentRepository extends CrudRepository<Document, Long>{

}
