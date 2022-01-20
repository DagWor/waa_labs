package students;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, Integer> {

    List<Student> findByName(String name);

    Student findByPhoneNumber(String phone);

    @Query("{email : ?0}")
    Student findByhEmail(String email);

    @Query("{'address.city' : ?0}")
    List<Student> findStudentFromCity(String city);

}