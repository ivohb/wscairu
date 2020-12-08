package com.aceex.wscairu.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aceex.wscairu.model.AuditItem;

@Repository                                         
public interface AuditItemDao extends JpaRepository<AuditItem, String>  {
	
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT new AuditItem ( a.item) "
			+ " FROM AuditItem a, Item i "
			+ " WHERE a.empresa = :empresa AND a.atualizacao >= :data "
			+ " AND a.empresa = i.id.empresa AND a.item = i.id.codigo "
			+ " AND i.categoria IN (SELECT c.id.linhaProd FROM Aen c WHERE c.id.cnpj = :cnpj) ")
	public List<AuditItem> findItens(@Param("empresa") String empresa, 
			@Param("cnpj") String cnpj, @Param("data") Date data );

	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT new AuditItem (a.item, max(a.revisao)) "
			+ " FROM AuditItem a, Item i, Aen c "
			+ " WHERE a.empresa = :empresa AND a.atualizacao >= :data "
			+ " AND a.empresa = i.id.empresa AND a.item = i.id.codigo "
			+ " AND c.id.linhaProd = i.categoria " 
			+ " AND c.id.cnpj = :cnpj AND c.id.sistema = :sys "
			+ " AND a.item NOT IN (SELECT e.id.codigo from ItemEnviado e "
			+ " WHERE e.id.empresa = a.empresa AND e.revisao >= a.revisao)"
			+ " GROUP BY a.item")
	public List<AuditItem> findItens(@Param("empresa") String empresa, 
			@Param("cnpj") String cnpj, @Param("data") Date data, @Param("sys") String sys );

}
