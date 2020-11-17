package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aceex.wscairu.model.PedidoOm;

@Repository
public interface PedidoOmDao extends JpaRepository<PedidoOm, Integer>  {
	
}
