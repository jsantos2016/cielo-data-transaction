package br.com.cielo.cielodatatransaction.model.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
/**
 * Classe de mapeamento de CurrentCustomerAccountLaunchDTO.
 * @author  Josafá Souza Santos
 * @since   2019-04-01
 * @version 1.0.0
 */
@Getter
@Setter
public class CurrentCustomerAccountLaunchDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("numeroRemessaBanco")
	private Long shippingNumberBank;
	
	@JsonProperty("dadosAnaliticoLancamentoFinanceiroCliente")
	private List<Object> analyticalDataFinancialReleaseCustomer = null;
	
	@JsonProperty("nomeSituacaoRemessa")
	private String nameLocationShipping;
	
	@JsonProperty("dadosDomicilioBancario")
	private DataBankAddressDTO dataBankAddress;
	
	@JsonProperty("nomeTipoOperacao")
	private String nameTypeOperation;
}
