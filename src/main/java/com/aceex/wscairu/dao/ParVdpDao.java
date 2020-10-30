package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aceex.wscairu.model.ParVdp;

@Repository                                      
public interface ParVdpDao extends JpaRepository<ParVdp, String>  {

	@Transactional(readOnly=true)
	@Query("SELECT new ParVdp(obj.numPrxPedido) FROM ParVdp obj WHERE obj.id = :id")
	public ParVdp findByKey(@Param("id") String id);

	@Modifying
	@Transactional(readOnly=false)
	@Query("UPDATE ParVdp SET numPrxPedido = :prxNumber WHERE id = :id ")
	public void updateParVdp(
			@Param("id") String id, @Param("prxNumber") Integer prxNumber);

}
