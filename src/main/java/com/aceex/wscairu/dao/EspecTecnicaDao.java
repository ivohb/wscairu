package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aceex.wscairu.key.EspecTecnicaKey;
import com.aceex.wscairu.model.EspecTecnica;

@Repository                                      
public interface EspecTecnicaDao extends JpaRepository<EspecTecnica, EspecTecnicaKey>  {

	@Transactional(readOnly=true)
	@Query("SELECT obj FROM EspecTecnica obj "
			+ "WHERE obj.id.empresa = :empresa"
			+ " AND obj.id.item = :item and obj.id.sequencia = 99 ")
	public EspecTecnica findByKey(@Param("empresa") String empresa,
			@Param("item") String item);

	
}
