/*
 * Copyright (c) 2018 Couchbase, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.couchbase.client.core.config;

import com.couchbase.client.core.service.ServiceType;
import com.couchbase.client.core.utils.NetworkAddress;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(as = DefaultAlternateAddress.class)
public interface AlternateAddress {

    /**
     * The inet address of the node.
     *
     * @return the host address.
     */
    NetworkAddress hostname();

    /**
     * Contains the string representation from the hostname the
     * same way it is represented in the config.
     *
     * @return the raw hostname string as in the config.
     */
    String rawHostname();

    /**
     * The exposed non-ssl services.
     *
     * @return a map containing all services with ports.
     */
    Map<ServiceType, Integer> services();

    /**
     * The exposed ssl services.
     *
     * @return a map containing all services with secured ports.
     */
    Map<ServiceType, Integer> sslServices();

}
