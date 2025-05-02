package land;

import java.util.Date;

public class AgriculturalLand extends Land {

    public AgriculturalLand(String landId, String ownerName, String location, double sizeInAcres, Date registrationDate, String landUseStatus) {
        super(landId, ownerName, location, sizeInAcres, registrationDate, landUseStatus);
    }

    @Override
    public boolean validateOwnership() {
        return !ownerName.isEmpty() && sizeInAcres >= 1;
    }

    @Override
    public boolean checkZoningCompliance() {
        return true; // Assume agricultural zoning
    }

    @Override
    public double calculateTax() {
        return sizeInAcres * 5000 * 0.01; // 1% tax
    }

    @Override
    public void generateLandReport() {
        displayBasicInfo();
        System.out.println("Land Type: Agricultural Land");
        System.out.println("Tax: $" + calculateTax());
        System.out.println("Zoning Compliance: " + (checkZoningCompliance() ? "Compliant" : "Not Compliant"));
        System.out.println("Ownership Validity: " + (validateOwnership() ? "Valid" : "Invalid"));
    }
}

