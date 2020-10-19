package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aceex.wscairu.key.LinhaProdKey;
import com.aceex.wscairu.model.LinhaProd;

@Repository                                      
public interface LinhaProdDao extends JpaRepository<LinhaProd, LinhaProdKey>  {

	@Transactional(readOnly=true)
	@Query("SELECT obj FROM LinhaProd obj "
			+ "WHERE obj.id.categoria = :categoria"
			+ "  AND obj.id.agrupamento = :agrupamento"
			+ "  AND obj.id.tamanho = :tamanho"
			+ "  AND obj.id.cor = :cor")
	public LinhaProd findByKey(@Param("categoria") Integer categoria,	@Param("agrupamento") Integer agrupamento,
			@Param("tamanho") Integer tamanho,	@Param("cor") Integer cor);



}
