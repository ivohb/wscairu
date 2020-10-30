package com.aceex.wscairu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aceex.wscairu.dao.AuditVdpDao;
import com.aceex.wscairu.dao.CidadeIbgeDao;
import com.aceex.wscairu.dao.CliCreditoDao;
import com.aceex.wscairu.dao.ClienteDao;
import com.aceex.wscairu.dao.EmpresaDao;
import com.aceex.wscairu.dao.ItemDao;
import com.aceex.wscairu.dao.ParVdpDao;
import com.aceex.wscairu.dao.ParametroDao;
import com.aceex.wscairu.dao.PedAenItemPedDao;
import com.aceex.wscairu.dao.PedComplPedDao;
import com.aceex.wscairu.dao.PedInfComItemDao;
import com.aceex.wscairu.dao.PedInfComMestDao;
import com.aceex.wscairu.dao.PedItemEspelhoDao;
import com.aceex.wscairu.dao.PedidoEntregaDao;
import com.aceex.wscairu.dao.PedidoItemDao;
import com.aceex.wscairu.dao.PedidoListDao;
import com.aceex.wscairu.dao.PedidoObservDao;
import com.aceex.wscairu.dao.PedidoTextoDao;
import com.aceex.wscairu.dao.PedidoVdpDao;
import com.aceex.wscairu.dao.UsuarioDao;
import com.aceex.wscairu.dto.ClienteDto;
import com.aceex.wscairu.dto.PedidoEntregaDto;
import com.aceex.wscairu.dto.PedidoItemDto;
import com.aceex.wscairu.dto.PedidoObservDto;
import com.aceex.wscairu.dto.PedidoTextoDto;
import com.aceex.wscairu.dto.PedidoVdpDto;
import com.aceex.wscairu.key.PedAenItemPedKey;
import com.aceex.wscairu.key.PedComplPedKey;
import com.aceex.wscairu.key.PedInfComItemKey;
import com.aceex.wscairu.key.PedInfComMestKey;
import com.aceex.wscairu.key.PedItemKey;
import com.aceex.wscairu.key.PedObservKey;
import com.aceex.wscairu.key.PedidoEntregaKey;
import com.aceex.wscairu.key.PedidoListKey;
import com.aceex.wscairu.key.PedidoTextoKey;
import com.aceex.wscairu.key.PedidoVdpKey;
import com.aceex.wscairu.model.AuditVdp;
import com.aceex.wscairu.model.CidadeIbge;
import com.aceex.wscairu.model.Cliente;
import com.aceex.wscairu.model.Empresa;
import com.aceex.wscairu.model.Item;
import com.aceex.wscairu.model.ParVdp;
import com.aceex.wscairu.model.Parametro;
import com.aceex.wscairu.model.PedAenItemPed;
import com.aceex.wscairu.model.PedComplPed;
import com.aceex.wscairu.model.PedInfComItem;
import com.aceex.wscairu.model.PedInfComMest;
import com.aceex.wscairu.model.PedItemEspelho;
import com.aceex.wscairu.model.PedidoEntrega;
import com.aceex.wscairu.model.PedidoItem;
import com.aceex.wscairu.model.PedidoList;
import com.aceex.wscairu.model.PedidoObserv;
import com.aceex.wscairu.model.PedidoTexto;
import com.aceex.wscairu.model.PedidoVdp;
import com.aceex.wscairu.model.Usuario;
import com.aceex.wscairu.security.UsuarioSS;
import com.aceex.wscairu.util.Biblioteca;

@Service
public class PedidoVdpService {

	@Autowired
	private PedidoVdpDao vdpDao;
	@Autowired
	private EmpresaDao empDao;
	@Autowired
	private ClienteDao cliDao;
	@Autowired
	private ClienteService cliService;
	@Autowired
	private ParametroDao parDao;
	@Autowired
	private ParVdpDao pvDao;
	@Autowired
	private PedidoListDao plDao;
	@Autowired
	private PedComplPedDao pcpDao;
	@Autowired
	private UsuarioDao userDao;
	@Autowired
	private PedidoEntregaDao peDao;
	@Autowired
	private CidadeIbgeDao ibgeDao;
	@Autowired
	private PedidoObservDao poDao;
	@Autowired
	private PedidoTextoDao ptDao;
	@Autowired
	private PedidoItemDao prodDao;
	@Autowired
	private PedItemEspelhoDao piedDao;
	@Autowired
	private CliCreditoDao ccDao;
	@Autowired
	private PedInfComMestDao picmDao;
	@Autowired
	private AuditVdpDao avDao;
	@Autowired
	private PedInfComItemDao piciDao;
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private PedAenItemPedDao paipDao;
	
