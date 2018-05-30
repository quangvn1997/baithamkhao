package com.example.model;

import com.example.entity.AttendanceSlot;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClassModelSlot extends PagingAndSortingRepository<AttendanceSlot, Integer> {

}
