package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aceex.wscairu.key.OmListKey;
import com.aceex.wscairu.model.OmList;

@Repository                                      
public interface OmListDao extends JpaRepository<OmList, OmListKey>  {

}
