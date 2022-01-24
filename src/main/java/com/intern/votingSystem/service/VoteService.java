package com.intern.votingSystem.service;

import com.intern.votingSystem.dto.VoteDTO;

import java.util.List;

public interface VoteService {
 VoteDTO addVote(VoteDTO voteDTO);
 List<VoteDTO> getAllCandidateVote();
 List<VoteDTO> getCandidateVoteCount();

}
