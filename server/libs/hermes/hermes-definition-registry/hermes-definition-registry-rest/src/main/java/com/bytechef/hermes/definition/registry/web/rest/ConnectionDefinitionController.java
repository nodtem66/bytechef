
/*
 * Copyright 2021 <your company/name>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bytechef.hermes.definition.registry.web.rest;

import com.bytechef.autoconfigure.annotation.ConditionalOnApi;
import com.bytechef.hermes.definition.registry.service.ConnectionDefinitionService;
import com.bytechef.hermes.definition.registry.web.rest.model.ConnectionDefinitionBasicModel;
import com.bytechef.hermes.definition.registry.web.rest.model.ConnectionDefinitionModel;

import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Ivica Cardic
 */
@RestController
@ConditionalOnApi
@RequestMapping("${openapi.openAPIDefinition.base-path:}")
public class ConnectionDefinitionController implements ConnectionDefinitionsApi {

    private final ConnectionDefinitionService connectionDefinitionService;
    private final ConversionService conversionService;

    public ConnectionDefinitionController(
        ConnectionDefinitionService connectionDefinitionService, ConversionService conversionService) {

        this.connectionDefinitionService = connectionDefinitionService;
        this.conversionService = conversionService;
    }

    @Override
    public Mono<ResponseEntity<Flux<ConnectionDefinitionBasicModel>>> getComponentConnectionDefinitions(
        String componentName, ServerWebExchange exchange) {

        return Mono.just(
            ResponseEntity.ok(
                connectionDefinitionService.getConnectionDefinitionsMono(componentName)
                    .mapNotNull(connectionDefinitions -> connectionDefinitions.stream()
                        .map(connectionDefinition -> conversionService.convert(
                            connectionDefinition, ConnectionDefinitionBasicModel.class))
                        .toList())
                    .flatMapMany(Flux::fromIterable)));
    }

    @Override
    public Mono<ResponseEntity<ConnectionDefinitionModel>> getConnectionDefinition(
        String componentName, Integer componentVersion, ServerWebExchange exchange) {

        return connectionDefinitionService.getConnectionDefinitionMono(componentName, componentVersion)
            .mapNotNull(componentDefinition -> conversionService.convert(
                componentDefinition, ConnectionDefinitionModel.class))
            .map(ResponseEntity::ok);
    }

    @Override
    public Mono<ResponseEntity<Flux<ConnectionDefinitionBasicModel>>> getConnectionDefinitions(
        ServerWebExchange exchange) {

        return Mono.just(
            ResponseEntity.ok(
                connectionDefinitionService.getConnectionDefinitionsMono()
                    .mapNotNull(connectionDefinitions -> connectionDefinitions.stream()
                        .map(connectionDefinition -> conversionService.convert(
                            connectionDefinition, ConnectionDefinitionBasicModel.class))
                        .toList())
                    .flatMapMany(Flux::fromIterable)));
    }
}
