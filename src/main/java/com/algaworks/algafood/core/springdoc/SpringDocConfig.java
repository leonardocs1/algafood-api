package com.algaworks.algafood.core.springdoc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import com.algaworks.algafood.api.exceptionhandler.Problem;

import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.oas.models.tags.Tag;

@Configuration
@SecurityScheme(name = "security_auth", 
				type = SecuritySchemeType.OAUTH2,
				flows = @OAuthFlows(authorizationCode = @OAuthFlow(
						authorizationUrl = "${springdoc.oAuthFlow.authorizationUrl}",
						tokenUrl = "${springdoc.oAuthFlow.tokenUrl}",
						scopes = {
								@OAuthScope(name = "READ", description = "read scope"),
								@OAuthScope(name = "WRITE", description = "write scope")
						}
					)))
public class SpringDocConfig {
	
	private static final String badRequestResponse = "BadRequestResponse";
	private static final String notFoundResponse = "NotFoundResponse";
	private static final String notAcceptableResponse = "NotAcceptableResponse";
	private static final String internalServerErrorResponse = "InternalServerErrorResponse";


	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI()
						.info(new Info()
								.title("AlgaFood API")
								.version("v1")
								.description("REST API do AlgaFood")
								.license(new License().name("Apache 2.0").url("http://springdoc.com")))
						.externalDocs(new ExternalDocumentation()
								.description("AlgaWorks")
								.url("https://algaworks.com"))
						.tags(Arrays.asList(
								new Tag().name("Cidades").description("Gerencia as cidades"),
								new Tag().name("Grupos").description("Gerencia os grupos"),
								new Tag().name("Cozinhas").description("Gerencia as cozinhas"),
								new Tag().name("Pedidos").description("Gerencia os pedidos")))
						.components(new Components().schemas(gerarSchemas()).responses(gerarReponses()
					));
	}

	@Bean
    public OpenApiCustomiser openApiCustomiser() {
    	return openApi -> {
    		openApi.getPaths()
    			.values()
    			.forEach(pathItem -> pathItem.readOperationsMap()
    					.forEach((httpMethod, operation) -> {
    						ApiResponses responses = operation.getResponses();
    						switch (httpMethod) {
    							case GET:
	    							responses.addApiResponse("404", new ApiResponse().$ref(notFoundResponse));
	    							responses.addApiResponse("406", new ApiResponse().$ref(notAcceptableResponse));
	    							responses.addApiResponse("500", new ApiResponse().$ref(internalServerErrorResponse));
	    							break;
    							case POST:
    								responses.addApiResponse("400", new ApiResponse().$ref(badRequestResponse));
    								responses.addApiResponse("500", new ApiResponse().$ref(internalServerErrorResponse));
    								break;
    							case PUT:
    								responses.addApiResponse("400", new ApiResponse().$ref(badRequestResponse));
    								responses.addApiResponse("404", new ApiResponse().$ref(notFoundResponse));
    								responses.addApiResponse("500", new ApiResponse().$ref(internalServerErrorResponse));
    								break;
    							case DELETE:
	    							responses.addApiResponse("404", new ApiResponse().$ref(notFoundResponse));
	    							responses.addApiResponse("500", new ApiResponse().$ref(internalServerErrorResponse));
	    							break;
	    						default:
	    							break;
    						}
    					})
    			);
    			
    	};
    }
    
    @SuppressWarnings("rawtypes")
	private Map<String, Schema> gerarSchemas() {
    	final Map<String, Schema> schemaMap = new HashMap<>();
    	
    	Map<String, Schema> problemSchema = ModelConverters.getInstance().read(Problem.class);
    	Map<String, Schema> problemObjectSchema = ModelConverters.getInstance().read(Problem.Object.class);
    	
    	schemaMap.putAll(problemSchema);
    	schemaMap.putAll(problemObjectSchema);
    	
    	return schemaMap;
    }
    
    private Map<String, ApiResponse> gerarReponses() {
		
    	final Map<String, ApiResponse> apiResponseMap = new HashMap<>();
    	
    	Content content = new Content()
    			.addMediaType(MediaType.APPLICATION_JSON_VALUE, 
    					new io.swagger.v3.oas.models.media.MediaType().schema(new Schema<Problem>().$ref("Problema")));
    	
    	apiResponseMap.put(badRequestResponse, new ApiResponse().description("Requisição inválida").content(content));
    	apiResponseMap.put(notFoundResponse, new ApiResponse().description("Recurso não encontrado").content(content));
    	apiResponseMap.put(notAcceptableResponse, new ApiResponse().description("Recurso não possui representação que poderia ser aceita pelo consumidor").content(content));
		apiResponseMap.put(internalServerErrorResponse, new ApiResponse().description("Erro interno do servidor").content(content));
    	
    	return apiResponseMap;
	}
    
}