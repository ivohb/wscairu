package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aceex.wscairu.key.ListaMestreKey;
import com.aceex.wscairu.model.ListaMestre;

@Repository                                      
public interface ListaMestreDao extends JpaRepository<ListaMestre, ListaMestreKey>  {

	@Transactional(readOnly=true)
	@Query("SELECT obj FROM ListaMestre obj "
			+ "WHERE obj.id.empresa = :empresa"
			+ " AND obj.id.numero = :numero")
	public ListaMestre findByKey(@Param("empresa") String empresa,
			@Param("numero") Integer numero);


}
