package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aceex.wscairu.dto.EmbalDto;
import com.aceex.wscairu.model.ItemEmbal;

@Repository                                      
public interface ItemEmbalDao extends JpaRepository<ItemEmbal, Integer>  {

	@Transactional(readOnly=true)
	@Query("SELECT new com.aceex.wscairu.dto.EmbalDto("
			+ "i.embalagem, i.qtdPadrao, e.codMatriz, e.pesUnit) "
			+ " FROM ItemEmbal i, Embalagem e "
			+ " WHERE i.embalagem = e.id AND i.empresa = :empresa "
			+ " AND i.item = :item AND (i.tipo = 'I' OR i.tipo = 'N') ")
	public EmbalDto findEmbal(
			@Param("empresa") String empresa,	@Param("item") String item);
	
}
