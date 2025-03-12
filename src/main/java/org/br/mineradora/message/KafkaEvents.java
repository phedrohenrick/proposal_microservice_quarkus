package org.br.mineradora.message;

import org.eclipse.microprofile.reactive.messaging.Channel;
import jakarta.enterprise.context.ApplicationScoped;
import org.br.mineradora.dto.ProposalDTO;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class KafkaEvents {

    private final Logger LOG = LoggerFactory.getLogger(KafkaEvents.class);

    @Channel("proposal")
    Emitter<ProposalDTO> proposalRequirementEmmiter;

    public void sendKafkaEvent(ProposalDTO proposalDTO) {
        LOG.info("Enviando nossa proposta para o Tópico do kafka");
        proposalRequirementEmmiter.send(proposalDTO).toCompletableFuture().join();
    }
}
