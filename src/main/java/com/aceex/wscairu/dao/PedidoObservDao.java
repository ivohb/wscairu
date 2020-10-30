package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aceex.wscairu.key.PedObservKey;
import com.aceex.wscairu.model.PedidoObserv;

@Repository                                      
public interface PedidoObservDao extends JpaRepository<PedidoObserv, PedObservKey>  {

}
