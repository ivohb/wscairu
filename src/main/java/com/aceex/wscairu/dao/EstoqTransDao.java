package com.aceex.wscairu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aceex.wscairu.model.EstoqTrans;

@Repository                                      
public interface EstoqTransDao extends JpaRepository<EstoqTrans, Integer>  {

	@Transactional(readOnly=true)
	@Query("SELECT new EstoqTrans(MAX(obj.id)) FROM EstoqTrans obj "
			+ "WHERE obj.empresa = :empresa")
	public EstoqTrans findMaxTransac(@Param("empresa") String empresa);

	@Transactional(readOnly=true)
	@Query("SELECT obj FROM  EstoqTrans obj "
			+ "WHERE obj.empresa = :empresa  "
			+ " AND obj.id in (select max(e.id) from EstoqTrans e where e.empresa = :empresa)  ")
	public EstoqTrans findByEmpresa(@Param("empresa") String empresa);

	@Transactional(readOnly=true)
	@Query("SELECT new EstoqTrans(MAX(obj.id), obj.item) FROM EstoqTrans obj "
			+ "WHERE obj.empresa = :empresa"
			+ " AND obj.id > :id group by  obj.item")			
	public List<EstoqTrans> findMovimentos(
			@Param("empresa") String empresa, @Param("id") Integer id);

}
