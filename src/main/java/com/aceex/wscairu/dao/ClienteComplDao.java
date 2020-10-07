package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aceex.wscairu.model.ClienteCompl;

@Repository                                           //entidade     tipo do id
public interface ClienteComplDao extends JpaRepository<ClienteCompl, String>  {

}
