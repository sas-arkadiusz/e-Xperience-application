package pl.arkadiuszsas.eXperience.service;

import pl.arkadiuszsas.eXperience.repository.RepositoryInfo;

public interface JsonReaderService {
	
	/**
	 * Reads data in JSON format from GitHub API.
	 * 
	 * @param 	username	name of the user for whom the latest modified repository information should be returned
	 * @return	all declared values from <i>RepositoryInfo</i> for latest modified repository in JSON format
	 */
	public RepositoryInfo[] readRepositoryInfo(String username);
}
