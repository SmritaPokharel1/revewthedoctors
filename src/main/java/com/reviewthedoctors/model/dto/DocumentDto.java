package com.reviewthedoctors.model.dto;

import java.util.Date;


public class DocumentDto extends BaseDto{

	private long documentId;
	
	private String documentType;

	private String documentLocation;

	
	public long getDocumentId() {
		return documentId;
	}

	public void setDocumentId(long documentId) {
		this.documentId = documentId;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDocumentLocation() {
		return documentLocation;
	}

	public void setDocumentLocation(String documentLocation) {
		this.documentLocation = documentLocation;
	}

}
