package mission;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Create Personnel
        Personnel p1 = new Personnel("P001", "Alice", "Medic");
        Personnel p2 = new Personnel("P002", "Bob", "Soldier");
        Personnel p3 = new Personnel("P003", "Charlie", "Scout");

        List<Personnel> personnelList = new ArrayList<>();
        personnelList.add(p1);
        personnelList.add(p2);
        personnelList.add(p3);

        // Create Resources
        List<Resource> resources = new ArrayList<>();
        resources.add(new Resource("R001", "Drone", 2, "Equipment"));
        resources.add(new Resource("R002", "Ambulance", 1, "Vehicle"));
        resources.add(new Resource("R003", "Ammunition", 5, "Weapon"));
        resources.add(new Resource("R004", "Medical Kit", 10, "Medical Supplies"));
        resources.add(new Resource("R005", "Food Supply", 15, "Food"));

        // Create a Mission
        Mission reconMission = new ReconMission("M001", "Recon Alpha", sdf.parse("2025-05-01"), sdf.parse("2025-05-10"), personnelList);

        // Perform Mission Operations
        reconMission.assignTask();
        reconMission.allocateResources(resources);
        reconMission.trackMissionProgress();
        reconMission.generateMissionReport();
    }
}
