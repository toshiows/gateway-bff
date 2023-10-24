package org.br.mineradora.client;

import org.br.mineradora.dto.ProposalDatailsDTO;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.quarkus.oidc.token.propagation.reactive.AccessTokenRequestReactiveFilter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/api/proposal")
@RegisterRestClient
@RegisterProvider(AccessTokenRequestReactiveFilter.class)
@ApplicationScoped
public interface ProposalRestClient {

	@GET
	@Path("/{id}")
	ProposalDatailsDTO getProposalDetailsById(@PathParam("id") long proposalId);
	
	@POST
	Response createProposal(ProposalDatailsDTO proposalDetails);
	
	@DELETE
	@Path("/{id}")
	Response removeProposal(@PathParam("id") long id);
}
