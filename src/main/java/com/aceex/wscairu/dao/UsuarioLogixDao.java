package com.aceex.wscairu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aceex.wscairu.model.UsuarioLogix;

@Repository
public interface UsuarioLogixDao extends JpaRepository<UsuarioLogix, String>  {

	//Na Entidade UsuarioLogix, o cod_usuario foi mapeado como id
	
	@Transactional(readOnly=true)
	@Query("FROM UsuarioLogix obj WHERE obj.id = :codigo")
	public UsuarioLogix findByCodigo(@Param("codigo") String codigo);

	@Transactional(readOnly=true)
	@Query("SELECT new UsuarioLogix(obj.id, obj.nome) FROM UsuarioLogix obj ")
	public List<UsuarioLogix> popup();

}
