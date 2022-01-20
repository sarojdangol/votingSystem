package com.intern.votingSystem.service;

import com.intern.votingSystem.dto.CandidateDTO;
import com.intern.votingSystem.dto.UserDTO;
import com.intern.votingSystem.model.Candidate;

import java.util.List;

public interface CandidateService {
    CandidateDTO addCandidate(CandidateDTO candidateDTO);
    List<CandidateDTO> getAllCandidate();
    CandidateDTO updateCandidate(CandidateDTO candidateDTO);
    String deleteCandidate(int id);
}
