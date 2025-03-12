package org.br.mineradora.controller;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.br.mineradora.dto.ProposalDetailsDTO;
import org.br.mineradora.service.ProposalService;
import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

@Path("/api/proposal")
public class ProposalController {

    private static final Logger LOG = Logger.getLogger(ProposalController.class.getName());

    @Inject
    ProposalService proposalService;

    @GET
    @Path("/{id}")
    public ProposalDetailsDTO proposalDetailsDTO(@PathParam("id") Long id){
        return proposalService.findFullProposal(id);
    }

    @POST
    public Response createNewProposal(ProposalDetailsDTO proposalDetailsDTO){
        LOG.info("Recebendo proposta de compra");

        try{
            proposalService.createNewProposal(proposalDetailsDTO);
            return Response.ok().build();
        }catch (Exception e){
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response removeProposal(@PathParam("id") Long id){

        try {
            proposalService.removeProposal(id);
            return Response.ok().build();
        }catch (Exception e){
            return Response.serverError().build();
        }
    }
}
