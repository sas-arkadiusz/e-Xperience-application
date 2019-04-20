package pl.arkadiuszsas.eXperience.service;

import java.util.Map;

public interface RepositoryService {
	
	/**
	 * Allows to get data about repository from read JSON file.
	 * 
	 * @return map that contains data about latest modified repository name
	 */
	public Map<String, String> repositoryInfo(String username);
}
