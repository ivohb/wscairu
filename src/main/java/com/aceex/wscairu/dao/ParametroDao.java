package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aceex.wscairu.model.Parametro;

@Repository                                      
public interface ParametroDao extends JpaRepository<Parametro, String>  {

	@Transactional(readOnly=true)
	@Query("FROM Parametro obj WHERE obj.id = :cnpj")
	public Parametro findByEmpresa(@Param("cnpj") String cnpj);

}
