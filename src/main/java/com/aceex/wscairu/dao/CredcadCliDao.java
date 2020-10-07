package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aceex.wscairu.model.CredcadCli;

@Repository                                      
public interface CredcadCliDao extends JpaRepository<CredcadCli, String>  {

}
