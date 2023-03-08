package com.jbk.exceptions;

import net.bytebuddy.implementation.bind.annotation.Super;

public class ResourceNotExistsException extends RuntimeException {

	public ResourceNotExistsException(String msg) {
		super(msg);
	}

}
