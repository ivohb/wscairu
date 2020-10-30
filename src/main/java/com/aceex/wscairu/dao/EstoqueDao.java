package com.aceex.wscairu.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aceex.wscairu.dto.EstoqueDto;
import com.aceex.wscairu.key.EstoqueKey;
import com.aceex.wscairu.model.Estoque;

@Repository                                      
public interface EstoqueDao extends JpaRepository<Estoque, EstoqueKey>  {

	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Estoque obj "
			+ "WHERE obj.id.empresa = :empresa"
			+ " AND obj.id.codigo = :codigo")
	public Estoque findByKey(@Param("empresa") String empresa,
			@Param("codigo") String codigo);

	@Transactional(readOnly=true)
	@Query("SELECT new com.aceex.wscairu.dto.EstoqueDto(e.id.empresa, "
			+ "e.id.codigo, e.qtdLiberada, e.qtdReservada) "
			+ " FROM Estoque e, Item i, Aen a "
			+ "WHERE e.id.empresa = i.id.empresa "
			+ " AND e.id.codigo = i.id.codigo"
			+ " AND e.id.empresa = :empresa"
			+ " AND e.id.codigo = :codigo"
			+ " AND a.id.linhaProd = i.categoria "
			+ " AND a.id.cnpj = :cnpj "
			+ " AND a.id.sistema = :sistema")
	public EstoqueDto findByProduct(@Param("cnpj") String cnpj, @Param("empresa") String empresa,
			@Param("codigo") String codigo, @Param("sistema") String sistema);

	@Query("SELECT new com.aceex.wscairu.dto.EstoqueDto(e.id.empresa, "
			+ "e.id.codigo, e.qtdLiberada, e.qtdReservada) "
			+ " FROM Estoque e, Item i, Aen a "
			+ "WHERE e.id.empresa = i.id.empresa "
			+ " AND e.id.codigo = i.id.codigo"
			+ " AND e.id.empresa LIKE %:empresa%"
			+ " AND e.id.codigo LIKE %:codigo%"
			+ " AND i.descricao LIKE %:descricao%"
			+ " AND a.id.linhaProd = i.categoria "
			+ " AND a.id.cnpj = :cnpj "
			+ " AND a.id.sistema = :sistema")
	public Page<EstoqueDto> findPage(
			@Param("cnpj") String cnpj, @Param("empresa") String empresa, 
			@Param("codigo") String codigo, @Param("descricao") String descricao, 
			@Param("sistema") String sistema, Pageable pageRequest);

}
