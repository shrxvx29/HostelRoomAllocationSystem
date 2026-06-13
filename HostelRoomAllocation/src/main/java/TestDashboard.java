

import com.hostel.dao.DashboardDAO;

public class TestDashboard {

    public static void main(String[] args) {

        DashboardDAO dao =
                new DashboardDAO();

        System.out.println(
                "Students : " +
                dao.getStudentCount());

        System.out.println(
                "Rooms : " +
                dao.getRoomCount());

        System.out.println(
                "Available Rooms : " +
                dao.getAvailableRoomCount());

        System.out.println(
                "Full Rooms : " +
                dao.getFullRoomCount());

        System.out.println(
                "Active Allocations : " +
                dao.getActiveAllocationCount());
    }
}