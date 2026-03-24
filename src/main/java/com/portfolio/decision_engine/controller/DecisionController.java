package com.portfolio.decisionengine.controller;

import com.portfolio.decisionengine.model.LoanApplication;
import com.portfolio.decisionengine.service.DecisionEngineService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/decision")
public class DecisionController {

    private final DecisionEngineService decisionService;

    public DecisionController(DecisionEngineService decisionService) {
        this.decisionService = decisionService;
    }

    @PostMapping("/loan")
    public LoanApplication processLoan(@RequestBody LoanApplication application) {
        return decisionService.evaluateLoan(application);
    }
}