package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aceex.wscairu.model.PedItemEspelho;

@Repository                                      
public interface PedItemEspelhoDao extends JpaRepository<PedItemEspelho, Integer>  {

}
