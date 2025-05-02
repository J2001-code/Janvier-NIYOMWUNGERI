package land;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        LandRegistry registry = new LandRegistry();

        Land land1 = new AgriculturalLand("AG001", "John Smith", "Farm Zone", 5.0, new Date(), "Vacant");
        Land land2 = new ResidentialLand("RS002", "Anna Johnson", "City Center", 1.5, new Date(), "In Use");
        Land land3 = new CommercialLand("CM003", "Business Corp", "Downtown", 3.0, new Date(), "Under Development");
        Land land4 = new IndustrialLand("IN004", "Factory Ltd", "Industrial Area", 8.0, new Date(), "Vacant");

        registry.addLand(land1);
        registry.addLand(land2);
        registry.addLand(land3);
        registry.addLand(land4);

        System.out.println("\n--- Land Registry Report ---");
        registry.displayAllLands();
    }
}

