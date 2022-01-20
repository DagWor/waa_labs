package students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;


@SpringBootApplication
@EnableMongoRepositories
public class Application implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
        // create student
		Student student = new Student(101,"John doe", "0622341678","johnd@acme.com" );
		Address address = new Address("1000 N. 4th St.","Fairfield", "Iowa","52557");
		student.setAddress(address);
		studentRepository.save(student);
		student = new Student(109,"John Jones", "0624321234","jones@acme.com");
		address = new Address("10231 Forest Ln","Dallas", "Texas", "73233");
		student.setAddress(address);
		studentRepository.save(student);
		student = new Student(66,"James Johnson", "068633452","jj123@acme.com" );
		address = new Address("7213 Park Ln", "Chicago","Illinois", "42134");
		student.setAddress(address);
		studentRepository.save(student);
		//get students
		System.out.println(studentRepository.findByName("James Johnson"));
		System.out.println(studentRepository.findById(66).get());
		System.out.println(studentRepository.findById(101).get());
		System.out.println("-----------All student ----------------");
		System.out.println(studentRepository.findAll());
		//update students
		student = studentRepository.findById(101).get();
		student.setEmail("jd@gmail.com");
		studentRepository.save(student);
		System.out.println("-----------find by phone ----------------");
		System.out.println(studentRepository.findByPhoneNumber("0622341678"));
		System.out.println("-----------find by email ----------------");
		System.out.println(studentRepository.findByhEmail("jj123@acme.com"));
		System.out.println("-----------find student from certain city ----------------");
		List<Student> students = studentRepository.findStudentFromCity("Fairfield");
		for (Student stud : students){
			System.out.println(stud);
		}

	}

}
