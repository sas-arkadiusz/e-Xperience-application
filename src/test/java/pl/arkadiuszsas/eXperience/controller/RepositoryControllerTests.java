package pl.arkadiuszsas.eXperience.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import pl.arkadiuszsas.eXperience.service.RepositoryService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class RepositoryControllerTests {

	@LocalServerPort
	private int port;
	
	@Autowired
    private MockMvc mockMvc;

	@Autowired
	private RepositoryController repositoryController;
	
	@Autowired
	RepositoryService repositoryService;
	
    @Test
    public void contexLoads() throws Exception {
        assertThat(repositoryController).isNotNull();
    }
    
    @Test
    public void properStatusAndJsonFormat() throws Exception {
    	this.mockMvc.perform(get("/latestModifiedRepository"))
    		.andDo(print())
    		.andExpect(status().isOk())
    		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }
    
    @Test
    public void returnsExactlyOneRepository() throws Exception {
    	assertTrue(this.repositoryController.lastestModifiedRepository().size() == 1);
    }
    
    @Test
    public void returnsRespositoryName() throws Exception {
    	MvcResult mvcResult = this.mockMvc.perform(get("/latestModifiedRepository")).andReturn();
    	assertTrue(mvcResult.getResponse().getContentAsString().contains("{\"name\":"));
    }
}
