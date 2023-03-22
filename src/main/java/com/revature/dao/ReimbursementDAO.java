package com.revature.dao;

import com.revature.model.Reimbursement;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReimbursementDAO {

    public void addReimbursement(Reimbursement r) throws SQLException {
        Connection con = ConnectionUtil.getConnection();
        PreparedStatement ps
                = con.prepareStatement("INSERT INTO reimbursements (amount, description, submitter) " +
                " VALUES (?, ?, ?)");
        ps.setDouble(1, r.getAmount());
        ps.setString(2, r.getDescription());
        ps.setString(3, r.getSubmitter());

        ps.executeUpdate();
    }

    public void processReimbursement(Reimbursement r, String status) throws SQLException {
        Connection con = ConnectionUtil.getConnection();
        PreparedStatement ps
                = con.prepareStatement("UPDATE reimbursements SET status = ? WHERE submitter = ?");
        ps.setString(1, status);
        ps.setString(2, r.getSubmitter());
        ps.executeUpdate();
    }
}
