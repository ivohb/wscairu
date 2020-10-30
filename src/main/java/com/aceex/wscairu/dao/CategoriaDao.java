package com.aceex.wscairu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aceex.wscairu.key.AenKey;
import com.aceex.wscairu.model.Aen;

@Repository                                      
public interface CategoriaDao extends JpaRepository<Aen, AenKey>  {

	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Aen obj "
			+ "WHERE obj.id.sistema = :sistema"
			+ " AND obj.id.cnpj = :cnpj"
			+ " AND obj.id.linhaProd = :codigo")
	public Aen findByKey(
			@Param("sistema") String sistema,
			@Param("cnpj") String cnpj,
			@Param("codigo") Integer codigo);

	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Aen obj "
			+ "WHERE obj.id.sistema = :sistema"
			+ " AND obj.id.cnpj = :cnpj")
	public List<Aen> findBySistemaAndCnpj(
			@Param("sistema") String sistema,
			@Param("cnpj") String cnpj);

}
