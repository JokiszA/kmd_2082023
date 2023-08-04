package com.pivovarit.rental;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@AutoConfigureStubRunner(
    stubsMode = StubRunnerProperties.StubsMode.LOCAL,
    ids = "com.movies.descriptions:movie-descriptions:+:stubs:8090"
)
public class MovieDescriptionsContractTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RestTemplateBuilder restTemplate;

    @Test
    void shouldRetrieveDescriptions() throws Exception {
        HttpMovieDescriptionsRepository client = new HttpMovieDescriptionsRepository("http://localhost:8090", restTemplate.build());

        assertThat(client.getByMovieId(new MovieId(1))).isNotEmpty();
    }

}
