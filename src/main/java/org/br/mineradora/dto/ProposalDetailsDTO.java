package org.br.mineradora.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Jacksonized
@Data
@Builder
@AllArgsConstructor
public class ProposalDetailsDTO {

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private long proposalId;

  @JsonProperty("customer")
  private String customer;

  @JsonProperty("priceTonne")
  private BigDecimal priceTonnes;

  @JsonProperty("tonnes")
  private Integer tonnes;

  @JsonProperty("country")
  private String country;

  @JsonProperty("validityDays")
  private Integer proposalValidityDays;

}
