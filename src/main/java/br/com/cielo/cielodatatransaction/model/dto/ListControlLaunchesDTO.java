package br.com.cielo.cielodatatransaction.model.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
/**
 * Classe de mapeamento de ListControlLaunchesDTO.
 * @author  Josafá Souza Santos
 * @since   2019-04-01
 * @version 1.0.0
 */
@Getter
@Setter
public class ListControlLaunchesDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("lancamentoContaCorrenteCliente")
	private CurrentCustomerAccountLaunchDTO currentCustomerAccountLaunchDTO;
	//dateEffective
	@JsonProperty("dataEfetivaLancamento")
	private String dateEffectiveLauche;
	
	@JsonProperty("dataLancamentoContaCorrenteCliente")
	private String dateCustomerAccountCurrentRelease;
	
	@JsonProperty("numeroEvento")
	private Long eventNumber;
	
	@JsonProperty("descricaoGrupoPagamento")
	private String descriptionPaymentGroup;
	
	@JsonProperty("codigoIdentificadorUnico")
	private String codeIdentifierUnique;
	
	@JsonProperty("nomeBanco")
	private String bankName;
	
	@JsonProperty("quantidadeLancamentoRemessa")
	private Long deliveryQuantity;
	
	@JsonProperty("numeroRaizCNPJ")
	private String numberRootCNPJ;
	
	@JsonProperty("numeroSufixoCNPJ")
	private String numberSufixCNPJ;
	
	@JsonProperty("valorLancamentoRemessa")
	private Long valueShipment;
	
	@JsonProperty("dateLancamentoContaCorrenteCliente")
	private Long dateCustomerAccountCurrentReleaseMs;
	
	@JsonProperty("dateEfetivaLancamento")
	private Long dateEffectiveLaucheMs;
}
