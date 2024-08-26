import dao.DoctorDAO;
import model.Doctor;

import java.sql.SQLException;
import java.util.List;

public class DoctorRunner {

    public static void main(String[] args) throws SQLException {

      //Get Doctor by Id
        System.out.println("Get Doctor by ID");
        Doctor d = new Doctor();
         d = DoctorDAO.getDoctorById(5);
        System.out.println(d);

        System.out.println("Get ALl Doctors");
       DoctorDAO doctorDAO = new DoctorDAO();
       List<Doctor> doctorsList =  doctorDAO.getAllDoctors();
        for(Doctor doctor : doctorsList) {
            System.out.println(doctor);
        }

        // Update Doctor

        Doctor cDocor = new Doctor();
        cDocor.setDoctorId(1);
        cDocor.setFirstName("Ronald");
        cDocor.setLastName("Bute");
        cDocor.setSpecialty("Physcian");
        cDocor.setEmail("Ronald@test.com");
        DoctorDAO dDao = new DoctorDAO();
        dDao.updateDoctor(cDocor);

       System.out.println("Successfully Run");
//        Scanner scanner = new Scanner(System.in);
////
////      List<Patient> patients =  patientDAO.getAllPatients();
////
////      for(Patient patient : patients) {
////          System.out.println(patient);
////      }
//
//
//
//        System.out.println("1. Create Patient");
//        System.out.println("2. Read Patient");
//        System.out.println("3. Update Patient");
//        System.out.println("4. Delete Patient");
//
////im here
//        int choice = scanner.nextInt();
//        scanner.nextLine();
//
//
//        try {
//            switch (choice) {
//                case 1:
//                    // Create Patient
//                    Patient newPatient = new Patient();
//                    System.out.print("Enter first name: ");
//                    newPatient.setFirstName(scanner.nextLine());
//                    System.out.print("Enter last name: ");
//                    newPatient.setLastName(scanner.nextLine());
//                    System.out.print("Enter date of birth (YYYY-MM-DD): ");
//                    newPatient.setDateOfBirth(scanner.nextLine());
//                    System.out.print("Enter email: ");
//                    newPatient.setEmail(scanner.nextLine());
//                    System.out.print("Enter phone number: ");
//                    newPatient.setPhoneNumber(scanner.nextLine());
//                    patientDAO.createPatient(newPatient);
//                    System.out.println("Patient created successfully.");
//                    break;
//                case 2:
//                    // Read Patient
//                    System.out.print("Enter Patient ID: ");
//                    int patientId = scanner.nextInt();
//                    Patient patient = patientDAO.getPatientById(patientId);
//                    if (patient != null) {
//                        System.out.println("Patient ID: " + patient.getPatientId());
//                        System.out.println("Name: " + patient.getFirstName() + " " + patient.getLastName());
//                        System.out.println("Date of Birth: " + patient.getDateOfBirth());
//                        System.out.println("Email: " + patient.getEmail());
//                        System.out.println("Phone: " + patient.getPhoneNumber());
//                    } else {
//                        System.out.println("Patient not found.");
//                    }
//                    break;
//                case 3:
//                    // Update Patient
//                    System.out.print("Enter Patient ID: ");
//                    patientId = scanner.nextInt();
//                    scanner.nextLine();  // consume newline
//                    patient = patientDAO.getPatientById(patientId);
//                    if (patient != null) {
//                        System.out.print("Enter new first name: ");
//                        patient.setFirstName(scanner.nextLine());
//                        System.out.print("Enter new last name: ");
//                        patient.setLastName(scanner.nextLine());
//                        System.out.print("Enter new date of birth (YYYY-MM-DD): ");
//                        patient.setDateOfBirth(scanner.nextLine());
//                        System.out.print("Enter new email: ");
//                        patient.setEmail(scanner.nextLine());
//                        System.out.print("Enter new phone number: ");
//                        patient.setPhoneNumber(scanner.nextLine());
//                        patientDAO.updatePatient(patient);
//                        System.out.println("Patient updated successfully.");
//                    } else {
//                        System.out.println("Patient not found.");
//                    }
//                    break;
//                case 4:
//                    // Delete Patient
//                    System.out.print("Enter Patient ID: ");
//                    patientId = scanner.nextInt();
//                    patientDAO.deletePatient(patientId);
//                    System.out.println("Patient deleted successfully.");
//                    break;
//                default:
//                    System.out.println("Invalid choice.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            scanner.close();
//        }

    }
}
