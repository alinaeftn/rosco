/*
 * Copyright 2019 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.spinnaker.rosco.api;

import groovy.util.logging.Slf4j;
import java.net.URI;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;

@Slf4j
@Configuration
public class VaultConfig extends AbstractVaultConfiguration {

  // @Value("${vault.endpoint}")
  private String vaultEndpoint = "";

  // @Value("${vault.token}")
  private String vaultToken = "";

  /** Specify an endpoint for connecting to Vault. */
  @Override
  public VaultEndpoint vaultEndpoint() {
    return new VaultEndpoint().from(URI.create(vaultEndpoint));
  }

  /**
   * Configure a client authentication. Please consider a more secure authentication method for
   * production use.
   */
  @Override
  public ClientAuthentication clientAuthentication() {
    return new TokenAuthentication(vaultToken);
  }
}
