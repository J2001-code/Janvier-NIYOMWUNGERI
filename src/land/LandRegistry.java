package land;

import java.util.ArrayList;
import java.util.List;

public class LandRegistry {
    private List<Land> lands;

    public LandRegistry() {
        lands = new ArrayList<>();
    }

    public void addLand(Land land) {
        if (land.validateOwnership() && land.checkZoningCompliance()) {
            lands.add(land);
            System.out.println("Land registered successfully!");
        } else {
            System.out.println("Failed to register land. Check ownership or zoning rules.");
        }
    }

    public void displayAllLands() {
        if (lands.isEmpty()) {
            System.out.println("No land registered yet.");
        } else {
            for (Land land : lands) {
                land.generateLandReport();
            }
        }
    }
}

