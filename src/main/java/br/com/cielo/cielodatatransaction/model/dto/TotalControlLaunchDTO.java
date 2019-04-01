package br.com.cielo.cielodatatransaction.model.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
/**
 * Classe de mapeamento de TotalControlLaunchDTO.
 * @author  Josafá Souza Santos
 * @since   2019-04-01
 * @version 1.0.0
 */
@Getter
@Setter
public class TotalControlLaunchDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("quantidadeLancamentos")
	private Integer quantityLaunches;
	
	@JsonProperty("quantidadeRemessas")
	private Integer quantityShipments;
	
	@JsonProperty("valorLancamentos")
	private Double valueLaunches;
}
