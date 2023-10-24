package org.br.mineradora.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.br.mineradora.client.ReportRestClient;
import org.br.mineradora.dto.OpportunityDTO;
import org.br.mineradora.utils.CSVHelper;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ReportServiceImpl implements ReportService {
	
	@Inject
	@RestClient
	ReportRestClient reportRestClient;

	@Override
	public ByteArrayInputStream generateCSVOpportunityReport() {
		List<OpportunityDTO> opportunityData = reportRestClient.requestOpportunitiesData();
		return CSVHelper.OpportunitiesToCSV(opportunityData);
	}

	@Override
	public List<OpportunityDTO> getOpportunitiesData() {
		return reportRestClient.requestOpportunitiesData();
	}

}
