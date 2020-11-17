package com.aceex.wscairu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aceex.wscairu.model.EstoqLocReser;

@Repository                                      
public interface EstoqLocReserDao extends JpaRepository<EstoqLocReser, Integer>  {

	@Transactional(readOnly=true)
	@Query("SELECT new EstoqLocReser(SUM(obj.qtdReservada)) FROM EstoqLocReser obj "
			+ "WHERE obj.empresa = :empresa"
			+ " AND obj.item = :codigo"
			+ " AND obj.local = :local"
			+ " AND obj.lote IS NULL AND obj.qtdReservada > 0 ")
	public EstoqLocReser findReserva(@Param("empresa") String empresa,
			@Param("codigo") String codigo, @Param("local") String local);

}
