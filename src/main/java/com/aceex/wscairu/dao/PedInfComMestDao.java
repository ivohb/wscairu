package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aceex.wscairu.key.PedInfComMestKey;
import com.aceex.wscairu.model.PedInfComMest;

@Repository                                      
public interface PedInfComMestDao extends JpaRepository<PedInfComMest, PedInfComMestKey>  {

}
