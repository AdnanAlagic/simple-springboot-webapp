import com.edcg.simple.springboot.webapp.model.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student(1L, "John", "Doe", "john.doe@test.com", "Computer Science", 21);
    }

    @Test
    void testStudentConstructorAndGetters() {
        assertEquals(1L, student.getId());
        assertEquals("John", student.getFirstName());
        assertEquals("Doe", student.getLastName());
        assertEquals("john.doe@test.com", student.getEmail());
        assertEquals("Computer Science", student.getMajor());
        assertEquals(21, student.getAge());
    }

    @Test
    void testFullName() {
        assertEquals("John Doe", student.getFullName());
    }

    @Test
    void testSetters() {
        student.setFirstName("Jane");
        student.setLastName("Smith");
        student.setAge(22);

        assertEquals("Jane", student.getFirstName());
        assertEquals("Smith", student.getLastName());
        assertEquals("Jane Smith", student.getFullName());
        assertEquals(22, student.getAge());
    }

    @Test
    void testDefaultConstructor() {
        Student emptyStudent = new Student();
        assertNull(emptyStudent.getId());
        assertNull(emptyStudent.getFirstName());
        assertNull(emptyStudent.getLastName());
    }
}