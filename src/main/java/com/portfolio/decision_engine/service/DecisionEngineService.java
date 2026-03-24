package com.portfolio.decisionengine.service;

import com.portfolio.decisionengine.model.LoanApplication;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

@Service
public class DecisionEngineService {

    public LoanApplication evaluateLoan(LoanApplication application) {
        // Load the Drools Engine
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession();

        // Insert the data, run the rules, and close the session
        kSession.insert(application);
        kSession.fireAllRules();
        kSession.dispose();

        return application;
    }
}