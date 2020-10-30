package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aceex.wscairu.model.Embalagem;

@Repository                                      
public interface EmbalagemDao extends JpaRepository<Embalagem, String>  {

}
