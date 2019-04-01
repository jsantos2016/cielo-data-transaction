package br.com.cielo.cielodatatransaction.repository;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.cielo.cielodatatransaction.model.dto.LaunchAccountLegacyDTO;
import lombok.extern.slf4j.Slf4j;
/**
 * Classe responsável por mapear dados de sistemas legados.
 * @author  Josafá Souza Santos
 * @since   2019-04-01
 * @version 1.0.0
 */
@Slf4j
@Repository
public class AccountRepository {
	/**
	 * Mapea dados de sistema legado em objeto.
	 * @return LaunchAccountLegacyDTO retorna a classe mapeada.
	 */
	public LaunchAccountLegacyDTO getLaunchAccountLegacy() throws JsonParseException, JsonMappingException, IOException  {
		log.debug("[AccountRepository] getLaunchAccountLegacy()");
		ObjectMapper mapper = new ObjectMapper();

		LaunchAccountLegacyDTO launchAccountLegacy = mapper.readValue(new File("src/main/resources/lancamento-conta-legado.json"), LaunchAccountLegacyDTO.class);

		return launchAccountLegacy;
	}
}