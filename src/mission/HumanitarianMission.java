package mission;

import java.util.List;

public class HumanitarianMission extends Mission {

    public HumanitarianMission(String missionId, String missionName, java.util.Date startDate, java.util.Date endDate, List<Personnel> assignedPersonnel) {
        super(missionId, missionName, startDate, endDate, assignedPersonnel);
    }

    @Override
    public void assignTask() {
        for (Personnel p : assignedPersonnel) {
            System.out.println("Assigning humanitarian task to " + p.getPersonnelName());
        }
    }

    @Override
    public void allocateResources(List<Resource> availableResources) {
        boolean hasFood = false;
        boolean hasMedical = false;
        for (Resource r : availableResources) {
            if (r.getResourceName().equalsIgnoreCase("Food Supply") && r.getQuantity() > 0) {
                hasFood = true;
            }
            if (r.getResourceName().equalsIgnoreCase("Medical Kit") && r.getQuantity() > 0) {
                hasMedical = true;
            }
        }
        if (hasFood && hasMedical) {
            System.out.println("Food and Medical supplies allocated for Humanitarian Mission.");
        } else {
            System.out.println("Essential resources missing for Humanitarian Mission!");
        }
    }

    @Override
    public void trackMissionProgress() {
        System.out.println("Monitoring humanitarian distribution...");
        this.status = "IN_PROGRESS";
    }

    @Override
    public void generateMissionReport() {
        System.out.println("--- Humanitarian Mission Report ---");
        System.out.println("Mission: " + missionName + " | Status: " + status);
    }
}

