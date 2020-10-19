package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aceex.wscairu.model.Parametro;

@Repository                                     //entidade tipo do id
public interface ParametroDao extends JpaRepository<Parametro, String>  {

	@Transactional(readOnly=true)
	public Parametro findByUserReq(String userReq);	

	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Parametro obj"
			+ " where obj.userReq = :user and obj.senhaReq = :senha ")			
	public Parametro findByUserAndPassword(@Param("user") String user, @Param("senha") String senha);


}
