package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aceex.wscairu.key.OrdMontagMestKey;
import com.aceex.wscairu.model.OrdMontagMest;

@Repository                                      
public interface OrdMontagMestDao extends JpaRepository<OrdMontagMest, OrdMontagMestKey>  {

}
