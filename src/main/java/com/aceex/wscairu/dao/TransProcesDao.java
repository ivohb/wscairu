package com.aceex.wscairu.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aceex.wscairu.model.TransProces;

@Repository                                      
public interface TransProcesDao extends JpaRepository<TransProces, Integer>  {

	@Transactional(readOnly=true)
	@Query("SELECT obj FROM TransProces obj "
			+ "WHERE obj.empresa = :empresa")
	public TransProces findByEmpresa(@Param("empresa") String empresa);

	@Modifying
	@Transactional(readOnly=false)
	@Query("UPDATE TransProces SET id = :id WHERE empresa = :empresa ")
	public void update(@Param("id") Integer id, @Param("empresa") String empresa);

	@Modifying
	@Transactional(readOnly=false)
	@Query("UPDATE TransProces SET datAtualiz = :data, horAtualiz = :hora"
			+ " WHERE empresa = :empresa ")
	public void update(@Param("empresa") String empresa, 
			@Param("data") Date data, @Param("hora") String hora);

}
