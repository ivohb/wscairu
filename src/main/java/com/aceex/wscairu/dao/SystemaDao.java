package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aceex.wscairu.model.Systema;

@Repository                                     //entidade tipo do id
public interface SystemaDao extends JpaRepository<Systema, String>  {

	@Transactional(readOnly=true)
	public Systema findByUserReq(String userReq);	

	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Systema obj"
			+ " where obj.userReq = :user and obj.senhaReq = :senha ")			
	public Systema findByUserAndPassword(@Param("user") String user, @Param("senha") String senha);

	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Systema obj"
			+ " where obj.id = :id ")			
	public Systema findByKey(@Param("id") String id);

}
