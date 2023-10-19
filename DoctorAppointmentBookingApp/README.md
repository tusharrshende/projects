

## **DocAppointmentBookingApp README.md**

1. **Frameworks and Language Used:**
   - Framework: Spring Boot
   - Language: Java
   - Database: It appears to use a relational database, likely with a JPA (Java Persistence API) implementation like Hibernate.

2. **Data Flow:**

   **Controller:**
   - AdminController:
     - `getAllPatients()` retrieves a list of all patients.
     - `addDoctor(Doctor newDoctor)` adds a new doctor.
     - `getAllPatientsByBloodGroup(BloodGroup bloodGroup)` retrieves patients by blood group.

   - DoctorController:
     - `getAllDoctors(AuthenticationInputDto authInfo)` retrieves a list of all doctors with authentication.
     - `getDoctorById(Integer id)` retrieves a doctor by their ID.

   - PatientController:
     - `patientSignUp(Patient patient)` allows a patient to sign up.
     - `patientSignIn(SignInInputDto signInInput)` allows a patient to sign in.
     - `patientSignOut(AuthenticationInputDto authInfo)` allows a patient to sign out.
     - `scheduleAppointment(ScheduleAppointmentDTO scheduleAppointmentDTO)` schedules an appointment.
     - `cancelAppointment(AuthenticationInputDto authInfo, Integer appointmentId)` cancels an appointment.
     - `getDoctorsByQualificationOrSpec(AuthenticationInputDto authInfo, Qualification qual, Specialization spec)` retrieves doctors by qualification or specialization.

   **Services:**
   - DoctorService:
     - `getAllDoctors(AuthenticationInputDto authInfo)` retrieves all doctors with authentication.
     - `addDoctor(Doctor newDoctor)` adds a new doctor.
     - `getDoctorById(Integer id)` retrieves a doctor by ID.
     - `getDoctorsByQualificationOrSpec(AuthenticationInputDto authInfo, Qualification qual, Specialization spec)` retrieves doctors by qualification or specialization with authentication.

   - PatientService:
     - `patientSignUp(Patient patient)` allows a patient to sign up.
     - `patientSignIn(SignInInputDto signInInput)` allows a patient to sign in.
     - `patientSignOut(AuthenticationInputDto authInfo)` allows a patient to sign out.
     - `getAllPatients()` retrieves a list of all patients.
     - `getAllPatientsByBloodGroup(BloodGroup bloodGroup)` retrieves patients by blood group.

   - AppointmentService:
     - `scheduleAppointment(AuthenticationInputDto authInfo, Appointment appointment)` schedules an appointment.
     - `cancelAppointment(AuthenticationInputDto authInfo, Integer appointmentId)` cancels an appointment.

   - EmailService: Sends email notifications.
   - PasswordEncryptor: Encrypts passwords using MD5 hashing.
   - PTokenService: Manages patient authentication tokens.

   **Repository:**
   - Repositories are likely used for database interaction, although specific repository interfaces are not provided in the code snippets.

   **Database Design:**
   - The code snippets indicate the use of a relational database, where entities such as `Patient`, `Doctor`, `Appointment`, and others are likely stored in tables. Relationships between entities are established using foreign keys.

3. **Data Structures Used in Your Project:**
   - The data structures used depend on the specific entities defined in the code. Entities like `Patient`, `Doctor`, `Appointment`, and others represent structured data that is stored in the database tables.

4. **Project Summary:**
   - This project appears to be a Doctor Appointment Booking application built using the Spring Boot framework in Java. It provides functionalities for patients to sign up, sign in, and schedule appointments with doctors. The application supports user authentication with tokens or OTPs. It also includes features for doctors, administrators, and patients to manage appointments and patient information. Data is stored in a relational database, and the application uses various services to manage patient authentication, send email notifications, and encrypt passwords. Overall, the project is a web-based solution for managing doctor appointments and patient data.