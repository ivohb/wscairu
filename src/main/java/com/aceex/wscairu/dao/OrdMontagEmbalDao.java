package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aceex.wscairu.key.OrdMontagEmbalKey;
import com.aceex.wscairu.model.OrdMontagEmbal;

@Repository                                      
public interface OrdMontagEmbalDao extends JpaRepository<OrdMontagEmbal, OrdMontagEmbalKey>  {

}
