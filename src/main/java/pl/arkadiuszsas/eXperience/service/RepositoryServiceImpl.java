package pl.arkadiuszsas.eXperience.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositoryServiceImpl implements RepositoryService {

	@Autowired
	JsonReaderService jsonReaderService;
	
	private Map<String, String> repositoryInfo = new LinkedHashMap<String, String>();
	
	@Override
	public Map<String, String> repositoryInfo(String username) {
		repositoryInfo.put("name", jsonReaderService.readRepositoryInfo(username).get(0).getName());		
		return repositoryInfo;
	}

}
