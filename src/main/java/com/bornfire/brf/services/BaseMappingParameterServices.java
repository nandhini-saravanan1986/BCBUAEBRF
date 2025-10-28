package com.bornfire.brf.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bornfire.brf.entities.BaseMappingParameter;
import com.bornfire.brf.entities.BaseMappingParameterRepository;

import java.util.Date; // Import Date

@Service
public class BaseMappingParameterServices {

	@Autowired
	BaseMappingParameterRepository basemappingparameterrepository;

	public String createOrUpdate(BaseMappingParameter dto, String formmode) { // Removed account_id_bacid as a separate param
		try {
			System.out.println("Service: createOrUpdate() called with formmode: " + formmode);

			if (dto.getAccount_id_bacid() == null || dto.getAccount_id_bacid().isEmpty()) {
				return "ERROR: Account ID/Bacid is required.";
			}

			// For 'add' mode, ensure the ID doesn't already exist
			if ("add".equals(formmode)) {
				if (basemappingparameterrepository.existsById(dto.getAccount_id_bacid())) {
					return "ERROR: Record with Account ID/Bacid " + dto.getAccount_id_bacid() + " already exists.";
				}
				dto.setEntry_time(new Date()); // Set entry time for new records
				dto.setAuth_flg("N"); // Assuming 'N' for not authorized initially
				dto.setDel_flg("N"); // Assuming 'N' for not deleted
				dto.setEntity_flg("Y"); // Assuming 'Y' for active entity
				dto.setModify_flg("N"); // New record, so not modified yet
			} else if ("edit".equals(formmode)) {
				// For 'edit' mode, ensure the record exists
				Optional<BaseMappingParameter> existingOptional = basemappingparameterrepository.findById(dto.getAccount_id_bacid());
				if (!existingOptional.isPresent()) {
					return "ERROR: Record with Account ID/Bacid " + dto.getAccount_id_bacid() + " not found for update.";
				}
				BaseMappingParameter existing = existingOptional.get();
				// Copy relevant fields from dto to existing, preserving creation metadata
				existing.setGl_head(dto.getGl_head());
				existing.setGl_subhead_code(dto.getGl_subhead_code());
				existing.setAccount_description(dto.getAccount_description());
				existing.setCurrency(dto.getCurrency());
				existing.setData_type(dto.getData_type());
				existing.setModify_time(new Date()); // Update modify time
				existing.setModify_flg("Y"); // Mark as modified
				dto = existing; // Use the updated existing object for saving
			}

			basemappingparameterrepository.save(dto);
			return "Record saved successfully.";
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR: " + e.getMessage();
		}
	}


	public String deleteBaseMappingParameter(String accountIdBacid) {
		String msg = "";
		try {
			Optional<BaseMappingParameter> record = basemappingparameterrepository.findById(accountIdBacid);
			if (record.isPresent()) {
				basemappingparameterrepository.deleteById(accountIdBacid);
				msg = "Record with Account ID/Bacid " + accountIdBacid + " deleted successfully.";
			} else {
				msg = "ERROR: Record with Account ID/Bacid " + accountIdBacid + " not found.";
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = "ERROR: Could not delete record. Please contact Administrator. " + e.getMessage();
		}
		return msg;
	}

	public boolean updatebasemappingparameter(BaseMappingParameter updatedData) {
		System.out.println("Looking for record with account_id_bacid: " + updatedData.getAccount_id_bacid());

		Optional<BaseMappingParameter> existingOptional = basemappingparameterrepository.findById(updatedData.getAccount_id_bacid());

		if (existingOptional.isPresent()) {
			BaseMappingParameter existing = existingOptional.get();
			// Update fields
			existing.setGl_head(updatedData.getGl_head());
			existing.setGl_subhead_code(updatedData.getGl_subhead_code());
			// account_id_bacid is the ID, typically not changed during an update.
			existing.setAccount_description(updatedData.getAccount_description());
			existing.setCurrency(updatedData.getCurrency());
			existing.setData_type(updatedData.getData_type());
			existing.setModify_time(new Date()); // Set modify time
			existing.setModify_flg("Y"); // Set modify flag

			basemappingparameterrepository.save(existing);
			return true;
		} else {
			System.out.println("No record found for account_id_bacid: " + updatedData.getAccount_id_bacid());
			return false;
		}
	}
}