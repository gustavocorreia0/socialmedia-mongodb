package com.project.socialmediamongodb.services.exception;

public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String alerta) {
		super(alerta);
	}
	
}