	private Empresa empresa;
	private Cliente cliente;
	private PedidoVdp pedido;
	private Biblioteca bib = new Biblioteca();
	
	private Date datAtu;
	private Double zero;
	
	@Transactional
	public PedidoVdp insert(PedidoVdpDto dto) {
		empresa = empDao.findByCnpj(dto.getCnpjEmpresa());
		cliente = cliDao.findByCnpj(dto.getCnpjCliente());
				
		if (dto.getCliente() != null) {
			atuCliente(dto.getCliente());
		}
		
		insPedidoVdp(dto);
		
		return pedido;
	}
	
	private void atuCliente(ClienteDto dto) {
		if (cliente != null) {
			cliService.atuCliente(dto, cliente.getId());
		} else {
			cliService.insCliente(dto);
		}
		cliente = cliDao.findByCnpj(dto.getCpfCnpj());	
	}
	
	private void insPedidoVdp(PedidoVdpDto dto) {
		insPedidos(dto);
		insPedidoCompl();
		
		if (dto.getEntrega() != null) {
			insEntrega(dto.getEntrega());
		}
		
		if (dto.getObservacao() != null) {
			insObserv(dto.getObservacao());
		}

		if (dto.getTexto() != null) {
			insTexto(dto.getTexto());
		}

		insProduto(dto.getProduto());
		
	}
	
	private void insPedidos(PedidoVdpDto dto) {
		zero = 0.00;		
		Parametro par = parDao.findByEmpresa(empresa.getId());
		pedido =  fromParametro(par);		
		PedidoVdpKey key = new PedidoVdpKey();
		ParVdp pv = pvDao.findByKey(empresa.getEmpresa());
		key.setEmpresa(empresa.getEmpresa());
		key.setNumero(pv.getNumPrxPedido());
		pvDao.updateParVdp(empresa.getEmpresa(), (pv.getNumPrxPedido()+1));
		pedido.setId(key);
		pedido.setAceite("S");
		pedido.setCliente(cliente.getId());
		String emissao = bib.dateToStr(new java.util.Date(), "yyyy-MM-dd");
		datAtu = bib.ansiToDate(emissao, "dd/MM/yyyy");
		pedido.setEmissao(bib.ansiToDate(emissao, "dd/MM/yyyy"));
		pedido.setDatAltSit(pedido.getEmissao());
		pedido.setEmisRepres(bib.ansiToDate(dto.getDatEmissao(), "dd/MM/yyyy"));
		pedido.setPctDescAdic(zero);
		pedido.setPctDescFinanc(zero);
		pedido.setPctFrete(zero);
		pedido.setPedCliente("");
		pedido.setPedRepres(dto.getPedidoRepres());
		pedido.setVersaoLista(0);
		vdpDao.save(pedido);
	}

	private PedidoVdp fromParametro(Parametro par) {
		PedidoVdp pedVdp = new PedidoVdp();
		pedVdp.setCarteira(par.getCarteira());
		pedVdp.setCodPgto(par.getCodPgto());
		pedVdp.setEmbalPadrao(par.getEmbalPadrao());
		pedVdp.setFinalidade(par.getFinalidade());
		//pedVdp.setLista(par.getLista());
		pedVdp.setLista(null);
		pedVdp.setLocalEstoque(par.getLocalEstoque());
		pedVdp.setMoeda(par.getMoeda());
		pedVdp.setNatOper(par.getNatOper());
		pedVdp.setPctComissao(par.getPctComissao());
		pedVdp.setRepresentante(par.getRepresentante());
		pedVdp.setSituacao(par.getSituacao());
		pedVdp.setTemComissao(par.getTemComissao());
		pedVdp.setTipEntrega(par.getTipEntrega());
		pedVdp.setTipFrete(par.getTipFrete());
		pedVdp.setTipPreco(par.getTipPreco());
		pedVdp.setTipVenda(par.getTipVenda());
		return pedVdp;
	}

