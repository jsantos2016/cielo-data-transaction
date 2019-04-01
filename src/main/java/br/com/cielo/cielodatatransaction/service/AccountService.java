package br.com.cielo.cielodatatransaction.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.cielo.cielodatatransaction.model.dto.LaunchAccountLegacyDTO;
import br.com.cielo.cielodatatransaction.model.entity.LauncheResponse;
import br.com.cielo.cielodatatransaction.model.entity.RequestResponse;
import br.com.cielo.cielodatatransaction.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Classe responsável por tratar os dados retornados do sistema legado.
 * @author Josafá Souza Santos
 * @since
 * @version
 */
@Slf4j
@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	/**
	 * Pega os dados de lançamentos de sistema legado.
	 * @return RequestResponse retorna o HttpStatus e o objeto mapeado de retorno.
	 */
	public RequestResponse getLaunchAccountLegacy() {
		log.debug("[AccountService] Init getLaunchAccountLegacy()");
		RequestResponse response = new RequestResponse();
		
		try {
			LaunchAccountLegacyDTO launchAccountLegacy = accountRepository.getLaunchAccountLegacy();

			response.setStatusCode(HttpStatus.OK.value()); 
			response.setStatus(HttpStatus.OK);
			response.setResponse(launchAccountLegacy);
			
		} catch (JsonParseException e) {
			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setResponse("JsonParseException: " + e.getMessage());			
			log.error("[AccountService] JsonParseException: ", e.getMessage());
		} catch (JsonMappingException e) {
			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setResponse("JsonMappingException: " + e.getMessage());
			log.error("[AccountService] JsonMappingException: ", e.getMessage());
		} catch (IOException e) {
			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setResponse("IOException: " + e.getMessage());
			log.error("[AccountService] I/OException: ", e.getMessage());
		}
		return response;
	}
	/**
	 * Pega dados de lançamentos de conta corrente cliente.
	 * @return RequestResponse retorna o HttpStatus e o objeto mapeado de retorno.
	 */	
	public RequestResponse getExtractLaunches() {
		log.debug("[AccountService] Init getExtractLaunches()");
		RequestResponse response = new RequestResponse();
		
		try {
			LaunchAccountLegacyDTO launchAccountLegacy = accountRepository.getLaunchAccountLegacy();

			List<LauncheResponse> listLaunches = new ArrayList<LauncheResponse>();
			//Data do lançamento | Descrição | Número      | Situação | Data de confirmação | Dados bancários                    | Valor final
			//18/11/2016         | Regular   | 67210807400 | Pago     | 18/11/2016          | BANCO ABCD S.A Ag 12 CC 0001231234 | R$ 28.714,00
			launchAccountLegacy.getListControlLaunches().forEach(launche -> {
				LauncheResponse launchesDetail = new LauncheResponse();
				launchesDetail.setDateLaunche(launche.getDateCustomerAccountCurrentRelease());
				launchesDetail.setDescription(launche.getCurrentCustomerAccountLaunchDTO().getNameTypeOperation());
				launchesDetail.setShippingNumberBank(launche.getCurrentCustomerAccountLaunchDTO().getShippingNumberBank());
				launchesDetail.setSituation(launche.getCurrentCustomerAccountLaunchDTO().getNameLocationShipping());
				launchesDetail.setDateConfirmation(launche.getDateEffectiveLauche());
				launchesDetail.setBankName(launche.getBankName());
				launchesDetail.setEndValue(BigDecimal.valueOf(launche.getValueShipment()));				
				listLaunches.add(launchesDetail);
			});

			response.setStatusCode(HttpStatus.OK.value()); 
			response.setStatus(HttpStatus.OK);
			response.setResponse(listLaunches);
		} catch (JsonParseException e) {
			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setResponse("JsonParseException: " + e.getMessage());			
			log.error("[AccountService] JsonParseException: ", e.getMessage());
		} catch (JsonMappingException e) {
			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setResponse("JsonMappingException: " + e.getMessage());
			log.error("[AccountService] JsonMappingException: ", e.getMessage());
		} catch (IOException e) {
			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setResponse("IOException: " + e.getMessage());
			log.error("[AccountService] I/OException: ", e.getMessage());
		}
		return response;
	}
}
