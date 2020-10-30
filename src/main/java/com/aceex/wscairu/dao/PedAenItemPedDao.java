package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aceex.wscairu.key.PedAenItemPedKey;
import com.aceex.wscairu.model.PedAenItemPed;

@Repository                                      
public interface PedAenItemPedDao extends JpaRepository<PedAenItemPed, PedAenItemPedKey>  {

}
