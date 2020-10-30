package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aceex.wscairu.key.OrdMontagItemKey;
import com.aceex.wscairu.model.OrdMontagItem;

@Repository                                      
public interface OrdMontagItemDao extends JpaRepository<OrdMontagItem, OrdMontagItemKey>  {

}
