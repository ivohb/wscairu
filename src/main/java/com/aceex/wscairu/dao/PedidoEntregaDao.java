package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aceex.wscairu.key.PedidoEntregaKey;
import com.aceex.wscairu.model.PedidoEntrega;

@Repository                                      
public interface PedidoEntregaDao extends JpaRepository<PedidoEntrega, PedidoEntregaKey>  {

}
