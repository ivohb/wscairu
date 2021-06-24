package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aceex.wscairu.key.FichaTecnicalKey;
import com.aceex.wscairu.model.FichaTecnica;

@Repository  
public interface FichaTecnicaDao extends JpaRepository<FichaTecnica, FichaTecnicalKey> {

	@Transactional(readOnly=true)
	@Query("SELECT obj FROM FichaTecnica obj "
			+ "WHERE obj.id.empresa = :empresa"
			+ " AND obj.id.codigo = :codigo")
	public FichaTecnica findByKey(@Param("empresa") String empresa,
			@Param("codigo") String codigo);

}
