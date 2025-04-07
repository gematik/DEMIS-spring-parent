package de.gematik.demis;

/*-
 * #%L
 * spring-parent
 * %%
 * Copyright (C) 2025 gematik GmbH
 * %%
 * Licensed under the EUPL, Version 1.2 or - as soon they will be approved by the
 * European Commission – subsequent versions of the EUPL (the "Licence").
 * You may not use this work except in compliance with the Licence.
 * 
 * You find a copy of the Licence in the "Licence" file or at
 * https://joinup.ec.europa.eu/collection/eupl/eupl-text-eupl-12
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either expressed or implied.
 * In case of changes by gematik find details in the "Readme" file.
 * 
 * See the Licence for the specific language governing permissions and limitations under the Licence.
 * 
 * *******
 * 
 * For additional notes and disclaimer from gematik and in case of changes by gematik find details in the "Readme" file.
 * #L%
 */

import static java.nio.file.Files.createDirectories;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

@Slf4j
@SpringBootTest(webEnvironment = RANDOM_PORT)
public abstract class AbstractOpenApiSpecDownloaderTest {

  @LocalServerPort private int port;
  @Autowired private TestRestTemplate restTemplate;

  @Value("#{systemProperties.openapi_generator_inputSpec}")
  private String openapiSpecPath;

  @Value("${springdoc.api-docs.path:/v3/api-docs}")
  private String springdocApidocsPath;

  @Test
  void startAppAndRetrieveOpenApiSpec() {
    // when
    ResponseEntity<String> response =
        restTemplate.getForEntity(
            "http://localhost:" + port + springdocApidocsPath + ".yaml", String.class);
    // then
    assertThat(response.getStatusCode())
        .matches(HttpStatusCode::is2xxSuccessful, "Status code must be a 2xx code");
    String openapiSpec = response.getBody();
    assertThat(openapiSpec).isNotEmpty();

    log.info("OpenAPI spec will be saved to: {}", openapiSpecPath);
    try {
      createDirectories(Paths.get(openapiSpecPath).getParent());
    } catch (IOException e) {
      throw new RuntimeException("failed to create openapi spec path", e);
    }

    try (FileOutputStream fout = new FileOutputStream(openapiSpecPath)) {
      fout.write(openapiSpec.getBytes());
    } catch (IOException e) {
      throw new RuntimeException("failed to save generated openapi spec", e);
    }
  }
}
