class CarRental {
    String customerName;
    String carModel;
    int rentalDays;

    // Assuming fixed daily rates for simplicity
    static double getDailyRate(String carModel) {
        switch (carModel.toLowerCase()) {
            case "sedan": return 50.0;
            case "suv": return 80.0;
            case "hatchback": return 40.0;
            default: return 60.0; // default rate
        }
    }

    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    double calculateTotalCost() {
        return rentalDays * getDailyRate(carModel);
    }
}
