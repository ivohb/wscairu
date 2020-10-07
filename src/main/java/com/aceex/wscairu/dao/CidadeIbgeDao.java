package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aceex.wscairu.key.CidadeIbgeKey;
import com.aceex.wscairu.model.CidadeIbge;

@Repository                                        //entidade    tipo do id                
public interface CidadeIbgeDao extends JpaRepository<CidadeIbge, CidadeIbgeKey>  {

	@Transactional(readOnly=true)
	@Query("SELECT obj FROM CidadeIbge obj "
			+ "WHERE obj.id.estado = :estado"
			+ " AND obj.id.cidIbge = :cidIbge")
	public CidadeIbge findByKey(@Param("estado") String estado,
			@Param("cidIbge") String cidIbge);

}
