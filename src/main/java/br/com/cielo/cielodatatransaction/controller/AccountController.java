package br.com.cielo.cielodatatransaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cielo.cielodatatransaction.configuration.model.Response200;
import br.com.cielo.cielodatatransaction.configuration.model.Response500;
import br.com.cielo.cielodatatransaction.model.entity.RequestResponse;
import br.com.cielo.cielodatatransaction.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
/**
 * Classe responsável por fornecer os endpoints da URI /account.
 * @author  Josafá Souza Santos
 * @since   2019-04-01
 * @version 1.0.0
 */
@RestController
@Slf4j
@RequestMapping(value = "/account")
@Api(value = "Account")
@CrossOrigin(origins="*")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	/**
	 * Endpoint que retorna com todos os dados de lançamentos do legado.
	 * GET /launchAccountLegacy
	 * @return RequestResponse 
	 */
	@ApiOperation(value = "Endpoint com dados do legado.")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Ok", response = Response200.class),
		    @ApiResponse(code = 500, message = "Internal server error", response = Response500.class)
	})
	@GetMapping(value = "/launchAccountLegacy", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<RequestResponse> getLaunchAccountLegacy() {
		log.debug("[AccountController] GET /launchAccountLegacy");
		log.debug("[AccountController] getLaunchAccountLegacy()");
		
		RequestResponse responseRequest = accountService.getLaunchAccountLegacy();
		
		return ResponseEntity.status(responseRequest.getStatus()).body(responseRequest);
	}
	
	/**
	 * Endpoint que retorna apenas os dados de lançamentos.
	 * GET /extractLaunches
	 * @return RequestResponse
	 */
	@ApiOperation(value = "Endpoint extrato com os lançamentos.")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Ok", response = Response200.class),
		    @ApiResponse(code = 500, message = "Internal server error", response = Response500.class)
	})
	@GetMapping(value = "/extractLaunches", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<RequestResponse> getExtractLaunches() {
		log.debug("[AccountController] GET /extractLaunches");
		log.debug("[AccountController] getExtractLaunches()");
		
		RequestResponse responseRequest = accountService.getExtractLaunches();
		
		return ResponseEntity.status(responseRequest.getStatus()).body(responseRequest);
	}
}
