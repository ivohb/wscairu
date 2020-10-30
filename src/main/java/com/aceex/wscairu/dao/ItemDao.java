package com.aceex.wscairu.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aceex.wscairu.dto.ItemDto;
import com.aceex.wscairu.key.ItemKey;
import com.aceex.wscairu.model.Item;

@Repository                                      
public interface ItemDao extends JpaRepository<Item, ItemKey>  {

	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Item obj "
			+ "WHERE obj.situacao = 'A' AND obj.id.empresa = :empresa"
			+ " AND obj.id.codigo = :codigo")
	public Item findByKey(@Param("empresa") String empresa,
			@Param("codigo") String codigo);

	@Transactional(readOnly=true)
	@Query("SELECT new com.aceex.wscairu.dto.ItemDto(e.ean, p.id.empresa, "
			+ "p.id.codigo, p.descricao, p.descReduz, p.unidade) "
			+ " FROM Item p, Ean e, Aen a "
			+ "WHERE p.situacao = 'A' "
			+ " AND p.id.empresa = e.id.empresa "
			+ " AND p.id.codigo = e.id.codigo"
			+ " AND p.id.empresa = :empresa"
			+ " AND p.id.codigo = :codigo"
			+ " AND a.id.linhaProd = p.categoria  "
			+ " AND a.id.cnpj = :cnpj "
			+ " AND a.id.sistema = :sistema")
	public ItemDto findByProduct(
			@Param("cnpj") String cnpj,	@Param("empresa") String empresa, 
			@Param("codigo") String codigo, @Param("sistema") String sistema);

	@Query("SELECT new com.aceex.wscairu.dto.ItemDto(e.ean, p.id.empresa, "
			+ "p.id.codigo, p.descricao, p.descReduz, p.unidade) "
			+ " FROM Item p, Ean e, Aen a "
			+ "WHERE p.situacao = 'A'"
			+ " AND p.id.empresa = e.id.empresa "
			+ " AND p.id.codigo = e.id.codigo"
			+ " AND p.id.empresa = :empresa "
			+ " AND a.id.linhaProd = p.categoria  "
			+ " AND a.id.linhaProd = :categoria  "
			+ " AND a.id.cnpj = :cnpj "
			+ " AND a.id.sistema = :sistema")
	public List<ItemDto> findByCategoria(
			@Param("sistema") String sistema, @Param("cnpj") String cnpj, 
			@Param("empresa") String empresa, @Param("categoria") Integer categoria);

	@Query("SELECT new com.aceex.wscairu.dto.ItemDto(e.ean, p.id.empresa, "
			+ "p.id.codigo, p.descricao, p.descReduz, p.unidade) "
			+ " FROM Item p, Ean e, Aen a "
			+ "WHERE p.situacao = 'A'"
			+ " AND p.id.empresa = e.id.empresa "
			+ " AND p.id.codigo = e.id.codigo"
			+ " AND p.id.empresa = :empresa "
			+ " AND p.id.codigo LIKE %:codigo%"
			+ " AND p.descricao LIKE %:descricao%"
			+ " AND a.id.linhaProd = p.categoria  "
			+ " AND a.id.cnpj = :cnpj "
			+ " AND a.id.sistema = :sistema")
	public Page<ItemDto> findPage(
			@Param("cnpj") String cnpj, @Param("empresa") String empresa, 
			@Param("codigo") String codigo, @Param("descricao") String descricao, 
			@Param("sistema") String sistema, Pageable pageRequest);


}
