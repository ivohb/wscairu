package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aceex.wscairu.key.ItemEnviadoKey;
import com.aceex.wscairu.model.ItemEnviado;

@Repository                                      
public interface ItemEnviadoDao extends JpaRepository<ItemEnviado, ItemEnviadoKey>  {

}
