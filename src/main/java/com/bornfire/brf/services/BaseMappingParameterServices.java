package com.bornfire.brf.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.bornfire.brf.entities.BaseMappingParameter;
import com.bornfire.brf.entities.BaseMappingParameterRepository;
import com.bornfire.brf.entities.UserProfile;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BaseMappingParameterServices {
	
	
	@Autowired
	BaseMappingParameterRepository basemappingparameterrepository;

	
	public String createOrUpdate(BaseMappingParameter dto, String formmode, String account_id_bacid) {
	    try {
	        System.out.println("Service: createOrUpdate() called");

	        if (account_id_bacid == null) {
	            return "ERROR: account_id_bacid is required.";
	        }

	        dto.setAccount_id_bacid(account_id_bacid);

	        basemappingparameterrepository.save(dto);
	        return "Saved successfully.";
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "ERROR: " + e.getMessage();
	    }
	}
	
	public String deleteuser(String userid) {
		String msg = "";
		
		try {
			Optional<BaseMappingParameter> user = basemappingparameterrepository.findById(userid);
			if(user.isPresent()) {
				basemappingparameterrepository.deleteById(userid);
				msg = "User Id Rejected";
				
			}else {
				msg = "Invalid Data";
			}
			
		}catch (Exception e) {
			msg = "Please contact Administrator";
			// TODO: handle exception
		}
		return msg;
	}
	
	public boolean updatebasemappingparameter(BaseMappingParameter updatedData) {
	    System.out.println("Looking for record with account_id_bacid: " + updatedData.getAccount_id_bacid());

	    BaseMappingParameter existing = basemappingparameterrepository.getParticularDataByAccount_id_bacid(updatedData.getAccount_id_bacid());

	    if (existing != null) {
	        // Update fields
	    	existing.setGl_head(updatedData.getGl_head());
	    	existing.setGl_subhead_code(updatedData.getGl_subhead_code());
	    	existing.setAccount_id_bacid(updatedData.getAccount_id_bacid());
	    	existing.setAccount_description(updatedData.getAccount_description());
	    	existing.setCurrency(updatedData.getCurrency());
	    	existing.setData_type(updatedData.getData_type());
	       

	        basemappingparameterrepository.save(existing);
	        return true;
	    } else {
	        System.out.println("No record found for account_id_bacid: " + updatedData.getAccount_id_bacid());
	        return false;
	    }
	}

	


}