	private void insPedidoCompl() {
		UsuarioSS user = UserSecurityService.authenticated();
		Usuario usuario = userDao.findByCodigo(user.getUsername());
		
		PedidoList pl = new PedidoList();
		pl.setId(new PedidoListKey(pedido.getId().getEmpresa(), 
				pedido.getId().getNumero(), usuario.getCodigoErp()));
		plDao.save(pl);		

		PedComplPed pcp = new PedComplPed();
		PedComplPedKey pcpk = new PedComplPedKey();
		pcpk.setEmpresa(pedido.getId().getEmpresa());
		pcpk.setNumero(pedido.getId().getNumero());
		pcp.setId(pcpk);
		pcp.setUsuario(usuario.getCodigoErp());
		pcp.setData(new java.util.Date());
		pcpDao.save(pcp);		
		
		PedInfComMest picm = new PedInfComMest();
		PedInfComMestKey picmk = new PedInfComMestKey();
		picmk.setEmpresa(pedido.getId().getEmpresa());
		picmk.setNumero(pedido.getId().getNumero());
		picm.setId(picmk);
		picm.setUsuario(usuario.getCodigoErp());
		picm.setDatInclusao(datAtu);
		picm.setDatVigencia(datAtu);
		picm.setPedidoPallet("N");
		picm.setPctTolMax(zero);
		picm.setPctTolMin(zero);
		picm.setHorInclusao("00:00:00");
		picm.setTipImportacao("WSCAIRU");
		picm.setRegraCotacao("P");
		picm.setValCotacaoFixa(zero);
		picm.setValFreteSug(zero);
		picmDao.save(picm);

		AuditVdp av = new AuditVdp();
		av.setData(datAtu);
		av.setEmpresa(pedido.getId().getEmpresa());
		av.setHora(bib.horaAtual("hh:mm:ss"));
		av.setPedido(pedido.getId().getNumero());
		av.setPrograma("WSCAIRU");
		String texto = "Inclusão do pedido. Situação atual: "
				+pedido.getSituacao()+" Aceite atual: "+pedido.getAceite();
		av.setTexto(texto);
		av.setTipInfo("M");
		av.setTipMovto("I");
		av.setUsuario(usuario.getCodigoErp());
		avDao.save(av);
		
	}
	
	private void insEntrega(PedidoEntregaDto dto) {
		PedidoEntrega obj = new PedidoEntrega();
		obj.setBairro(dto.getBairro());
		obj.setCep(dto.getCepEntrega());
		obj.setCnpj(dto.getCnpjEntrga());
		obj.setEndereco(dto.getEndereco());
		obj.setIncricao(dto.getInscEstadual());
		obj.setCidade(getCidade(dto.getUfEntrega(), dto.getCidade()));
		obj.setId(new PedidoEntregaKey(
				pedido.getId().getEmpresa(), pedido.getId().getNumero(), 0)); 
		peDao.save(obj);
	}

	private String getCidade(String uf, String ibge) {
		CidadeIbge ci = ibgeDao.findByKey(uf, ibge);		
		if (ci == null) {
			return " ";
		} else {
			return ci.getCidLogix();
		}
	}
	
	private void insObserv(PedidoObservDto dto) {
		PedidoObserv obj = new PedidoObserv();
		obj.setId(new PedObservKey(
			pedido.getId().getEmpresa(), pedido.getId().getNumero()));
		obj.setTxtObs1(dto.getTxtObs1());
		obj.setTxtObs2(dto.getTxtObs2());
		poDao.save(obj);
	}
	
	private void insTexto(PedidoTextoDto dto) {
		PedidoTexto obj = new PedidoTexto();
		obj.setId(new PedidoTextoKey(
				pedido.getId().getEmpresa(), pedido.getId().getNumero(), 0)); 
		obj.setTxtPed1(dto.getTxtPed1());
		obj.setTxtPed2(dto.getTxtPed2());
		obj.setTxtPed3(dto.getTxtPed3());
		obj.setTxtPed4(dto.getTxtPed4());
		obj.setTxtPed5(dto.getTxtPed5());
		ptDao.save(obj);
	}

