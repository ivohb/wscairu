package com.aceex.wscairu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aceex.wscairu.key.PedItemKey;
import com.aceex.wscairu.model.PedidoItem;

@Repository                                      
public interface PedidoItemDao extends JpaRepository<PedidoItem, PedItemKey>  {

	@Transactional(readOnly=true)
	@Query("SELECT obj FROM PedidoItem obj "
			+ "WHERE obj.id.empresa = :empresa"
			+ " AND obj.id.numero = :numero")
	public List<PedidoItem> findByEmpresaAndPedido(@Param("empresa") String empresa,
			@Param("numero") Integer numero);

	@Modifying
	@Transactional(readOnly=false)
	@Query("UPDATE PedidoItem SET qtdRomaneio = qtdRomaneio + :quantidade "
			+ " WHERE id.empresa = :empresa "
			+ " AND id.numero = :numero AND id.sequencia = :sequencia ")
	public void update(@Param("empresa") String empresa, @Param("numero") Integer numero,
			@Param("sequencia") Integer sequencia, @Param("quantidade") Double quantidade);

}
