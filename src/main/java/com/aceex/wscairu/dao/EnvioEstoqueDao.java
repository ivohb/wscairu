package com.aceex.wscairu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aceex.wscairu.model.EnvioEstoque;

@Repository
public interface EnvioEstoqueDao extends JpaRepository<EnvioEstoque, Integer>  {
	
	@Transactional(readOnly=true)
	@Query("SELECT new EnvioEstoque(obj.sistema) "
			+ "FROM EnvioEstoque obj GROUP BY obj.sistema ")
	public List<EnvioEstoque> findSistema();

	@Transactional(readOnly=true)
	@Query("SELECT obj FROM EnvioEstoque obj "
			+ "WHERE obj.sistema = :sistema")
	public List<EnvioEstoque> findBySistema(@Param("sistema") String sistema);

	@Modifying
	@Transactional(readOnly=false)
	public void deleteByEmpresa(String empresa);

}
