package com.sicredi.votingapi.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResultsResponse {

    String subject;

    int positiveVotes;

    int negativeVotes;

    boolean approved;
}
