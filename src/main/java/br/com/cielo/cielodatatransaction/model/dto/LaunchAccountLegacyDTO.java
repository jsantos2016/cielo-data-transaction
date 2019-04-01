package br.com.cielo.cielodatatransaction.model.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
/**
 * Classe de mapeamento de LaunchAccountLegacyDTO.
 * @author  Josafá Souza Santos
 * @since   2019-04-01
 * @version 1.0.0
 */
@Getter
@Setter
public class LaunchAccountLegacyDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@JsonProperty("totalControleLancamento")
	private TotalControlLaunchDTO totalControlLaunch;
	
	@JsonProperty("listaControleLancamento")
	private List<ListControlLaunchesDTO> listControlLaunches = null;
	
	@JsonProperty("indice")
	private Integer index;
	
	@JsonProperty("tamanhoPagina")
	private Integer pageSize;
	
	@JsonProperty("totalElements")
	private Integer totalElements;
}