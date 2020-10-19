package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aceex.wscairu.key.PedidoVdpKey;
import com.aceex.wscairu.model.PedidoVdp;

@Repository                                      
public interface PedidoVdpDao extends JpaRepository<PedidoVdp, PedidoVdpKey>  {

}
