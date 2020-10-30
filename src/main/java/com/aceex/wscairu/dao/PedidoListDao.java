package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aceex.wscairu.model.PedidoList;

@Repository                                      
public interface PedidoListDao extends JpaRepository<PedidoList, String>  {

}
