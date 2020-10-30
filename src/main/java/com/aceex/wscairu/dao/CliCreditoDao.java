package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aceex.wscairu.model.CliCredito;

@Repository                                      
public interface CliCreditoDao extends JpaRepository<CliCredito, String>  {

	@Modifying
	@Transactional(readOnly=false)
	@Query("UPDATE CliCredito SET valCarteira = valCarteira + :valPedido WHERE id = :id ")
	public void updateCliCredito(
			@Param("id") String id, @Param("valPedido") Double valPedido);

}
