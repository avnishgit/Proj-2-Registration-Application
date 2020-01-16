package com.ag.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ag.entity.StudentEntity;
/**
 * This interface perform persistence operation
 * @author AVNISH SINGH
 * @version 2.2
 */
@Repository
public interface RegistrationRepository extends JpaRepository<StudentEntity, Integer> {

	
	@Query("from StudentEntity  WHERE pazzword = :tempPwd and email = :emailId")
	public StudentEntity findByAndPwzzd(  String emailId, String tempPwd);


	  @Query("select count(*) from StudentEntity where email=:emailId and pazzword=:pwd"
	  ) public Integer loginByEmail(String emailId, String pwd);
	 
	
	 
	  @Query("select pazzword from StudentEntity where email = :emailId")
	  public  String findPassByEmail(String emailId);
	 
	
public StudentEntity findByEmail(String email);

}
