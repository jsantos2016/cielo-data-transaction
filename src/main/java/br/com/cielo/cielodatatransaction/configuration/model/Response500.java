package br.com.cielo.cielodatatransaction.configuration.model;

import org.springframework.http.HttpStatus;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * Classe modelo do objeto com HttpStatus 500.
 * @author  Josafá Souza Santos
 * @since   2019-04-01
 * @version 1.0.0
 */
@ApiModel(value="Response500", description="Modelo do objeto de resposta quando 500 - Internal server error.")
public class Response500 {

	@ApiModelProperty(value = "Número do status code.", position = 1, allowableValues = "500")
	public int statusCode;
	
	@ApiModelProperty(value = "Representação do status.", position = 2, allowableValues = "Internal server error")
	public HttpStatus status;
	
	@ApiModelProperty(value = "Objeto de resposta.", position = 3)
	public Object response;
}
