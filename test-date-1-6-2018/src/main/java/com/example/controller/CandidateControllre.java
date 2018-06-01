package com.example.controller;

import com.example.model.CandidateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;

@Controller
public class CandidateControllre {
    @Autowired
    private CandidateModel candidateModel;

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public String getListProduct(Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int limit) {
        model.addAttribute("pagination", candidateModel.findAll( PageRequest.of(page - 1, limit)));
        return "list";
    }
}
