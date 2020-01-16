package com.ag.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ag.entity.StudentEntity;
import com.ag.mode.UnlockAccount;
import com.ag.repository.RegistrationRepository;
/**
 * This class contains unlock operation method
 * @author AVNISH SINGH
 */
@Service
public class UnlockAccountService {

	@Autowired
	RegistrationRepository registrationRepo;
	
	/**
	 * This method is used perform unlock account  operation
	 * @param newPwd
	 * @param emailId
	 * @param tempPwd
	 * @return boolean
	 */
	public boolean unlockAccount(UnlockAccount ua) {
		
		 StudentEntity entity = registrationRepo.findByAndPwzzd( ua.getEmail(), ua.getTempPwd());
		 if(entity != null) {
			 entity.setStatus("unlock");
			 entity.setPazzword(ua.getNewPwd());
			registrationRepo.save(entity);
			return true;
		 }
		 
		return false;

	}
}
