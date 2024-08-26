package dao;

import jdbc.DatabaseConnection;
import model.Doctor;
import model.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {
    public void createDoctor(Doctor doctor) throws SQLException {
        String query = "INSERT INTO Doctors (FirstName, LastName,Specialty, Email) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, doctor.getFirstName());
            stmt.setString(2, doctor.getLastName());
            stmt.setString(3, doctor.getSpecialty());
            stmt.setString(4, doctor.getEmail());
           stmt.executeUpdate();
        }
    }       // End of Create  Doctor

    public static Doctor getDoctorById(int doctorId) throws SQLException {
        String query = "Select * from Doctors where DoctorId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, doctorId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Doctor doctor = new Doctor();
                    doctor.setDoctorId(rs.getInt("DoctorID"));
                    doctor.setFirstName(rs.getString("FirstName"));
                    doctor.setLastName(rs.getString("LastName"));
                    doctor.setSpecialty(rs.getString("Specialty"));
                    doctor.setEmail(rs.getString("email"));
                    return doctor;
                }
            }
        }
      return  null;
    }

    //update Doctor
    public  void  updateDoctor(Doctor doctor) throws SQLException{
        String query = "UPDATE Doctors Set FirstName = ?, LastName =?, Specialty=?, Email=? WHERE DoctorID=?";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1,doctor.getFirstName());
            stmt.setString(2,doctor.getLastName());
            stmt.setString(3, doctor.getSpecialty());
            stmt.setString(4, doctor.getEmail());
            stmt.setInt(5,doctor.getDoctorId());
            stmt.executeUpdate();
        }
    }

    //delete doctor
    public  void deleteDoctor(int doctorId) throws SQLException{
        String query = "DELETE FROM Doctors WHERE doctorId = ?";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1,doctorId);
            stmt.executeUpdate();
        }
    }

    //list for all doctors in the database

    public List<Doctor> getAllDoctors() throws SQLException{
        String query = "SELECT * FROM Doctors";
        List<Doctor>doctors = new ArrayList<>();
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()){
         while (rs.next()){
             Doctor doctor = new Doctor();
             doctor.setDoctorId(rs.getInt("DoctorId"));
             doctor.setFirstName(rs.getString("FirstName"));
             doctor.setLastName(rs.getString("LastName"));
             doctor.setSpecialty(rs.getString("Specialty"));
             doctor.setEmail(rs.getString("Email"));
             doctors.add(doctor);
         }
        }
        return doctors;
    }



}