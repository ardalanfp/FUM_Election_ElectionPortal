package com.microservice.FumElection.controller;

import com.microservice.FumElection.exception.ElectionNotFoundException;
import com.microservice.FumElection.exception.VoteAlreadyExistsException;
import com.microservice.FumElection.model.VoteModel;
import com.microservice.FumElection.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class Controller {

    @Autowired
    VoteRepository votesRepository;

    @GetMapping(value = "/allowedToVote")
    public Map<String,String> hasVoted(String voterUserId, int electionId){
        VoteModel v =votesRepository.findByElectionIdAndVoterUserId(electionId,voterUserId);
        if (v != null) {
            throw new VoteAlreadyExistsException();
        }
        Map<String,String> map = new HashMap<>();
        String msg = "user has not voted.";
        map.put("message",msg);
        return map;
    }

    @GetMapping(value = "/saveVote")
    public Map<String,String> vote(int electionId,int choiceNumber,String voterUserId){

        VoteModel vote = new VoteModel(electionId,choiceNumber,voterUserId);
        votesRepository.save(vote);
        Map<String,String> map = new HashMap<>();
        String msg = "vote creation was successful";
        map.put("message",msg);
        return map;
    }

    @GetMapping(value = "/heartbeat")
    public void  heartbeat(){
    }

}
