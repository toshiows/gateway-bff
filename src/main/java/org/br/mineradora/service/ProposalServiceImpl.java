package org.br.mineradora.service;

import org.br.mineradora.client.ProposalRestClient;
import org.br.mineradora.dto.ProposalDatailsDTO;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class ProposalServiceImpl implements ProposalService {

	@Inject
	@RestClient
	ProposalRestClient proposalRestClient;
	
	@Override
	public ProposalDatailsDTO getProposalDetailsById(long proposalId) {
		return proposalRestClient.getProposalDetailsById(proposalId);
	}

	@Override
	public Response createProposal(ProposalDatailsDTO proposalDeatils) {
		return proposalRestClient.createProposal(proposalDeatils);
	}

	@Override
	public Response removeProposal(long id) {
		return proposalRestClient.removeProposal(id);
	}

}
