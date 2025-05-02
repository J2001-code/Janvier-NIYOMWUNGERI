package land;

import java.util.Date;

public class IndustrialLand extends Land {

    public IndustrialLand(String landId, String ownerName, String location, double sizeInAcres, Date registrationDate, String landUseStatus) {
        super(landId, ownerName, location, sizeInAcres, registrationDate, landUseStatus);
    }

    @Override
    public boolean validateOwnership() {
        return !ownerName.isEmpty();
    }

    @Override
    public boolean checkZoningCompliance() {
        return true; // Assume environmental clearance
    }

    @Override
    public double calculateTax() {
        return sizeInAcres * 12000 * 0.03; // 3% tax
    }

    @Override
    public void generateLandReport() {
        displayBasicInfo();
        System.out.println("Land Type: Industrial Land");
        System.out.println("Tax: $" + calculateTax());
        System.out.println("Zoning Compliance: " + (checkZoningCompliance() ? "Compliant" : "Not Compliant"));
        System.out.println("Ownership Validity: " + (validateOwnership() ? "Valid" : "Invalid"));
    }
}

