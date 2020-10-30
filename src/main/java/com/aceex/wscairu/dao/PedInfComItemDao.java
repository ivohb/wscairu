package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aceex.wscairu.key.PedInfComItemKey;
import com.aceex.wscairu.model.PedInfComItem;

@Repository                                      
public interface PedInfComItemDao extends JpaRepository<PedInfComItem, PedInfComItemKey>  {

}
