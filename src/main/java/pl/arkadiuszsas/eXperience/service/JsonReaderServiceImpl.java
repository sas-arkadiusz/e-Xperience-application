package pl.arkadiuszsas.eXperience.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.arkadiuszsas.eXperience.repository.RepositoryInfo;

@Component
public class JsonReaderServiceImpl implements JsonReaderService {

	private ObjectMapper objectMapper = new ObjectMapper();
	private URL jsonSource = null;
	private RepositoryInfo[] repositoryInfo = null;

	@Override
	public RepositoryInfo[] readRepositoryInfo(String username) {
		try {
			jsonSource = new URL("https://api.github.com/users/" + username + "/repos?per_page=1&sort=pushed");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		try {
			repositoryInfo = objectMapper.readValue(jsonSource, RepositoryInfo[].class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return repositoryInfo;
	}

}
