/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.4.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bytechef.dione.integration.web.rest;

import com.bytechef.dione.integration.web.rest.model.IntegrationModel;
import com.bytechef.dione.integration.web.rest.model.PostIntegrationWorkflowRequestModel;
import com.bytechef.dione.integration.web.rest.model.PutIntegrationTagsRequestModel;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.http.codec.multipart.Part;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-03-01T11:43:15.780734+01:00[Europe/Zagreb]")
@Validated
@Tag(name = "integrations", description = "the integrations API")
public interface IntegrationsApi {

    /**
     * DELETE /integrations/{id} : Delete an integration.
     * Delete an integration.
     *
     * @param id The id of an integration. (required)
     * @return Successful operation. (status code 200)
     */
    @Operation(
        operationId = "deleteIntegration",
        summary = "Delete an integration.",
        description = "Delete an integration.",
        tags = { "integrations" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation.")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/integrations/{id}"
    )
    default Mono<ResponseEntity<Void>> deleteIntegration(
        @Parameter(name = "id", description = "The id of an integration.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id,
        @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        return result.then(Mono.empty());

    }


    /**
     * GET /integrations/{id} : Get an integration by id.
     * Get an integration by id.
     *
     * @param id The id of an integration. (required)
     * @return The integration object. (status code 200)
     */
    @Operation(
        operationId = "getIntegration",
        summary = "Get an integration by id.",
        description = "Get an integration by id.",
        tags = { "integrations" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The integration object.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = IntegrationModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/integrations/{id}",
        produces = { "application/json" }
    )
    default Mono<ResponseEntity<IntegrationModel>> getIntegration(
        @Parameter(name = "id", description = "The id of an integration.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id,
        @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"workflowIds\" : [ \"workflowIds\", \"workflowIds\" ], \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"description\" : \"description\", \"id\" : 1, \"category\" : { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 0, \"version\" : 6 }, \"version\" : 2, \"tags\" : [ { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 5, \"version\" : 5 }, { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 5, \"version\" : 5 } ] }";
                result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
                break;
            }
        }
        return result.then(Mono.empty());

    }


    /**
     * GET /integrations/categories : Get categories.
     * Get categories.
     *
     * @return The list of categories. (status code 200)
     */
    @Operation(
        operationId = "getIntegrationCategories",
        summary = "Get categories.",
        description = "Get categories.",
        tags = { "integrations" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The list of categories.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = com.bytechef.category.web.rest.model.CategoryModel.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/integrations/categories",
        produces = { "application/json" }
    )
    default Mono<ResponseEntity<Flux<com.bytechef.category.web.rest.model.CategoryModel>>> getIntegrationCategories(
        @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "[ { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 0, \"version\" : 6 }, { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 0, \"version\" : 6 } ]";
                result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
                break;
            }
        }
        return result.then(Mono.empty());

    }


    /**
     * GET /integrations/tags : Get integration tags.
     * Get integration tags.
     *
     * @return The list of integration tags. (status code 200)
     */
    @Operation(
        operationId = "getIntegrationTags",
        summary = "Get integration tags.",
        description = "Get integration tags.",
        tags = { "integrations" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The list of integration tags.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = com.bytechef.tag.web.rest.model.TagModel.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/integrations/tags",
        produces = { "application/json" }
    )
    default Mono<ResponseEntity<Flux<com.bytechef.tag.web.rest.model.TagModel>>> getIntegrationTags(
        @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "[ { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 5, \"version\" : 5 }, { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 5, \"version\" : 5 } ]";
                result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
                break;
            }
        }
        return result.then(Mono.empty());

    }


