package com.ems.exception;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
	
	private String resourceName;
	private String fieldName;
	private Integer fieldIntegerValue;
	private String fieldStringValuse;
	
	public ResourceNotFoundException(String resourceName, String fieldName, Integer fieldIntegerValue){
		super( String.format("%s with %s = %d Not found", resourceName, fieldName, fieldIntegerValue) );
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldIntegerValue = fieldIntegerValue;
	}
	
	public ResourceNotFoundException(String resourceName, String fieldName, String fieldStringValuse){
		super( String.format("%s with %s = %s Not found", resourceName, fieldName, fieldStringValuse) );
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldStringValuse = fieldStringValuse;
	}

}
