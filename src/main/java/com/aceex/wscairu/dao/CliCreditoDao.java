package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aceex.wscairu.model.CliCredito;

@Repository                                      
public interface CliCreditoDao extends JpaRepository<CliCredito, String>  {

}
