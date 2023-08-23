package com.algaworks.algafood.core.openapi;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLStreamHandler;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Links;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.context.request.ServletWebRequest;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.CidadeModel;
import com.algaworks.algafood.api.model.CozinhaModel;
import com.algaworks.algafood.api.model.PedidoResumoModel;
import com.algaworks.algafood.api.openapi.model.CidadesModelOpenApi;
import com.algaworks.algafood.api.openapi.model.CozinhasModelOpenApi;
import com.algaworks.algafood.api.openapi.model.LinksModelOpenApi;
import com.algaworks.algafood.api.openapi.model.PageableModelOpenApi;
import com.algaworks.algafood.api.openapi.model.PedidosResumoModelOpenApi;
import com.fasterxml.classmate.TypeResolver;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RepresentationBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Response;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.json.JacksonModuleRegistrar;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@Import(BeanValidatorPluginsConfiguration.class)
public class SpringFoxConfig {

	@Bean
	public Docket apiDocket() {
		
		var typeResolver = new TypeResolver(); 
		
		return new Docket(DocumentationType.OAS_30)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.algaworks.algafood.api"))
				.build()
			.useDefaultResponseMessages(false)
			.globalResponses(HttpMethod.GET, globalGetResponseMessages())
			.globalResponses(HttpMethod.POST, globalPostResponseMessages())
			.globalResponses(HttpMethod.PUT, globalPutResponseMessages())
			.globalResponses(HttpMethod.DELETE, globalDeleteMessages())
			.additionalModels(typeResolver.resolve(Problem.class))
			.ignoredParameterTypes(ServletWebRequest.class, 
					URL.class, URI.class, URLStreamHandler.class, 
					Resource.class, File.class, InputStream.class)
			.directModelSubstitute(Pageable.class, PageableModelOpenApi.class)
			.directModelSubstitute(Links.class, LinksModelOpenApi.class)
			.alternateTypeRules(AlternateTypeRules.newRule(
					typeResolver.resolve(Page.class, CozinhaModel.class),
					CozinhasModelOpenApi.class
					))
			.alternateTypeRules(AlternateTypeRules.newRule(
					typeResolver.resolve(CollectionModel.class, CidadeModel.class),
					CidadesModelOpenApi.class
					))
			.alternateTypeRules(AlternateTypeRules.newRule(
					typeResolver.resolve(Page.class, PedidoResumoModel.class),
					PedidosResumoModelOpenApi.class
					))
			.apiInfo(apiInfo())
			.tags(new Tag("Cidades", "Gerencia as cidades"))
			.tags(new Tag("Grupos", "Gerencia os grupos de usuários"))
			.tags(new Tag("Cozinhas", "Gerencia as cozinhas"))
			.tags(new Tag("Formas de pagamento", "Gerencia as formas de pagamento"))
			.tags(new Tag("Pedidos", "Gerencia os pedidos"))
			.tags(new Tag("Restaurantes", "Gerencia os restaurantes"))
			.tags(new Tag("Estados", "Gerencia os estados"))
			.tags(new Tag("Produtos", "Gerencia dos produtos de restaurantes"))
			.tags(new Tag("Usuarios", "Gerencia os usuários"))
			.tags(new Tag("Estatísticas", "Estatísticas"))
			.tags(new Tag("Permissões", "Gerencia as permissões"));
	}
	
	private List<Response> globalGetResponseMessages() {
		return Arrays.asList(
				new ResponseBuilder()
					.code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
					.description("Erro interno do servidor")
					.representation(MediaType.APPLICATION_JSON)
					.apply(getProblemaModelReference())
					.build(),
				new ResponseBuilder()
					.code(String.valueOf(HttpStatus.NOT_ACCEPTABLE.value()))
					.description("Recurso não possui representação que pode ser aceita pelo consumidor")
					.build());
	}
	
	private List<Response> globalPostResponseMessages() {
		return Arrays.asList(
				new ResponseBuilder()
					.code(String.valueOf(HttpStatus.BAD_REQUEST.value()))
					.description("Requisição não é válida")
					.representation(MediaType.APPLICATION_JSON)
					.apply(getProblemaModelReference())
					.build(),
				new ResponseBuilder()
					.code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
					.description("Erro interno do servidor")
					.representation(MediaType.APPLICATION_JSON)
					.apply(getProblemaModelReference())
					.build(),
				new ResponseBuilder()
					.code(String.valueOf(HttpStatus.NOT_ACCEPTABLE.value()))
					.description("Recurso não possui representação que pode ser aceita pelo consumidor")
					.build(),
				new ResponseBuilder()
					.code(String.valueOf(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()))
					.description("Requisição não aceita, pois o corpo está em um formato não suportado")
					.representation(MediaType.APPLICATION_JSON)
					.apply(getProblemaModelReference())
					.build());
				
	}
	
	private List<Response> globalPutResponseMessages() {
		return Arrays.asList(
				new ResponseBuilder()
					.code(String.valueOf(HttpStatus.BAD_REQUEST.value()))
					.description("Requisição não é válida")
					.representation(MediaType.APPLICATION_JSON)
					.apply(getProblemaModelReference())
					.build(),
				new ResponseBuilder()
					.code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
					.description("Erro interno do servidor")
					.representation(MediaType.APPLICATION_JSON)
					.apply(getProblemaModelReference())
					.build(),
				new ResponseBuilder()
					.code(String.valueOf(HttpStatus.NOT_ACCEPTABLE.value()))
					.description("Recurso não possui representação que pode ser aceita pelo consumidor")
					.build(),
				new ResponseBuilder()
					.code(String.valueOf(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()))
					.description("Requisição não aceita, pois o corpo está em um formato não suportado")
					.representation(MediaType.APPLICATION_JSON)
					.apply(getProblemaModelReference())
					.build());
				
	}
	
	private List<Response> globalDeleteMessages() {
		return Arrays.asList(
				new ResponseBuilder()
					.code(String.valueOf(HttpStatus.BAD_GATEWAY.value()))
					.description("Requisição não é válida")
					.representation(MediaType.APPLICATION_JSON)
					.apply(getProblemaModelReference())
					.build(),
				new ResponseBuilder()
					.code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
					.description("Erro interno do servidor")
					.representation(MediaType.APPLICATION_JSON)
					.apply(getProblemaModelReference())
					.build()
				);
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("AlgaFood API")
				.description("API aberta para clientes e restaurantes")
				.version("1")
				.contact(new Contact("AlgaWorks", "https://www.algaworks.com", "contato@algaworks.com"))
				.build();
	}
	
	private Consumer<RepresentationBuilder> getProblemaModelReference() {
	    return r -> r.model(m -> m.name("Problema")
	            .referenceModel(ref -> ref.key(k -> k.qualifiedModelName(
	                    q -> q.name("Problema").namespace("com.algaworks.algafood.api.exceptionhandler")))));
	}
	
	@Bean
	public JacksonModuleRegistrar stringFoxJacksonConfig() {
		return objectMapper -> objectMapper.registerModule(new JavaTimeModule());
	}

}