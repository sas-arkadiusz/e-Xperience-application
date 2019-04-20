package pl.arkadiuszsas.eXperience.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.arkadiuszsas.eXperience.repository.RepositoryInfo;

@Component
public class JsonReaderServiceImpl implements JsonReaderService {

	private ObjectMapper objectMapper = new ObjectMapper();
	private URL jsonSource = null;

	@Override
	public ArrayList<RepositoryInfo> readRepositoryInfo(String username) {
		try {
			jsonSource = new URL("https://api.github.com/users/" + username + "/repos?per_page=1&sort=pushed");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		try {
	        TypeReference<ArrayList<RepositoryInfo>> typeReference = new TypeReference<>() {};
	        return objectMapper.readValue(jsonSource, typeReference);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return null;
	}

}
