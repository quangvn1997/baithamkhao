package com.example.model;

import com.example.entities.Dish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface DishModel extends PagingAndSortingRepository<Dish, Integer> {
    Page<Dish> findByStatusNot(int staust, PageRequest pageRequest);
}
