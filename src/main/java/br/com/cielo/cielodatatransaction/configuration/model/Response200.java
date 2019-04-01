package br.com.cielo.cielodatatransaction.configuration.model;

import org.springframework.http.HttpStatus;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * Classe modelo do objeto com HttpStatus 200.
 * @author  Josafá Souza Santos
 * @since   2019-04-01
 * @version 1.0.0
 */
@ApiModel(value="Response200", description="Modelo do objeto de resposta quando 200 - OK.")
public class Response200 {
	@ApiModelProperty(value = "Número do status code.", position = 1, allowableValues = "200")
	public int statusCode;
	
	@ApiModelProperty(value = "Representação do status.", position = 2, allowableValues = "OK")
	public HttpStatus status;
	  
	@ApiModelProperty(value = "Objeto de resposta.", position = 3)
	public Object response;
}
