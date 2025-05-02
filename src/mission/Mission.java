package mission;

import java.util.Date;
import java.util.List;

public abstract class Mission {
    protected String missionId;
    protected String missionName;
    protected Date missionStartDate;
    protected Date missionEndDate;
    protected String status;
    protected List<Personnel> assignedPersonnel;

    public Mission(String missionId, String missionName, Date missionStartDate, Date missionEndDate, List<Personnel> assignedPersonnel) {
        this.missionId = missionId;
        this.missionName = missionName;
        this.missionStartDate = missionStartDate;
        this.missionEndDate = missionEndDate;
        this.assignedPersonnel = assignedPersonnel;
        this.status = "PLANNED";
    }

    // Abstract Methods
    public abstract void assignTask();
    public abstract void allocateResources(List<Resource> availableResources);
    public abstract void trackMissionProgress();
    public abstract void generateMissionReport();
}

