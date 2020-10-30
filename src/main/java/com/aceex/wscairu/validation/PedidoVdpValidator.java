package com.aceex.wscairu.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.aceex.wscairu.dao.ClienteDao;
import com.aceex.wscairu.dao.EmpresaDao;
import com.aceex.wscairu.dao.EstoqueDao;
import com.aceex.wscairu.dao.ItemDao;
import com.aceex.wscairu.dao.ParametroDao;
import com.aceex.wscairu.dao.SystemaDao;
import com.aceex.wscairu.dto.ClienteDto;
import com.aceex.wscairu.dto.ItemDto;
import com.aceex.wscairu.dto.PedidoItemDto;
import com.aceex.wscairu.dto.PedidoVdpDto;
import com.aceex.wscairu.exception.FieldMessage;
import com.aceex.wscairu.model.Cliente;
import com.aceex.wscairu.model.Empresa;
import com.aceex.wscairu.model.Estoque;
import com.aceex.wscairu.model.Parametro;
import com.aceex.wscairu.model.Systema;
import com.aceex.wscairu.security.UsuarioSS;
import com.aceex.wscairu.service.UserSecurityService;

public class PedidoVdpValidator implements ConstraintValidator<PedidoVdpValidation, PedidoVdpDto> {

	@Autowired
	private EmpresaDao empDao;
	@Autowired
	private ClienteDao cliDao;
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private SystemaDao sysDao;
	@Autowired
	private EstoqueDao estDao;
	@Autowired
	private ParametroDao parDao;

	@Override
	public void initialize(PedidoVdpValidation ann) {
		//função executada na inicialização da classe
	}

	@Override
	public boolean isValid(PedidoVdpDto dto, ConstraintValidatorContext context) {

		UsuarioSS user = UserSecurityService.authenticated();
		Systema sys = sysDao.findByUserReq(user.getUsername());

		List<FieldMessage> list = new ArrayList<>();
		Empresa empresa = null;
				
		if (dto.getCnpjEmpresa() == null || dto.getCnpjEmpresa().isEmpty() ) {			
		} else {
			empresa = empDao.findByCnpj(dto.getCnpjEmpresa());
			if (empresa == null) {
				list.add(new FieldMessage("cnpjEmpresa", "cpf_ou_cnpj_invalido"));
			}
		}

		if (dto.getCnpjCliente() == null || dto.getCnpjCliente().isEmpty() ) {			
		} else {
			Cliente cliente  = cliDao.findByCnpj(dto.getCnpjCliente());
			if (cliente == null) {
				ClienteDto cliDto = dto.getCliente();
				if (cliDto == null) {
					list.add(new FieldMessage("cnpjCliente", "cliente_nao_existe"));
				} else {				
					if (cliDto.getCpfCnpj() == null || cliDto.getCpfCnpj().isEmpty()) {
						list.add(new FieldMessage("cliente", "cliente_cnpj_invalido"));						
					}
					if (cliDto.getTipo() == null || cliDto.getTipo().isEmpty() ||
							!("FJ".contains(cliDto.getTipo()))) {
						list.add(new FieldMessage("cliente", "cliente_tipo_invalido"));						
					}
					if (cliDto.getRazSocial() == null || cliDto.getRazSocial().isEmpty()) {
						list.add(new FieldMessage("cliente", "cliente_raz_social_invalida"));						
					}
					if (cliDto.getNomeReduz() == null || cliDto.getNomeReduz().isEmpty()) {
						list.add(new FieldMessage("cliente", "cliente_nome_reduz_invalido"));						
					}
					if (cliDto.getLogradouro() == null || cliDto.getLogradouro().isEmpty()) {
						list.add(new FieldMessage("cliente", "cliente_logradouro_invalido"));						
					}
					if (cliDto.getUf() == null || cliDto.getUf().isEmpty()) {
						list.add(new FieldMessage("cliente", "cliente_uf_invalida"));						
					}
				}
			}
		}

		if (dto.getProduto() != null) {
			if (dto.getProduto().size() == 0) {
				list.add(new FieldMessage("produto", "produto_nao_enviado"));
			} else {
				if (empresa != null) {
					for (PedidoItemDto prodDto : dto.getProduto()) {
						ItemDto itemDto = itemDao.findByProduct(empresa.getId(), empresa.getEmpresa(),
								prodDto.getCodigo(), sys.getId());
						if (itemDto == null) {
							list.add(new FieldMessage("produto", "produto_nao_existe"));
						} else {
							Parametro par = parDao.findByEmpresa(empresa.getId());
							if (par.getBloqEstoque().equalsIgnoreCase("P")) {
								Estoque est = estDao.findByKey(empresa.getEmpresa(),
										prodDto.getCodigo());
								if (est == null) {
									list.add(new FieldMessage("produto", "produto_sem_estoque"));
								} else {
									Double disponivel = est.getQtdLiberada() - est.getQtdReservada();
									if (disponivel < prodDto.getQuantidade()) {
										list.add(new FieldMessage("produto", "produto_sem_estoque"));										
									}
								}
							}
						}
						if (prodDto.getQuantidade() == null || prodDto.getQuantidade() <= 0) {
							list.add(new FieldMessage("produto", "produto_sem_quantidade"));
						}
						if (prodDto.getPreUnit() == null || prodDto.getPreUnit() < 0) {
							list.add(new FieldMessage("produto", "produto_sem_preco"));
						}
						if (prodDto.getDatEntrega() == null || prodDto.getDatEntrega().isEmpty()) {
							list.add(new FieldMessage("produto", "produto_sem_dat_entrega"));
						}			
					}
				}
			}
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(
					e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		
		return list.isEmpty();

	}

}
