package com.example.model;

import com.example.entity.Candidate;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CandidateModel extends PagingAndSortingRepository<Candidate, Integer> {
}
