package com.example.postservice.Validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorResponse {
    public ValidationErrorResponse() {
    }
    private List<Violation> violations = new ArrayList<>();

    public List<Violation> getViolations() {
        return violations;
    }

    public void setViolations(List<Violation> violations) {
        this.violations = violations;
    }

}

