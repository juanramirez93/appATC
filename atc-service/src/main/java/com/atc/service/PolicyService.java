package com.atc.service;
import com.atc.connection.PolicyEM;
import com.atc.model.Policy;

import java.util.ArrayList;
import java.util.List;

public class PolicyService {
    PolicyEM policyEM;

    public PolicyService() {
        policyEM = new PolicyEM();
    }

    public List<Policy> search(String str) {
        return policyEM.search(str);
    }

    public void add(Policy policy) {
        policyEM.save(policy);
    }

    public void update(Policy policy) {
        policyEM.update(policy);
    }

    public boolean exist(String number) {
        return policyEM.exist(number);
    }

    public List<Policy> getAll() {
        return policyEM.getAll();
    }

    public List<Policy> getAllVida() {
        return policyEM.getAllVida();
    }

    public List<Policy> getAllRCE() {
        return policyEM.getAllRCE();
    }

    public List<Policy> getAllTransporte() {
        return policyEM.getAllTransporte();
    }

    public List<String> getAllVidaNumber() {
        List<String> list = new ArrayList<String>();
        for(Policy policy : getAllRCE()) {
            list.add(policy.getNumber());
        }
        return list;
    }

    public List<String> getAllRCENumber() {
        List<String> list = new ArrayList<String>();
        for(Policy policy : getAllVida()) {
            list.add(policy.getNumber());
        }
        return list;
    }

    public List<String> getAllTransporteNumber() {
        List<String> list = new ArrayList<String>();
        for(Policy policy : getAllTransporte()) {
            list.add(policy.getNumber());
        }
        return list;
    }

    public boolean existPolicy(String branch, String policy) {
        List<Policy> policies = getAll();
        for(Policy pol : policies) {
            if(pol.getBranch().equals(branch) && pol.getNumber().equals(policy)) {
                return true;
            }
        }
        return false;
    }

    public Policy getPolicyByNumber(String poliza) {
        return policyEM.getPolicyByNumber(poliza);
    }
}
