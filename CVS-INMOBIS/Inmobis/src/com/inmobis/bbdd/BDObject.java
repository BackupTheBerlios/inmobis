package com.inmobis.bbdd;
import com.inmobis.bbdd.RowExistsException;
import com.inmobis.bbdd.RowNotFoundException;
public interface BDObject {
	void select () throws RowNotFoundException;
	void insert ()throws RowExistsException;
	void delete ()throws RowNotFoundException;
	void update ()throws RowNotFoundException;
   Object getBean();

}