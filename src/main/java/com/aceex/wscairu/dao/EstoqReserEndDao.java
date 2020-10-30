package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aceex.wscairu.key.EstoqReserEndKey;
import com.aceex.wscairu.model.EstoqReserEnd;

@Repository                                      
public interface EstoqReserEndDao extends JpaRepository<EstoqReserEnd, EstoqReserEndKey>  {

}
