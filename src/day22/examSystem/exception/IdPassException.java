package day22.examSystem.exception;

import java.io.Serializable;

public class IdPassException extends Exception implements Serializable {
	public IdPassException(String message) {
		super(message);
	}
}