	private void insProduto(List<PedidoItemDto> produtos) {
		
		Double zero = 0.0;
		Integer numSeq = 0;
		Double valPedido = 0.0;
		
		for (PedidoItemDto dto : produtos) {
			PedidoItem obj = new PedidoItem();
			numSeq++;
			obj.setDescComUnit(zero);
			obj.setId(new PedItemKey(
					pedido.getId().getEmpresa(), pedido.getId().getNumero(), numSeq)); 
			obj.setItem(dto.getCodigo());
			obj.setPctDescAdic(zero);
			obj.setPctDescBruto(zero);
			obj.setPrzEntrega(bib.ansiToDate(dto.getDatEntrega(), "dd/MM/yyyy"));
			obj.setQtdAtendida(zero);
			obj.setQtdCancelada(zero);
			obj.setQtdReservada(zero);
			obj.setQtdRomaneio(zero);
			obj.setQtdSolicit(dto.getQuantidade());
			obj.setValFreteUnit(zero);
			obj.setValSeguroUnit(zero);
			obj.setPreUnit(dto.getPreUnit());
			valPedido+=obj.getPreUnit();
			
			prodDao.save(obj);
			
			PedItemEspelho pie = new PedItemEspelho();
			pie.setEmpresa(pedido.getId().getEmpresa());
			pie.setItem(obj.getItem());
			pie.setNumero(obj.getId().getNumero());
			pie.setPrzEntrega(obj.getPrzEntrega());
			pie.setPreUnit(obj.getPreUnit());
			pie.setQtdAtendida(obj.getQtdAtendida());
			pie.setQtdCancelada(obj.getQtdCancelada());
			pie.setQtdSolicit(obj.getQtdSolicit());
			pie.setSequencia(numSeq);
			piedDao.save(pie);
			
			boolean insTxt = false;
			if (dto.getTxtProd1() == null || dto.getTxtProd1().isEmpty()) {
			} else {
				insTxt = true;
			}
			if (dto.getTxtProd2() == null || dto.getTxtProd2().isEmpty()) {
			} else {
				insTxt = true;
			}
			if (dto.getTxtProd3() == null || dto.getTxtProd3().isEmpty()) {
			} else {
				insTxt = true;
			}
			if (dto.getTxtProd4() == null || dto.getTxtProd4().isEmpty()) {
			} else {
				insTxt = true;
			}
			if (dto.getTxtProd5() == null || dto.getTxtProd5().isEmpty()) {
			} else {
				insTxt = true;
			}
			
			if (insTxt) {
				PedidoTexto pt = new PedidoTexto();
				pt.setId(new PedidoTextoKey(
						pedido.getId().getEmpresa(), pedido.getId().getNumero(), numSeq));
				pt.setTxtPed1(dto.getTxtProd1());
				pt.setTxtPed2(dto.getTxtProd2());
				pt.setTxtPed3(dto.getTxtProd3());
				pt.setTxtPed4(dto.getTxtProd4());
				pt.setTxtPed5(dto.getTxtProd5());
				ptDao.save(pt);
			}			
			insItemCompl(numSeq, obj.getItem());
		}
		ccDao.updateCliCredito(cliente.getId(), valPedido);		
	}

	private void insItemCompl(Integer numSeq, String codigo) {
		PedInfComItem pici = new PedInfComItem();
		pici.setDat_ult_alteracao(datAtu);
		pici.setId(new PedInfComItemKey(pedido.getId().getEmpresa(), 
				pedido.getId().getNumero(), numSeq));
		pici.setTipItem("N");
		piciDao.save(pici);
		
		Item item = itemDao.findByKey(pedido.getId().getEmpresa(), codigo);
		PedAenItemPed paip = new PedAenItemPed();
		paip.setId(new PedAenItemPedKey(pedido.getId().getEmpresa(), 
				pedido.getId().getNumero(), numSeq));
		paip.setClasseUso(item.getCor());
		paip.setLinProduto(item.getCategoria());
		paip.setLinReceita(item.getAgrupamento());
		paip.setSegMercado(item.getTamanho());
		paipDao.save(paip);
	}
}
