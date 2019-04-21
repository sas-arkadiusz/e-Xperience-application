package pl.arkadiuszsas.eXperience.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.arkadiuszsas.eXperience.service.RepositoryService;

@RestController
public class RepositoryController {

	@Autowired
	RepositoryService repositoryService;
	
	@Value("${repository.username}")
	private String requestedUsername;
	
	/**
	 * Allows to display information about latest modified repository in JSON format.
	 * Usage: http://localhost:8090/latestModifiedRepository
	 * 
	 * @return all latest modified repository values specified in <i>RepositoryInfo</i> class.
	 */
	@GetMapping("/latestModifiedRepository")
	public Map<String, String> lastestModifiedRepository() {
		return repositoryService.repositoryInfo(requestedUsername);
	}
	
}
