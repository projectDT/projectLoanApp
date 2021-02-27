package com.project.Customer;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DetailsService {
	
	@Autowired
	private DetailsRepository repo;

	 public List<DetailsEntity> listAll() {
	        return repo.findAll();
	    }
	     
	    public DetailsEntity save(DetailsEntity detailsEntity) {
	        repo.save(detailsEntity);
	        return detailsEntity;
	    }
	     
	    public DetailsEntity get(Integer id) {
	        return repo.findById(id).get();
	    }
	     
	    public void delete(Integer id) {
	        repo.deleteById(id);
	    }
}
