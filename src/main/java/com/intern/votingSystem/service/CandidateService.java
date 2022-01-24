package com.intern.votingSystem.service;

import com.intern.votingSystem.dto.CandidateDTO;
import com.intern.votingSystem.dto.UserDTO;
import com.intern.votingSystem.model.Candidate;
import com.intern.votingSystem.projection.CandidateProjection;

import java.util.List;

public interface CandidateService {
    CandidateDTO addCandidate(CandidateDTO candidateDTO);
    List<CandidateDTO> getAllCandidate();
    CandidateDTO updateCandidate(CandidateDTO candidateDTO);
    String deleteCandidate(int id);
    List<CandidateDTO> getCandidateByEvent(int id);
}
