package mission;

import java.util.List;

public class ReconMission extends Mission {

    public ReconMission(String missionId, String missionName, java.util.Date startDate, java.util.Date endDate, List<Personnel> assignedPersonnel) {
        super(missionId, missionName, startDate, endDate, assignedPersonnel);
    }

    @Override
    public void assignTask() {
        if (assignedPersonnel.size() < 2) {
            System.out.println("ReconMission requires at least 2 personnel.");
            return;
        }
        for (Personnel p : assignedPersonnel) {
            System.out.println("Assigning reconnaissance task to " + p.getPersonnelName());
        }
    }

    @Override
    public void allocateResources(List<Resource> availableResources) {
        for (Resource r : availableResources) {
            if (r.getResourceName().equalsIgnoreCase("Drone") && r.getQuantity() > 0) {
                System.out.println("Drone allocated for Recon Mission.");
                r.setQuantity(r.getQuantity() - 1);
                return;
            }
        }
        System.out.println("No drone available for Recon Mission!");
    }

    @Override
    public void trackMissionProgress() {
        System.out.println("Tracking reconnaissance progress...");
        this.status = "IN_PROGRESS";
    }

    @Override
    public void generateMissionReport() {
        System.out.println("--- Recon Mission Report ---");
        System.out.println("Mission: " + missionName + " | Status: " + status);
    }
}

