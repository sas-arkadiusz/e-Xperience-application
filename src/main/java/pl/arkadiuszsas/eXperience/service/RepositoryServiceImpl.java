package pl.arkadiuszsas.eXperience.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.arkadiuszsas.eXperience.repository.RepositoryInfo;

@Component
public class RepositoryServiceImpl implements RepositoryService {

	@Autowired
	JsonReaderService jsonReaderService;
	
	private Map<String, String> repositoryInfo = new LinkedHashMap<String, String>();
	private RepositoryInfo[] repositories = null;
	
	@Override
	public Map<String, String> repositoryInfo(String username) {
		repositories = jsonReaderService.readRepositoryInfo(username);
		repositoryInfo.put("name", repositories[0].getName());		
		return repositoryInfo;
	}

}
