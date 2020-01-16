package com.ag.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ag.entity.StudentEntity;
import com.ag.mode.StudentRegistration;
import com.ag.repository.RegistrationRepository;
import com.ag.util.EmailUtil;

/**
 * This class is used to perform business operation
 * 
 * @author AVNISH SINGH
 * @version 2.2
 */
@Service
public class RegistrationService {

	@Autowired
	RegistrationRepository registrationRepo;

	@Autowired
	EmailUtil emailUtil;

	/**
	 * This method is used to save student Detail
	 * 
	 * @param reg
	 * @return boolean
	 * @throws IOException
	 */
	public boolean saveStudentdetail(StudentRegistration reg) throws IOException {
		StudentEntity entity = new StudentEntity();
		BeanUtils.copyProperties(reg, entity);
		entity.setStatus("locked");
		entity.setPazzword(randomAlphaNumeric(6));
		StudentEntity isSave = registrationRepo.save(entity);
		String emailId = isSave.getEmail();
		if (emailId != null) {
			sendEmailMsg(emailId, entity);
		} 

		return isSave.getSid() > 0;

	}

	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	/**
	 * This method is used to generate alphanumeric String
	 * 
	 * @param count
	 * @return String
	 */
	public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		int num=count;
		while (num-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}

	/**
	 * This Method is used to send Email
	 * 
	 * @param emailId
	 * @throws IOException
	 */
	public void sendEmailMsg(String emailId, StudentEntity entity) throws IOException {
		emailUtil.sendEmail(emailId, entity);
	}

	/**
	 * This method is used to read text file
	 * 
	 * @param reg
	 * @param tempPwd
	 * @return String
	 * @throws IOException
	 */
	public String readMailfromText(StudentEntity entity) throws IOException {

		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new FileReader("EmailMsg.txt"));
		String line = br.readLine();
		while (line != null) {
			if (line.contains("${name}"))
				line = line.replace("${name}", entity.getName());

			else if (line.contains("${pwd}"))
				line = line.replace("${pwd}", entity.getPazzword());

			else if (line.contains("${email}"))
				line = line.replace("${email}", entity.getEmail());

			sb.append(line).append("\n");
			line = br.readLine();

		}
		String fileString = sb.toString();
		br.close();

		return fileString;
	}
	/**
	 * This method validate email 
	 * @param emailId
	 * @return
	 */
	public boolean checkEmail(String emailId) {
	
		StudentEntity entity = registrationRepo.findByEmail(emailId);
		if(entity==null) {
			return true;
		}
		else {
			return false;
		}
	}

	public void sendForgetPass(String email,String pwzzd) {
		
	}
}
