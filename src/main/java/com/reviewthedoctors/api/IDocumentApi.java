package com.reviewthedoctors.api;

import com.reviewthedoctors.model.dto.DocumentDto;
import com.reviewthedoctors.model.dto.DocumentDto;


/**
 * TODO write java doc
 * @author awesomegirl
 *
 */
public interface IDocumentApi {

	public DocumentDto create(DocumentDto documentDto);
	public DocumentDto update(DocumentDto documentDto);
	public boolean delete(long documentId);
	public DocumentDto getDoctor(long documentId);
	
}
