# Instagram Project
# FRAMEWORK AND LANGUAGE USED
- SpringBoot and Java
## Controller
- DoctorController
- PatientController
## Model
- DoctorModel
- PatientModel
## Service
- DoctorService
- PatuentService
## DataBase used
- MYSQL 
## Project Summary
- Here In this project performing the CRUD operations to save the Doctor information and Patient Information
  ### Doctor
- 1)PostMapping ->http://localhost:8080/Hospital/Doctor/addDoc
- 2)GetMapping -> http://localhost:8080/Hospital/DoctorGetDoctor/Details
- 3)GetMapping -> http://localhost:8080/Hospital/DoctorGetDoctor/Details/docId/{docId} (By ID)
- 4)PutMapping -> http://localhost:8080/Hospital/DoctorUpdate/Doctor/docId/{docId}
- 5)DeleteMapping -> http://localhost:8080/Hospital/DoctorDelete/Doctor/docId/{docId}
  ### Patient
- 1)PostMapping ->http://localhost:8080/Patient/Add/patient/Details
- 2)GetMapping -> http://localhost:8080/Patient/getpatient
- 3)GetMapping -> http://localhost:8080/Patient/getpatbyid/patId/{id}
- 4)PutMapping -> (http://localhost:8080/Patient/update/patient/details/patId/{id})
- 4)DeleteMapping -> http://localhost:8080/Patient/delete/patient/patId/{id}












