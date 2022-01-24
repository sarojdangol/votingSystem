package com.intern.votingSystem.controller;

import com.intern.votingSystem.dto.CandidateDTO;
import com.intern.votingSystem.projection.CandidateProjection;
import com.intern.votingSystem.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vote/candidate")
public class CandidateController {

    @Autowired
    CandidateService candidateService;

    @PostMapping
    public CandidateDTO addCandidate(@RequestBody CandidateDTO candidateDTO) {
        return candidateService.addCandidate(candidateDTO);
    }

    @GetMapping
    public List<CandidateDTO> getCandidate() {
        return candidateService.getAllCandidate();
    }

    @PutMapping
    public CandidateDTO updateCandidate(@RequestBody CandidateDTO candidateDTO) {
        return candidateService.updateCandidate(candidateDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteCandidate(@PathVariable int id) {
        return candidateService.deleteCandidate(id);
    }

    @GetMapping("/{id}/event")
    public List<CandidateDTO> getCandidateEvent(@PathVariable int id) {
        return candidateService.getCandidateByEvent(id);
    }
}
