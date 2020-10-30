package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aceex.wscairu.key.PedComplPedKey;
import com.aceex.wscairu.model.PedComplPed;

@Repository                                      
public interface PedComplPedDao extends JpaRepository<PedComplPed, PedComplPedKey>  {

}
