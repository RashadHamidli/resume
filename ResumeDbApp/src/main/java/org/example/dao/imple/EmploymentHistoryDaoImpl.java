package org.example.dao.imple;

import org.example.dao.inter.AbstractDAO;
import org.example.dao.inter.EmploymentHistoryDaoInter;
import org.example.entity.EmploymentHistory;
import org.example.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.example.entity.UserSkill;

public class EmploymentHistoryDaoImpl extends AbstractDAO implements EmploymentHistoryDaoInter {

    private EmploymentHistory getEmploymentHistory(ResultSet rs) throws Exception {
        int historyId = rs.getInt("id");
        String companyName=rs.getString("company_name");
        String position = rs.getString("position");
        String jobDescription =rs.getString("job_description");
        Date beginDate= rs.getDate("begin_date");
        Date endDate= rs.getDate("end_date");
        int userId=rs.getInt("user_id");
        
        EmploymentHistory emp=new EmploymentHistory(historyId, companyName, position,beginDate, endDate,   jobDescription, new User(userId));
        return emp;
    }

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int id) {
        List<EmploymentHistory> result = new ArrayList<>();
        try (Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement("select * from employment_history where user_id=?");
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                EmploymentHistory emp = getEmploymentHistory(rs);
                result.add(emp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public boolean insertEmploymentHistory(EmploymentHistory u) {
        boolean b = true;
        try ( Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update employment_history set company_name=?, position=?, begin_date=?, end_date=?, job_description=? user_id=?,  where id=?");
            stmt.setString(1, u.getCompanyName());
            stmt.setString(2, u.getPosition());
            stmt.setDate(3, (java.sql.Date) u.getBeingDate());
            stmt.setDate(4, (java.sql.Date) u.getEndDate());
            stmt.setString(5, u.getJobDescription());
            stmt.setInt(6, u.getUser().getId());
            b = stmt.execute();
            
//insert into employment_history (company_name , position , begin_date , end_date , job_description, user_id) values (?,?,?,?,?,?) 

        } catch (Exception ex) {
            ex.printStackTrace();
            b = false;
        }
        return b;
    }

    @Override
    public boolean updateEmploymentHistory(EmploymentHistory u) {
      boolean b = true;
        try ( Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update employment_history set company_name=?, position=?, begin_date=?, end_date=?, job_description=? user_id=?,  where id=?");
                stmt.setString(1, u.getCompanyName());
            stmt.setString(2, u.getPosition());
            stmt.setDate(3, (java.sql.Date) u.getBeingDate());
            stmt.setDate(4, (java.sql.Date) u.getEndDate());
            stmt.setString(5, u.getJobDescription());
            stmt.setInt(6, u.getUser().getId());
            stmt.setInt(7, u.getId());

            b = stmt.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
            b = false;
        }
        return b;
    }

    @Override
    public boolean removeEmploymentHistory(int id) {
        boolean b = true;
        try ( Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("delete from employment_history where id=?");

            stmt.setInt(1, id);

            return stmt.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }



    
}
