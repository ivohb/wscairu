package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aceex.wscairu.key.PedItemKey;
import com.aceex.wscairu.model.PedidoItem;

@Repository                                      
public interface PedidoItemDao extends JpaRepository<PedidoItem, PedItemKey>  {

}
