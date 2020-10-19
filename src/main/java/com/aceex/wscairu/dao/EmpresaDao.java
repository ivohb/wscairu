package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aceex.wscairu.model.Empresa;

@Repository                                      
public interface EmpresaDao extends JpaRepository<Empresa, String>  {

	@Transactional(readOnly=true)
	@Query("FROM Empresa obj WHERE obj.id = :id")
	public Empresa findByCnpj(@Param("id") String id);

	@Transactional(readOnly=true)
	public Empresa findByEmpresa(String empresa);

}
