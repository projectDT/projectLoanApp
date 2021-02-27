package com.project.Customer;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
@RestController
public class DetailsController {
	
	@Autowired
	private DetailsService service;
	
	@GetMapping("/customer")
	public List<DetailsEntity> list() {
	    return service.listAll();
	}
	
	@GetMapping("/customer/{id}")
	   public ResponseEntity<DetailsBVO> get(@PathVariable Integer id) 
	   {
		    try {
		        DetailsEntity details = service.get(id);
		        
		        BasicInfoBVO basicInfo= new BasicInfoBVO();
		        basicInfo.setName(details.getBasicInfo().getName());
		        basicInfo.setAge(details.getBasicInfo().getAge());
		        basicInfo.setSalary(details.getBasicInfo().getSalary());
		        
		        CommDetailsBVO commDetails= new CommDetailsBVO();
		        commDetails.setEmail(details.getCommDetails().getEmail());
		        commDetails.setMobileNo(details.getCommDetails().getMobileNo());
		        commDetails.setAddress(details.getCommDetails().getAddress());
		        commDetails.setCity(details.getCommDetails().getCity());
		        commDetails.setState(details.getCommDetails().getState());
		        commDetails.setPincode(details.getCommDetails().getPincode());
		        
		        DetailsBVO detailsBVO = new DetailsBVO(details.getId(), basicInfo, details.getLoanTenure(), commDetails );
			      
		        return new ResponseEntity<DetailsBVO>(detailsBVO, HttpStatus.OK);
		    	}
			    catch (NoSuchElementException e) 
		        {
		        	return new ResponseEntity<DetailsBVO>(HttpStatus.NOT_FOUND);
		    	} 
	   }
	
	@PostMapping("/customer")
	public ResponseEntity<Object> addCustomer(@RequestBody DetailsEntity detailsEntity)
	{	
		 
		 DetailsEntity savedCustomer = service.save(detailsEntity);
		 
		 if (savedCustomer == null)
				return ResponseEntity.noContent().build();
		 
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedCustomer.getId()).toUri();
		 
		 return ResponseEntity.created(location).build();
		 
	}
	
	
	
	/*
	 * 
	 *  @PostMapping("/customer")
		public ResponseEntity<DetailsEntity> addCustomer(@RequestBody DetailsEntity detailsEntity) 
		{
			DetailsEntity newDetails = service.save(detailsEntity);
	
			return new ResponseEntity< >(newUser, HttpStatus.CREATED);
		}
		
		
		
		
		@PostMapping("/customer")
		public void addCustomer(@RequestBody DetailsEntity detailsEntity)
		{
			 @SuppressWarnings("unused")
			DetailsEntity savedCustomer = service.save(detailsEntity);
		}
		
		

		
		@PostMapping("/customer")
		public ResponseEntity<Object> addCustomer(@RequestBody DetailsEntity detailsEntity)
		{	
			 @SuppressWarnings("unused")
			 DetailsEntity savedCustomer = service.save(detailsEntity);
			 
			 URI location = ServletUriComponentsBuilder
			 	.fromCurrentRequest()
			 	.path("/{id}")
			 	.buildAndExpand(savedUser.getId()).toUri();
			 
			 return ResponseEntity.created(location).build();
			 
		}
		
		
		
		
		
		@PostMapping("/customer")
		public DetailsEntity addCustomer(@Valid @RequestBody DetailsEntity detailsEntity)
		{
			return repo.save(detailsEntity);
		}
	 * 
	 * */
	        
}