    /**
     * GET /integrations/{id}/workflows : Get workflows for particular integration.
     * Get workflows for particular integration.
     *
     * @param id The id of an integration. (required)
     * @return The updated integration object. (status code 200)
     */
    @Operation(
        operationId = "getIntegrationWorkflows",
        summary = "Get workflows for particular integration.",
        description = "Get workflows for particular integration.",
        tags = { "integrations" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The updated integration object.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = com.bytechef.atlas.web.rest.model.WorkflowModel.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/integrations/{id}/workflows",
        produces = { "application/json" }
    )
    default Mono<ResponseEntity<Flux<com.bytechef.atlas.web.rest.model.WorkflowModel>>> getIntegrationWorkflows(
        @Parameter(name = "id", description = "The id of an integration.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id,
        @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "[ { \"outputs\" : [ { \"key\" : \"{}\" }, { \"key\" : \"{}\" } ], \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"inputs\" : [ { \"key\" : \"{}\" }, { \"key\" : \"{}\" } ], \"lastModifiedBy\" : \"lastModifiedBy\", \"label\" : \"label\", \"version\" : 6, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"sourceType\" : \"CLASSPATH\", \"definition\" : \"definition\", \"id\" : \"id\", \"retry\" : 0, \"tasks\" : [ { \"node\" : \"node\", \"pre\" : [ null, null ], \"post\" : [ null, null ], \"name\" : \"name\", \"finalize\" : [ null, null ], \"label\" : \"label\", \"type\" : \"type\", \"parameters\" : { \"key\" : \"{}\" }, \"timeout\" : \"timeout\" }, { \"node\" : \"node\", \"pre\" : [ null, null ], \"post\" : [ null, null ], \"name\" : \"name\", \"finalize\" : [ null, null ], \"label\" : \"label\", \"type\" : \"type\", \"parameters\" : { \"key\" : \"{}\" }, \"timeout\" : \"timeout\" } ] }, { \"outputs\" : [ { \"key\" : \"{}\" }, { \"key\" : \"{}\" } ], \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"inputs\" : [ { \"key\" : \"{}\" }, { \"key\" : \"{}\" } ], \"lastModifiedBy\" : \"lastModifiedBy\", \"label\" : \"label\", \"version\" : 6, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"sourceType\" : \"CLASSPATH\", \"definition\" : \"definition\", \"id\" : \"id\", \"retry\" : 0, \"tasks\" : [ { \"node\" : \"node\", \"pre\" : [ null, null ], \"post\" : [ null, null ], \"name\" : \"name\", \"finalize\" : [ null, null ], \"label\" : \"label\", \"type\" : \"type\", \"parameters\" : { \"key\" : \"{}\" }, \"timeout\" : \"timeout\" }, { \"node\" : \"node\", \"pre\" : [ null, null ], \"post\" : [ null, null ], \"name\" : \"name\", \"finalize\" : [ null, null ], \"label\" : \"label\", \"type\" : \"type\", \"parameters\" : { \"key\" : \"{}\" }, \"timeout\" : \"timeout\" } ] } ]";
                result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
                break;
            }
        }
        return result.then(Mono.empty());

    }


