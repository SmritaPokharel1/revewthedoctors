package com.reviewthedoctors.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reviewthedoctors.api.IDocumentApi;
import com.reviewthedoctors.model.dto.DocumentDto;
import com.reviewthedoctors.repository.DocumentRepository;

/**
 * TODO write java doc
 * @author awesomegirl
 *
 */
@Service
public class DocumentApi implements IDocumentApi {
	
	@Autowired
	private DocumentRepository documentRepository;
	
	//TODO WRITE JAVA DOCS
	public DocumentDto create(DocumentDto documentDto) {
		return null;
	}

	public DocumentDto update(DocumentDto documentDto) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(long documentId) {
		// TODO Auto-generated method stub
		return false;
	}

	public DocumentDto getDocument(long documentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
