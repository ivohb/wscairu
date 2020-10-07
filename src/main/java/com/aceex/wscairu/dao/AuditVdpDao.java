package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aceex.wscairu.model.AuditVdp;

@Repository                                      
public interface AuditVdpDao extends JpaRepository<AuditVdp, Integer>  {

}
