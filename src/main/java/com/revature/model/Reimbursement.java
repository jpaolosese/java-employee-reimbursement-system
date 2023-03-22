package com.revature.model;

import java.util.Objects;

public class Reimbursement {
    private double amount;
    private String description;
    private String submitter;
    private String status;

    public Reimbursement() {}

    public Reimbursement(double amount, String description, String submitter) {
        this.amount = amount;
        this.description = description;
        this.submitter = submitter;
        this.status = "PENDING";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimbursement that = (Reimbursement) o;
        return Double.compare(that.amount, amount) == 0 && Objects.equals(description, that.description) && Objects.equals(submitter, that.submitter) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, description, submitter, status);
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "amount=" + amount +
                ", description='" + description + '\'' +
                ", submitter='" + submitter + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
