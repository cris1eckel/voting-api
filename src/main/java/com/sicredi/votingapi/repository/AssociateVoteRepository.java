package com.sicredi.votingapi.repository;

import com.sicredi.votingapi.entity.AssociateVoteEntity;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface AssociateVoteRepository extends CrudRepository<AssociateVoteEntity, Long> {
    Optional<AssociateVoteEntity> findByVotingTopicIdAndAssociateCode(Long votingTopicId, Long associateCode);

}
