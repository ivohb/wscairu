package com.aceex.wscairu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aceex.wscairu.key.ListaMestreKey;

@Entity
@Table(name = "desc_preco_mest")
public class ListaMestre implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ListaMestreKey id = new ListaMestreKey();

	@Column(name = "den_list_preco", length = 15)
	private String descricao;

	@Column(name = "dat_ini_vig")
	private Date iniVigenc;

	@Column(name = "dat_fim_vig")
	private Date fimVigenc;

	@Column(name = "ies_bloq_pedido", length = 1)
	private String bloqueiaPed;

	@Column(name = "ies_bloq_fatur", length = 1)
	private String bloqueiaFat;

}
