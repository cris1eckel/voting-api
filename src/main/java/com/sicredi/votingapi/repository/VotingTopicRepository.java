package com.sicredi.votingapi.repository;

import com.sicredi.votingapi.entity.VotingTopicEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotingTopicRepository extends CrudRepository<VotingTopicEntity, Long> {

}
