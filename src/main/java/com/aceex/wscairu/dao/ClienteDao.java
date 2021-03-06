package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aceex.wscairu.model.Cliente;

@Repository                                     //entidade tipo do id
public interface ClienteDao extends JpaRepository<Cliente, String>  {

	//Na Entidade Cliente, o codigo foi mapeado como id
	
	@Transactional(readOnly=true)
	@Query("FROM Cliente obj WHERE obj.id = :codigo")
	public Cliente findByCodigo(@Param("codigo") String codigo);

	@Transactional(readOnly=true)
	@Query("FROM Cliente obj WHERE obj.cnpj = :cnpj")
	public Cliente findByCnpj(@Param("cnpj") String cnpj);

}
