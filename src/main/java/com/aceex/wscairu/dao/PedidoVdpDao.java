package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aceex.wscairu.key.PedidoVdpKey;
import com.aceex.wscairu.model.PedidoVdp;

@Repository                                      
public interface PedidoVdpDao extends JpaRepository<PedidoVdp, PedidoVdpKey>  {

	@Transactional(readOnly=true)
	@Query("SELECT obj FROM PedidoVdp obj "
			+ "WHERE obj.id.empresa = :empresa"
			+ " AND obj.id.numero = :numero")
	public PedidoVdp findByKey(@Param("empresa") String empresa,
			@Param("numero") Integer numero);

}
