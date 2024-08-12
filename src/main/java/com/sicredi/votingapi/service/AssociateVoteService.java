package com.sicredi.votingapi.service;

import com.sicredi.votingapi.mapper.AssociateVoteMapper;
import com.sicredi.votingapi.model.AssociateVote;
import com.sicredi.votingapi.repository.AssociateVoteRepository;
import com.sicredi.votingapi.service.exception.UserAlreadyVotedException;
import com.sicredi.votingapi.service.exception.VotingSessionAlreadyFinishedException;
import com.sicredi.votingapi.service.exception.VotingSessionNotStartedException;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AssociateVoteService {

    private final AssociateVoteRepository associateVoteRepository;

    private final VotingTopicService votingTopicService;

    private final VotingSessionService votingSessionService;

    private final NationalIdService nationalIdService;

    private final AssociateVoteMapper mapper;

    @Transactional
    public void create(AssociateVote vote) {
        log.info("Creating a new vote with the following data: {}", vote);
        //Apparently the HEROKU end point is unavailable so im leaving the request commented.
        //nationalIdService.canVote(vote.getNationalId());
        var timeNow = LocalDateTime.now();

        var votingTopic = this.votingTopicService.findById(vote.getVotingTopic().getId());

        var votingSession = votingSessionService.findVotingSessionByVotingTopicId(votingTopic.getId());

        if (votingSession == null || timeNow.isBefore(votingSession.getStartDate())) {
            throw new VotingSessionNotStartedException();
        }

        if (timeNow.isAfter(votingSession.getEndDate())) {
            throw new VotingSessionAlreadyFinishedException();
        }

        var associateVote = this.associateVoteRepository.findByVotingTopicIdAndAssociateCode(votingTopic.getId(), vote.getAssociateCode());

        if (associateVote.isPresent()) {
            throw new UserAlreadyVotedException();
        }

        this.associateVoteRepository.save(this.mapper.toEntity(vote));
    }
}
