package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aceex.wscairu.model.ListaItem;

@Repository
public interface ListaItemDao extends JpaRepository<ListaItem, Integer>  {
	
	@Transactional(readOnly=true)
	public ListaItem findByEmpresaAndNumeroAndItem(String empresa, Integer numero, String item);

	

}
