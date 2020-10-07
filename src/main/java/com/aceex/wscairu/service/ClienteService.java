package com.aceex.wscairu.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aceex.wscairu.dao.AuditLogixDao;
import com.aceex.wscairu.dao.AuditVdpDao;
import com.aceex.wscairu.dao.CidadeIbgeDao;
import com.aceex.wscairu.dao.CliCreditoDao;
import com.aceex.wscairu.dao.ClienteComplDao;
import com.aceex.wscairu.dao.ClienteDao;
import com.aceex.wscairu.dao.CredcadCliDao;
import com.aceex.wscairu.dto.ClienteDto;
import com.aceex.wscairu.exception.ObjectNotFoundException;
import com.aceex.wscairu.key.AuditLogixKey;
import com.aceex.wscairu.model.AuditLogix;
import com.aceex.wscairu.model.AuditVdp;
import com.aceex.wscairu.model.CidadeIbge;
import com.aceex.wscairu.model.CliCredito;
import com.aceex.wscairu.model.Cliente;
import com.aceex.wscairu.model.ClienteCompl;
import com.aceex.wscairu.model.CredcadCli;
import com.aceex.wscairu.util.Biblioteca;

@Service
public class ClienteService {

	@Value("${emp.auth.raiz}")
	private String raiz;
	
	@Autowired
	private ClienteDao dao;
	@Autowired
	private CidadeIbgeDao ibgeDao;
	@Autowired
	private ClienteComplDao ccDao;
	@Autowired
	private AuditLogixDao alDao;
	@Autowired
	private AuditVdpDao avDao;
	@Autowired
	private CliCreditoDao credDao;
	@Autowired
	private CredcadCliDao cccDao;

	Biblioteca bib = new Biblioteca();

