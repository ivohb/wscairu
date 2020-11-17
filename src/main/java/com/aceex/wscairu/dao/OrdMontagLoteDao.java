package com.aceex.wscairu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aceex.wscairu.key.OrdMontagLoteKey;
import com.aceex.wscairu.model.OrdMontagLote;

@Repository                                      
public interface OrdMontagLoteDao extends JpaRepository<OrdMontagLote, OrdMontagLoteKey>  {

	@Transactional(readOnly=true)
	@Query("SELECT obj FROM  OrdMontagLote obj "
			+ "WHERE obj.id.empresa = :empresa ORDER BY obj.id.lote DESC ")
	public List<OrdMontagLote> findByEmpresa(@Param("empresa") String empresa);

	@Transactional(readOnly=true)
	@Query("SELECT obj FROM  OrdMontagLote obj "
			+ "WHERE obj.id.empresa = :empresa  "
			+ " AND obj.id.lote in (select max(l.id.lote) from OrdMontagLote l where l.id.empresa = :empresa)  ")
	public OrdMontagLote findMaxLote(@Param("empresa") String empresa);

}
