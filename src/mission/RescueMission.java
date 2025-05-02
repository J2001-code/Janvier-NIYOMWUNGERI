package mission;

import java.util.List;

public class RescueMission extends Mission {

    public RescueMission(String missionId, String missionName, java.util.Date startDate, java.util.Date endDate, List<Personnel> assignedPersonnel) {
        super(missionId, missionName, startDate, endDate, assignedPersonnel);
    }

    @Override
    public void assignTask() {
        boolean hasMedic = false;
        for (Personnel p : assignedPersonnel) {
            if (p.getPersonnelRole().equalsIgnoreCase("Medic")) {
                hasMedic = true;
            }
            System.out.println("Assigning rescue task to " + p.getPersonnelName());
        }
        if (!hasMedic) {
            System.out.println("Error: Rescue Mission must have at least one Medic assigned!");
        }
    }

    @Override
    public void allocateResources(List<Resource> availableResources) {
        boolean allocated = false;
        for (Resource r : availableResources) {
            if (r.getResourceName().equalsIgnoreCase("Ambulance") && r.getQuantity() > 0) {
                System.out.println("Ambulance allocated for Rescue Mission.");
                r.setQuantity(r.getQuantity() - 1);
                allocated = true;
            }
        }
        if (!allocated) {
            System.out.println("No Ambulance available for Rescue Mission!");
        }
    }

    @Override
    public void trackMissionProgress() {
        System.out.println("Tracking rescue progress...");
        this.status = "IN_PROGRESS";
    }

    @Override
    public void generateMissionReport() {
        System.out.println("--- Rescue Mission Report ---");
        System.out.println("Mission: " + missionName + " | Status: " + status);
    }
}