	public Cliente findById(String id) {
		Optional<Cliente> obj = dao.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
			"Não encontrado! Id: " + id + ", Objeto: " + Cliente.class.getName()));
	}

	public Cliente findByCodigo(String codigo) {
		Cliente obj = dao.findByCodigo(codigo);

		if (obj == null) {
			throw new ObjectNotFoundException(
				"Não encontrado! Codigo: " + codigo + ", "
						+ "Objeto: " + Cliente.class.getName());
		}
		
		return obj;
	}

	public List<Cliente> findAll() {
		return dao.findAll();
	}
	
	public String findByCnpj(String cnpj) {
		
		List<Cliente> clientes = dao.findByCnpj(cnpj); 
		
		for (Cliente cliente : clientes) {			
			return cliente.getId();
		}
		
		return "";
	}	

	public List<Cliente> listByCnpj(String cnpj) {
		if (cnpj.length() < 19) { 
			cnpj = "0"+cnpj;
		}		
		return dao.findByCnpj(cnpj); 		
	}

	public Cliente fromDTO(ClienteDto dto) {
		Cliente obj = new Cliente();
		obj.setBairro(dto.getBairro());
		obj.setCep(dto.getCep());
		obj.setCnpj(dto.getCpfCnpj());
		obj.setCodinome(dto.getNomeReduz());
		obj.setContato(dto.getContato());
		obj.setEndereco(dto.getLogradouro());
		obj.setInscEstadual(dto.getInscEstadual());
		obj.setNome(dto.getRazSocial());
		obj.setFone(dto.getTelefone());
		return obj;
	}

	@Transactional
	public Cliente insert(ClienteDto dto) {
		
		Cliente obj = fromDTO(dto);
		obj.setId(bib.tiraFormato(obj.getCnpj()));
		obj.setDatCadastro(bib.dataAtual());
		obj.setDatAtualiz(obj.getDatCadastro());
		
		if (obj.getContato() == null || obj.getContato().isEmpty()) {
			obj.setContato(obj.getCodinome());
		}
		
		CidadeIbge ci = ibgeDao.findByKey(dto.getUf(), dto.getCidadeIbge());
		
		if (ci == null) {
			obj.setCodCidade(" ");
		} else {
			obj.setCodCidade(ci.getCidLogix());
		}
		
		obj.setCodClasse("D");		
		obj.setCodTipo("12");
		obj.setClifornec("C");
		obj.setZonaFranca("N");
		obj.setSituacao("P");
		obj.setCodPraca(0);
		obj.setCodRota(0);
		obj.setCodLocal(0);				
		obj = dao.save(obj);
		
		String hora = bib.horaAtual("hh:mm:ss");
		grvCliCompl(obj.getId(),dto.getEmail());
		grvAudtLogix(obj.getId(), obj.getDatCadastro(), hora);
		grvAudtVdp(obj.getId(), obj.getDatCadastro(), hora);
		grvCliCredito(obj.getId(), obj.getDatCadastro());
		grvCredcad(obj.getId());
		
		return obj;
	}

	private void grvCliCompl(String id, String email) {
		ClienteCompl obj = new ClienteCompl();
		obj.setId(id);
		obj.setEmail(email);
		ccDao.save(obj);		
	}
	
	private void grvAudtLogix(String id, Date data, String hora) {
		AuditLogix obj = new AuditLogix();
		AuditLogixKey key =  new AuditLogixKey();
		key.setData(data);
		key.setEmpresa("01");
		key.setHora(hora);
		key.setPrograma("WSCAIRU");
		obj.setId(key);				
		obj.setTexto("CLIENTE "+id);
		obj.setUsuario("admlog");
		alDao.save(obj);
	}

	private void grvAudtVdp(String id, Date data, String hora) {
		AuditVdp obj = new AuditVdp();
		obj.setData(data);
		obj.setEmpresa("01");
		obj.setHora(hora);
		obj.setPedido(0);
		obj.setTipInfo("M");
		obj.setTipMovto("I");
		obj.setTexto("CLIENTE "+id);
		obj.setPrograma("WSCAIRU");
		obj.setUsuario("admlog");
		obj.setId(null);
		avDao.save(obj);
	}

	private void grvCliCredito(String id, Date data) {
		Double valor = 0.0;
		CliCredito obj = new CliCredito();		
		obj.setDatAtualiz(data);
		obj.setAtrasoDupl(valor);
		obj.setAtrasoMedido(valor);
		obj.setDupAberto(valor);
		obj.setId(id);
		obj.setIesNotaDeb("N");
		obj.setLimitCredito(valor);
		obj.setValCarteira(valor);
		credDao.save(obj);
	}

	private void grvCredcad(String id) {
		Double valor = 0.0;
		CredcadCli obj = new CredcadCli();		
		obj.setId(id);
		obj.setIesAprovacao("S");
		obj.setIesChequeDevolv("N");
		obj.setIesCliColig("N");
		obj.setIesSituaCliente("N");
		obj.setIesTitulosCadvo("N");
		obj.setQtdConsSolicMes(valor);
		obj.setQtdDiasAtrasMed(valor);
		obj.setQtdDiasMaiorAtr(valor);
		obj.setQtdDuplPagasMes(valor);
		obj.setValCapitalRegist(valor);
		obj.setValCheques(valor);
		obj.setValCreditoConced(valor);
		obj.setValCreditos(valor);
		obj.setValDebitoAvencer(valor);
		obj.setValDebitoVencido(valor);
		obj.setValEstoque(valor);
		obj.setValFaturadoMes(valor);
		obj.setValJuroNaoPag(valor);
		obj.setValLucrosPerdas(valor);
		obj.setValMaiorFat(valor);
		obj.setValMaiorAcumulo(valor);
		obj.setValPagoMes(valor);
		obj.setValPedidos(valor);
		obj.setValPedidosAprov(valor);
		obj.setValUltFat(valor);
		obj.setValUltPedido(valor);
		obj.setValVendasAprazo(valor);
		obj.setValVendasAvista(valor);
		cccDao.save(obj);
	}
	
}
