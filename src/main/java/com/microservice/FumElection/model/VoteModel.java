package com.microservice.FumElection.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "votes")
public class VoteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int electionId;

    @Column
    private int choiceNumber;

    @Column
    private int voterUserId;

    @Column
    private Date submitDate;

    public VoteModel() {
    }

    public VoteModel( int electionId, int choiceNumber, int voterUserId) {
        this.electionId = electionId;
        this.choiceNumber = choiceNumber;
        this.voterUserId = voterUserId;
        this.submitDate = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getElectionId() {
        return electionId;
    }

    public void setElectionId(int electionId) {
        this.electionId = electionId;
    }

    public int getChoiceNumber() {
        return choiceNumber;
    }

    public void setChoiceNumber(int choiceNumber) {
        this.choiceNumber = choiceNumber;
    }

    public int getVoterUserId() {
        return voterUserId;
    }

    public void setVoterUserId(int voterUserId) {
        this.voterUserId = voterUserId;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public String toString(){
        return "vote for election "+electionId +" for user "+ voterUserId + " at " + submitDate.toString();
    }
}
