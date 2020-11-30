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
import com.aceex.wscairu.dao.EstoqLocReserDao;
import com.aceex.wscairu.dao.EstoqLoteEnderDao;
import com.aceex.wscairu.dao.EstoqReserEndDao;
import com.aceex.wscairu.dao.EstoqueDao;
import com.aceex.wscairu.dao.ItemDao;
import com.aceex.wscairu.dao.ItemEmbalDao;
import com.aceex.wscairu.dao.OmListDao;
import com.aceex.wscairu.dao.OrdMontagEmbalDao;
import com.aceex.wscairu.dao.OrdMontagGradeDao;
import com.aceex.wscairu.dao.OrdMontagItemDao;
import com.aceex.wscairu.dao.OrdMontagLoteDao;
import com.aceex.wscairu.dao.OrdMontagMestDao;
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
import com.aceex.wscairu.dao.PedidoOmDao;
import com.aceex.wscairu.dao.PedidoTextoDao;
import com.aceex.wscairu.dao.PedidoVdpDao;
import com.aceex.wscairu.dao.UsuarioDao;
import com.aceex.wscairu.dto.ClienteDto;
import com.aceex.wscairu.dto.EmbalDto;
import com.aceex.wscairu.dto.PedidoEntregaDto;
import com.aceex.wscairu.dto.PedidoItemDto;
import com.aceex.wscairu.dto.PedidoObservDto;
import com.aceex.wscairu.dto.PedidoTextoDto;
import com.aceex.wscairu.dto.PedidoVdpDto;
import com.aceex.wscairu.exception.ObjectNotFoundException;
import com.aceex.wscairu.key.EstoqReserEndKey;
import com.aceex.wscairu.key.OmListKey;
import com.aceex.wscairu.key.OrdMontagEmbalKey;
import com.aceex.wscairu.key.OrdMontagItemKey;
import com.aceex.wscairu.key.OrdMontagLoteKey;
import com.aceex.wscairu.key.OrdMontagMestKey;
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
import com.aceex.wscairu.model.EstoqLocReser;
import com.aceex.wscairu.model.EstoqLoteEnder;
import com.aceex.wscairu.model.EstoqReserEnd;
import com.aceex.wscairu.model.Item;
import com.aceex.wscairu.model.OmList;
import com.aceex.wscairu.model.OrdMontagEmbal;
import com.aceex.wscairu.model.OrdMontagGrade;
import com.aceex.wscairu.model.OrdMontagItem;
import com.aceex.wscairu.model.OrdMontagLote;
import com.aceex.wscairu.model.OrdMontagMest;
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
import com.aceex.wscairu.model.PedidoOm;
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
	private PedidoItemDao piDao;
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
	@Autowired
	private OrdMontagLoteDao omlDao;
	@Autowired
	private EstoqLoteEnderDao eleDao;
	@Autowired
	private EstoqLocReserDao elrDao;
	@Autowired
	private EstoqReserEndDao elreDao;
	@Autowired
	private OrdMontagGradeDao omgDao;
	@Autowired
	private ItemEmbalDao ieDao;
	@Autowired
	private OrdMontagItemDao omiDao;
	@Autowired
	private OrdMontagEmbalDao omeDao;
	@Autowired
	private EstoqueDao estDao;
	@Autowired
	private OrdMontagMestDao ommDao;
	@Autowired
	private OmListDao olDao;
	@Autowired
	private PedidoOmDao pomDao;
	
	
	private Empresa empresa;
	private Cliente cliente;
	private PedidoVdp pedido;
	private Biblioteca bib = new Biblioteca();
	
	private Date datAtu;
	private Double zero;
	private Integer numOm;
	private Integer numLotOm;
	private Double pesoItem;
	private Double pesoLiquido;
	private Double pesoBruto;
	private Double pesoEmbal;
	private String codEmbal;
	private Double qtdVolume;
	private Double totVolume;
	private String codUsuario;
	
	public PedidoVdp findByKey(String codEmpresa, Integer numero) {			
		PedidoVdp obj = vdpDao.findByKey(codEmpresa, numero);
		if (obj == null) {
			throw new ObjectNotFoundException(
				"Não encontrado! Numero: " + numero + ", "
						+ "Objeto: " + PedidoVdp.class.getName());
		}		
		return obj;
	}
	
	@Transactional
	public PedidoVdp insert(PedidoVdpDto dto) {
		empresa = empDao.findByCnpj(dto.getCnpjEmpresa());
		cliente = cliDao.findByCnpj(dto.getCnpjCliente());
		
		if (dto.getCliente() != null) {
			atuCliente(dto.getCliente());
		}
		
		insPedidoVdp(dto);
		
		if (empresa.getGerar().equalsIgnoreCase("S")) {
			insRomaneio();			
		}
		
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
		numOm = pv.getNumUltOm()+1;
		pvDao.updateParVdp(empresa.getEmpresa(), (pv.getNumPrxPedido()+1), numOm);
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
		codUsuario = usuario.getCodigoErp();
		
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
			
			piDao.save(obj);
			
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
	
	private void insRomaneio() {
		pesoLiquido = zero;
		pesoBruto = zero;
		pesoEmbal = zero;
	    totVolume = zero;
		numLotOm = insLoteOm();
		List<PedidoItem> itens = piDao.findByEmpresaAndPedido(
				pedido.getId().getEmpresa(), pedido.getId().getNumero());
		
		for (PedidoItem pedItem : itens) {
			insReserva(pedItem);
			insOrdMontagItem(pedItem);
			insOrdMontagEmbal(pedItem);
			atuPedItem(pedItem);
			atuEstoque(pedItem);
		}
		
		insOrdMontagMest();
		insOmList();
		insPedidoOm();
	}
	
	private Integer insLoteOm() {
		Integer numLote = leLoteOm();
		OrdMontagLoteKey key = new OrdMontagLoteKey();
		key.setEmpresa(empresa.getEmpresa());
		key.setLote(numLote);
		OrdMontagLote obj = new OrdMontagLote();
		obj.setId(key);
		obj.setCarteira(pedido.getCarteira());
		obj.setConsignatario("0");
		obj.setEmissao(pedido.getEmissao());
		obj.setEntrega(0);
		obj.setSituacao("N");
		obj.setTransportador("0");
		obj.setValFreteConsig(zero);
		obj.setValFreteLote(zero);
		omlDao.save(obj);		
		return numLote;
	}
	
	private Integer leLoteOm() {
		OrdMontagLote oml = omlDao.findMaxLote(empresa.getEmpresa());
		Integer numLote = oml.getId().getLote() + 1;
		return numLote;
	}
	
	private void insReserva(PedidoItem pedItem) {		
		Double estReser = zero;
		Item item = itemDao.findByKey(empresa.getEmpresa(), pedItem.getItem());
		pesoItem = item.getPeso();
		
		EstoqLocReser elr = elrDao.findReserva(empresa.getEmpresa(), 
				item.getId().getCodigo(), item.getLocalEstoq());

		if (elr != null) {
			if (elr.getQtdReservada() != null) {
				estReser = elr.getQtdReservada();
			}
		}

		EstoqLoteEnder ele = leEstoque(
				item.getId().getCodigo(), item.getLocalEstoq(), estReser);
		
		if (ele == null || ele.getSaldo() < pedItem.getQtdSolicit()) {
			throw new ObjectNotFoundException(
				"Sem estoque! Produto: " + pedItem.getItem() + ", "
						+ " Empresa: " + item.getId().getEmpresa());
		}

		elr.setEmpresa(empresa.getEmpresa());
		elr.setId(null);
		elr.setItem(pedItem.getItem());
		elr.setLocal(item.getLocalEstoq());
		elr.setLote(null);
		elr.setOrigem("V");
		elr.setNumDocum(""+pedItem.getId().getNumero());
		elr.setDatSolicitacao(pedido.getEmissao());
		elr.setQtdAtendida(zero);
		elr.setQtdReservada(pedItem.getQtdSolicit());
		elr.setSituacao("N");
		elrDao.save(elr);
		System.out.println(elr.getId());
		
		insEstReserEnd(ele, elr.getId());
		insOrdMontagGrade(ele, elr.getId(), pedItem);
		
	}

	private EstoqLoteEnder leEstoque(String codigo, String local, Double estReser) {
		EstoqLoteEnder ele = eleDao.findEstoque(empresa.getEmpresa(), codigo, local);	
		if (ele != null) {
			ele.setSaldo(ele.getSaldo() - estReser);
		}
		return ele;
	}

	private void insEstReserEnd(EstoqLoteEnder ele, Integer numReserva) {
		EstoqReserEndKey key = new EstoqReserEndKey();
		key.setEmpresa(empresa.getEmpresa());
		key.setReserva(numReserva);
		EstoqReserEnd obj = new EstoqReserEnd();
		obj.setId(key);
		obj.setAltura(ele.getAltura());
		obj.setComprimento(ele.getComprimento());
		obj.setDatProducao(ele.getDatProducao());
		obj.setDatReser1(ele.getDatReser1());
		obj.setDatReser2(ele.getDatReser2());
		obj.setDatReser3(ele.getDatReser3());
		obj.setDatValidade(ele.getDatValidade());
		obj.setDeposit(ele.getDeposit());
		obj.setDiametro(ele.getDiametro());
		obj.setEndereco(ele.getEndereco());
		obj.setGrade1(ele.getGrade1());
		obj.setGrade2(ele.getGrade2());
		obj.setGrade3(ele.getGrade3());
		obj.setGrade4(ele.getGrade4());
		obj.setGrade5(ele.getGrade5());
		obj.setIdEstoque(ele.getIdEstoque());
		obj.setLargura(ele.getLargura());
		obj.setNumPeca(ele.getNumPeca());
		obj.setNumReser1(ele.getNumReser1());
		obj.setNumReser2(ele.getNumReser2());
		obj.setNumReser3(ele.getNumReser3());
		obj.setNumSerie(ele.getNumSerie());
		obj.setPedVenda(ele.getPedVenda());
		obj.setQtdReser1(ele.getQtdReser1());
		obj.setQtdReser2(ele.getQtdReser2());
		obj.setQtdReser3(ele.getQtdReser3());
		obj.setSeqPedVenda(ele.getSeqPedVenda());
		obj.setTexReservado(ele.getTexReservado());
		obj.setVolume(ele.getVolume());
		elreDao.save(obj);
	}
	
	private void insOrdMontagGrade(EstoqLoteEnder ele, Integer numReserva, PedidoItem pedItem) {
		OrdMontagGrade obj = new OrdMontagGrade();
		obj.setId(numReserva);
		obj.setEmpresa(empresa.getEmpresa());
		obj.setItem(ele.getItem());
		obj.setOrdem(numOm);
		obj.setPedido(pedido.getId().getNumero());
		obj.setQtdReservada(pedItem.getQtdReservada());
		obj.setSequencia(pedItem.getId().getSequencia());
		obj.setGrade1(ele.getGrade1());
		obj.setGrade2(ele.getGrade2());
		obj.setGrade3(ele.getGrade3());
		obj.setGrade4(ele.getGrade4());
		obj.setGrade5(ele.getGrade5());
		obj.setComposicao(null);
		omgDao.save(obj);
	}

	private void insOrdMontagItem(PedidoItem pedItem) {	
		codEmbal = "0";
		Double qtdEmbal = 1.0;
		Double pesUnitEmbal = zero;
	    qtdVolume = pedItem.getQtdSolicit();
		
		EmbalDto eDto = ieDao.findEmbal(pedItem.getId().getEmpresa(), pedItem.getItem());
		
		if (eDto != null) {
			if (eDto.getCodMatriz() == null) {
				codEmbal = eDto.getCodEmbal();
			} else {
				codEmbal = eDto.getCodMatriz();
			}		
			qtdEmbal = eDto.getQtdPadrao();
			if (eDto.getPesUnit() != null) {
				pesUnitEmbal = eDto.getPesUnit();
			}
		}
		
		if (qtdEmbal == null) {
			qtdEmbal = 1.0;
		}

		qtdVolume = qtdVolume / qtdEmbal;		
		totVolume = totVolume + qtdVolume;
		pesoLiquido = pesoItem * pedItem.getQtdSolicit();
		pesoEmbal = pesUnitEmbal * qtdVolume;
		pesoBruto = pesoBruto + pesoLiquido + pesoEmbal;		
		
		OrdMontagItemKey key = new OrdMontagItemKey();
		OrdMontagItem obj = new OrdMontagItem();
		key.setEmpresa(pedItem.getId().getEmpresa());
		key.setOrdem(numOm);
		key.setSequencia(pedItem.getId().getSequencia());
		obj.setId(key);
		obj.setPedido(pedItem.getId().getNumero());
		obj.setBonificacao("N");
		obj.setItem(pedItem.getItem());
		obj.setPesTotal(pesoLiquido);
		obj.setQtdReservada(pedItem.getQtdSolicit());
		obj.setQtdVolume(qtdVolume);
		omiDao.save(obj);
	}
	
	private void insOrdMontagEmbal(PedidoItem pedItem) {	
		OrdMontagEmbalKey key = new OrdMontagEmbalKey();
		key.setEmpresa(pedItem.getId().getEmpresa());
		key.setOrdem(numOm);
		key.setSequencia(pedItem.getId().getSequencia());
		OrdMontagEmbal obj = new OrdMontagEmbal();
		obj.setId(key);
		obj.setEmbalExt("0");
		obj.setEmbalInt(codEmbal);
		obj.setIesLotacao("T");
		obj.setItem(pedItem.getItem());
		obj.setNumEmbalFinal(1);
		obj.setNumEmbalInicio(1);
		obj.setQtdEmbalExt(zero);
		obj.setQtdEmbalInt(qtdVolume);
		obj.setQtdPecas(pedItem.getQtdSolicit());
		omeDao.save(obj);
	}

	private void atuPedItem(PedidoItem pedItem) {	
		piDao.update(pedItem.getId().getEmpresa(), pedItem.getId().getNumero(), 
				pedItem.getId().getSequencia(), pedItem.getQtdSolicit());
	}
	
	private void atuEstoque(PedidoItem pedItem) {estDao.update(pedItem.getId().getEmpresa(), 
			pedItem.getItem(), pedItem.getQtdSolicit());		
	}

	private void insOrdMontagMest() {
		OrdMontagMestKey key = new OrdMontagMestKey();
		key.setEmpresa(empresa.getEmpresa());
		key.setOrdem(numOm);
		OrdMontagMest obj = new OrdMontagMest();
		obj.setEmissao(pedido.getEmissao());
		obj.setId(key);
		obj.setLote(numLotOm);
		obj.setNotaFiscal(null);
		obj.setSituacao("N");
		obj.setTransportador(null);
		obj.setVolume(totVolume);
		ommDao.save(obj);		
	}
	
	private void insOmList() {
		OmListKey key = new OmListKey();
		key.setEmpresa(empresa.getEmpresa());
		key.setOrdem(numOm);
		key.setPedido(pedido.getId().getNumero());
		OmList obj = new OmList();
		obj.setId(key);
		obj.setEmissao(pedido.getEmissao());
		obj.setUsuario(codUsuario);
		olDao.save(obj);
	}

	private void insPedidoOm() {
		PedidoOm obj = new PedidoOm();
		obj.setData(pedido.getEmissao());
		obj.setId(null);
		obj.setNumOm(numOm);
		obj.setNumPedido(pedido.getId().getNumero());
		pomDao.save(obj);
	}
}
