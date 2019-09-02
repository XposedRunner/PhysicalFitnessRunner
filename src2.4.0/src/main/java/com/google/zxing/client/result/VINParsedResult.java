package com.google.zxing.client.result;

public final class VINParsedResult extends ParsedResult {
    private final String countryCode;
    private final int modelYear;
    private final char plantCode;
    private final String sequentialNumber;
    private final String vehicleAttributes;
    private final String vehicleDescriptorSection;
    private final String vehicleIdentifierSection;
    private final String vin;
    private final String worldManufacturerID;

    public VINParsedResult(String str, String str2, String str3, String str4, String str5, String str6, int i, char c, String str7) {
        super(ParsedResultType.VIN);
        this.vin = str;
        this.worldManufacturerID = str2;
        this.vehicleDescriptorSection = str3;
        this.vehicleIdentifierSection = str4;
        this.countryCode = str5;
        this.vehicleAttributes = str6;
        this.modelYear = i;
        this.plantCode = c;
        this.sequentialNumber = str7;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getDisplayResult() {
        StringBuilder stringBuilder = new StringBuilder(50);
        stringBuilder.append(this.worldManufacturerID);
        stringBuilder.append(' ');
        stringBuilder.append(this.vehicleDescriptorSection);
        stringBuilder.append(' ');
        stringBuilder.append(this.vehicleIdentifierSection);
        stringBuilder.append(10);
        if (this.countryCode != null) {
            stringBuilder.append(this.countryCode);
            stringBuilder.append(' ');
        }
        stringBuilder.append(this.modelYear);
        stringBuilder.append(' ');
        stringBuilder.append(this.plantCode);
        stringBuilder.append(' ');
        stringBuilder.append(this.sequentialNumber);
        stringBuilder.append(10);
        return stringBuilder.toString();
    }

    public int getModelYear() {
        return this.modelYear;
    }

    public char getPlantCode() {
        return this.plantCode;
    }

    public String getSequentialNumber() {
        return this.sequentialNumber;
    }

    public String getVIN() {
        return this.vin;
    }

    public String getVehicleAttributes() {
        return this.vehicleAttributes;
    }

    public String getVehicleDescriptorSection() {
        return this.vehicleDescriptorSection;
    }

    public String getVehicleIdentifierSection() {
        return this.vehicleIdentifierSection;
    }

    public String getWorldManufacturerID() {
        return this.worldManufacturerID;
    }
}
