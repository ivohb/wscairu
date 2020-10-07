package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aceex.wscairu.key.AuditLogixKey;
import com.aceex.wscairu.model.AuditLogix;

@Repository                                         //entidade   tipo do id
public interface AuditLogixDao extends JpaRepository<AuditLogix, AuditLogixKey>  {

}
