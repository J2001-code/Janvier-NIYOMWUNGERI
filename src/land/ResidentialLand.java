package land;

import java.util.Date;

public class ResidentialLand extends Land {

    public ResidentialLand(String landId, String ownerName, String location, double sizeInAcres, Date registrationDate, String landUseStatus) {
        super(landId, ownerName, location, sizeInAcres, registrationDate, landUseStatus);
    }

    @Override
    public boolean validateOwnership() {
        return !ownerName.isEmpty();
    }

    @Override
    public boolean checkZoningCompliance() {
        return true; // Assume residential zoning
    }

    @Override
    public double calculateTax() {
        return sizeInAcres * 8000 * 0.015; // 1.5% tax
    }

    @Override
    public void generateLandReport() {
        displayBasicInfo();
        System.out.println("Land Type: Residential Land");
        System.out.println("Tax: $" + calculateTax());
        System.out.println("Zoning Compliance: " + (checkZoningCompliance() ? "Compliant" : "Not Compliant"));
        System.out.println("Ownership Validity: " + (validateOwnership() ? "Valid" : "Invalid"));
    }
}
