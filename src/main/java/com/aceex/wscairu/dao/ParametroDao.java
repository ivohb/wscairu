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
	@Query("SELECT p FROM Parametro p"
			+ " where p.userReq = :user and p.senhaReq = :senha ")			
	public Parametro findByUserRequest(@Param("user") String user, @Param("senha") String senha);

}
