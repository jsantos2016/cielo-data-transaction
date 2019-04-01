package br.com.cielo.cielodatatransaction.model.entity;

import org.springframework.http.HttpStatus;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
/**
 * Classe responsável por fornecer dados tratados como objeto de resposta.
 * @author  Josafá Souza Santos
 * @since   2019-04-01
 * @version 1.0.0
 */
@Getter
@Setter
@ApiModel(value="RequestResponse", description="Modelo do objeto de resposta.")
public class RequestResponse {
	@ApiModelProperty(value = "Número do status code.")
	int statusCode;
	
	@ApiModelProperty(value = "Representação do status.")
	HttpStatus status;
	  
	@ApiModelProperty(value = "Objeto de resposta.")
	Object response;
}
