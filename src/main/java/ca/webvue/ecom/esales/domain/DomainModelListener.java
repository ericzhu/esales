package ca.webvue.ecom.esales.domain;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class DomainModelListener {
	
	@PrePersist
	public void prePersist(BaseModel model) {
		model.setCreateDate(new Date());
		model.setModifyDate(new Date());
	}
	
	@PreUpdate
	public void preUpdate(BaseModel model) {
		model.setModifyDate(new Date());
	}
}
