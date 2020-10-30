package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aceex.wscairu.model.ItemEmbal;

@Repository                                      
public interface ItemEmbalDao extends JpaRepository<ItemEmbal, Integer>  {

}
