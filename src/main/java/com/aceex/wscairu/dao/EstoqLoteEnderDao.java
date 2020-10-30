package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aceex.wscairu.model.EstoqLoteEnder;

@Repository                                      
public interface EstoqLoteEnderDao extends JpaRepository<EstoqLoteEnder, Integer>  {

}