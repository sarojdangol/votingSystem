package com.intern.votingSystem.service.impl;

import com.intern.votingSystem.dto.CandidateDTO;
import com.intern.votingSystem.dto.Message;
import com.intern.votingSystem.model.Candidate;
import com.intern.votingSystem.repository.CandidateRepository;
import com.intern.votingSystem.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateImpl implements CandidateService {
    @Autowired
    CandidateRepository candidateRepository;
//    public CandidateDTO addCandidateRequest(CandidateDTO candidateDTO){
//        return
//    }


    @Override
    public CandidateDTO addCandidate(CandidateDTO candidateDTO) {
        Candidate candidate = new Candidate();
        candidate.candidateMthd(candidateDTO);
        Candidate savedCandidate = candidateRepository.save(candidate);
        CandidateDTO candidateDTO1 = new CandidateDTO();
        candidateDTO1.candidateDTOMthd(savedCandidate);
        return candidateDTO1;
    }

    @Override
    public List<CandidateDTO> getAllCandidate() {

        List<Candidate> candidateList = candidateRepository.getCandidateQuery();
        List<CandidateDTO> candidateDTOList = new ArrayList<>();
        candidateList.forEach(candidate -> {
            CandidateDTO candidateDTO = new CandidateDTO();
            candidateDTO.candidateDTOMthd(candidate);
            candidateDTOList.add(candidateDTO);
        });
        return candidateDTOList;
    }

    @Override
    public CandidateDTO updateCandidate(CandidateDTO candidateDTO) {

        Candidate candidate = new Candidate();
        candidate.candidateMthd(candidateDTO);
        Candidate saveCandidate1 = candidateRepository.save(candidate);
        CandidateDTO candidateDTO1 = new CandidateDTO();
        candidateDTO1.candidateDTOMthd(saveCandidate1);
        return candidateDTO1;
    }

    @Transactional
    @Override
    public String deleteCandidate(int id) {

        if (candidateRepository.existsById(id)) {
            candidateRepository.deleteCandidateQuery(id);
            return Message.setMessage("001", "successfully deleted");

        } else {
            return Message.setMessage("001", "candidate with given id does not exist");

        }
    }

    @Override
    public List<CandidateDTO> getCandidateByEvent(int id) {
        List<Candidate> candidateList = candidateRepository.getCandidateByEventQuery(id);
        List<CandidateDTO> candidateDTOList = new ArrayList<>();
        candidateList.forEach(candidate -> {
            CandidateDTO candidateDTO = new CandidateDTO();
            candidateDTO.candidateDTOMthd(candidate);
            candidateDTOList.add(candidateDTO);

        });
        return candidateDTOList;
    }
}
