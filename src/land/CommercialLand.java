package land;

import java.util.Date;

public class CommercialLand extends Land {

    public CommercialLand(String landId, String ownerName, String location, double sizeInAcres, Date registrationDate, String landUseStatus) {
        super(landId, ownerName, location, sizeInAcres, registrationDate, landUseStatus);
    }

    @Override
    public boolean validateOwnership() {
        return !ownerName.isEmpty();
    }

    @Override
    public boolean checkZoningCompliance() {
        return true; // Assume commercial zoning
    }

    @Override
    public double calculateTax() {
        return sizeInAcres * 10000 * 0.025; // 2.5% tax
    }

    @Override
    public void generateLandReport() {
        displayBasicInfo();
        System.out.println("Land Type: Commercial Land");
        System.out.println("Tax: $" + calculateTax());
        System.out.println("Zoning Compliance: " + (checkZoningCompliance() ? "Compliant" : "Not Compliant"));
        System.out.println("Ownership Validity: " + (validateOwnership() ? "Valid" : "Invalid"));
    }
}

