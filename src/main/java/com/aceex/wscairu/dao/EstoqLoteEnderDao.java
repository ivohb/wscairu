package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aceex.wscairu.model.EstoqLoteEnder;

@Repository                                      
public interface EstoqLoteEnderDao extends JpaRepository<EstoqLoteEnder, Integer>  {

	@Transactional(readOnly=true)
	@Query("SELECT obj FROM EstoqLoteEnder obj "
			+ "WHERE obj.empresa = :empresa"
			+ " AND obj.item = :codigo"
			+ " AND obj.local = :local"
			+ " AND obj.lote IS NULL AND obj.situacao = 'L'")
	public EstoqLoteEnder findEstoque(@Param("empresa") String empresa,
			@Param("codigo") String codigo, @Param("local") String local);

}
