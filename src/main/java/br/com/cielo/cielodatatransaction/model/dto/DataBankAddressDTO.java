package br.com.cielo.cielodatatransaction.model.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
/**
 * Classe de mapeamento de DataBankAddressDTO.
 * @author  Josafá Souza Santos
 * @since   2019-04-01
 * @version 1.0.0
 */
@Getter
@Setter
public class DataBankAddressDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("codigoBanco")
	private Integer bankCode;
	
	@JsonProperty("numeroAgencia")
	private Integer agencyNumber;
	
	@JsonProperty("numeroContaCorrente")
	private String currentAccountNumber;
}
