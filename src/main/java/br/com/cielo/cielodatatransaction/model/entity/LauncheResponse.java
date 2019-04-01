package br.com.cielo.cielodatatransaction.model.entity;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
/**
 * Classe responsável por fornecer dados de lançamento como objeto de resposta.
 * @author  Josafá Souza Santos
 * @since   2019-04-01
 * @version 1.0.0
 */
@Getter
@Setter
public class LauncheResponse {
	String dateLaunche;
	String description;
	Long shippingNumberBank;
	String situation;
	String dateConfirmation;
	String bankName;
	BigDecimal endValue;
}
