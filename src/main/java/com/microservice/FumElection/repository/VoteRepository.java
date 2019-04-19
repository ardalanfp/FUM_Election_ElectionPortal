package com.microservice.FumElection.repository;

import com.microservice.FumElection.model.VoteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<VoteModel, Integer> {
    VoteModel findByElectionIdAndVoterUserId(int electionId, int voterUserId);
}
