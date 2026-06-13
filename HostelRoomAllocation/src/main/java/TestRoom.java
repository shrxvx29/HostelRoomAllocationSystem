

import com.hostel.dao.RoomDAO;

public class TestRoom {

    public static void main(String[] args) {

        RoomDAO dao = new RoomDAO();

        System.out.println(
                dao.deleteRoom(4)
        );
    }
}