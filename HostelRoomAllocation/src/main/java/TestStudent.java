
import com.hostel.dao.StudentDAO;

public class TestStudent {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        System.out.println(
                dao.deleteStudent(6)
        );
    }
}