    /**
     * GET /integrations : Get integrations.
     * Get integrations.
     *
     * @param categoryIds The list of the category ids used for filtering integrations. (optional)
     * @param tagIds The list of tag ids of used for filtering integrations. (optional)
     * @return The list of integrations. (status code 200)
     */
    @Operation(
        operationId = "getIntegrations",
        summary = "Get integrations.",
        description = "Get integrations.",
        tags = { "integrations" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The list of integrations.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = IntegrationModel.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/integrations",
        produces = { "application/json" }
    )
    default Mono<ResponseEntity<Flux<IntegrationModel>>> getIntegrations(
        @Parameter(name = "categoryIds", description = "The list of the category ids used for filtering integrations.", in = ParameterIn.QUERY) @Valid @RequestParam(value = "categoryIds", required = false) List<Long> categoryIds,
        @Parameter(name = "tagIds", description = "The list of tag ids of used for filtering integrations.", in = ParameterIn.QUERY) @Valid @RequestParam(value = "tagIds", required = false) List<Long> tagIds,
        @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "[ { \"workflowIds\" : [ \"workflowIds\", \"workflowIds\" ], \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"description\" : \"description\", \"id\" : 1, \"category\" : { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 0, \"version\" : 6 }, \"version\" : 2, \"tags\" : [ { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 5, \"version\" : 5 }, { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 5, \"version\" : 5 } ] }, { \"workflowIds\" : [ \"workflowIds\", \"workflowIds\" ], \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"description\" : \"description\", \"id\" : 1, \"category\" : { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 0, \"version\" : 6 }, \"version\" : 2, \"tags\" : [ { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 5, \"version\" : 5 }, { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 5, \"version\" : 5 } ] } ]";
                result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
                break;
            }
        }
        return result.then(Mono.empty());

    }


    /**
     * POST /integrations : Create a new integration.
     * Create a new integration.
     *
     * @param integrationModel  (required)
     * @return The integration object. (status code 200)
     */
    @Operation(
        operationId = "postIntegration",
        summary = "Create a new integration.",
        description = "Create a new integration.",
        tags = { "integrations" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The integration object.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = IntegrationModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/integrations",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default Mono<ResponseEntity<IntegrationModel>> postIntegration(
        @Parameter(name = "IntegrationModel", description = "", required = true) @Valid @RequestBody Mono<IntegrationModel> integrationModel,
        @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"workflowIds\" : [ \"workflowIds\", \"workflowIds\" ], \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"description\" : \"description\", \"id\" : 1, \"category\" : { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 0, \"version\" : 6 }, \"version\" : 2, \"tags\" : [ { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 5, \"version\" : 5 }, { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 5, \"version\" : 5 } ] }";
                result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
                break;
            }
        }
        return result.then(integrationModel).then(Mono.empty());

    }


    /**
     * POST /integrations/{id}/workflows : Create new workflow and adds it to an existing integration.
     * Create new workflow and adds it to an existing integration.
     *
     * @param id The id of an integration. (required)
     * @param postIntegrationWorkflowRequestModel  (required)
     * @return The updated integration object. (status code 200)
     */
    @Operation(
        operationId = "postIntegrationWorkflow",
        summary = "Create new workflow and adds it to an existing integration.",
        description = "Create new workflow and adds it to an existing integration.",
        tags = { "integrations" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The updated integration object.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = IntegrationModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/integrations/{id}/workflows",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default Mono<ResponseEntity<IntegrationModel>> postIntegrationWorkflow(
        @Parameter(name = "id", description = "The id of an integration.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id,
        @Parameter(name = "PostIntegrationWorkflowRequestModel", description = "", required = true) @Valid @RequestBody Mono<PostIntegrationWorkflowRequestModel> postIntegrationWorkflowRequestModel,
        @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"workflowIds\" : [ \"workflowIds\", \"workflowIds\" ], \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"description\" : \"description\", \"id\" : 1, \"category\" : { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 0, \"version\" : 6 }, \"version\" : 2, \"tags\" : [ { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 5, \"version\" : 5 }, { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 5, \"version\" : 5 } ] }";
                result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
                break;
            }
        }
        return result.then(postIntegrationWorkflowRequestModel).then(Mono.empty());

    }


    /**
     * PUT /integrations/{id} : Update an existing integration.
     * Update an existing integration.
     *
     * @param id The id of an integration. (required)
     * @param integrationModel  (required)
     * @return The updated integration object. (status code 200)
     */
    @Operation(
        operationId = "putIntegration",
        summary = "Update an existing integration.",
        description = "Update an existing integration.",
        tags = { "integrations" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The updated integration object.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = IntegrationModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/integrations/{id}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default Mono<ResponseEntity<IntegrationModel>> putIntegration(
        @Parameter(name = "id", description = "The id of an integration.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id,
        @Parameter(name = "IntegrationModel", description = "", required = true) @Valid @RequestBody Mono<IntegrationModel> integrationModel,
        @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"workflowIds\" : [ \"workflowIds\", \"workflowIds\" ], \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"description\" : \"description\", \"id\" : 1, \"category\" : { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 0, \"version\" : 6 }, \"version\" : 2, \"tags\" : [ { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 5, \"version\" : 5 }, { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 5, \"version\" : 5 } ] }";
                result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
                break;
            }
        }
        return result.then(integrationModel).then(Mono.empty());

    }


    /**
     * PUT /integrations/{id}/tags : Updates tags of an existing integration.
     * Updates tags of an existing integration.
     *
     * @param id The id of an integration. (required)
     * @param putIntegrationTagsRequestModel  (required)
     * @return Successful operation. (status code 200)
     */
    @Operation(
        operationId = "putIntegrationTags",
        summary = "Updates tags of an existing integration.",
        description = "Updates tags of an existing integration.",
        tags = { "integrations" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation.")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/integrations/{id}/tags",
        consumes = { "application/json" }
    )
    default Mono<ResponseEntity<Void>> putIntegrationTags(
        @Parameter(name = "id", description = "The id of an integration.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id,
        @Parameter(name = "PutIntegrationTagsRequestModel", description = "", required = true) @Valid @RequestBody Mono<PutIntegrationTagsRequestModel> putIntegrationTagsRequestModel,
        @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        return result.then(putIntegrationTagsRequestModel).then(Mono.empty());

    }

}
