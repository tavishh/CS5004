import static java.lang.Math.clamp;

/**
 * Represents an Electric Vehicle with battery and range calculations
 */

public class ElectricVehicle {
  // Constants
  private static final double MIN_BATTERY_SIZE = 10.0;
  private static final double MAX_BATTERY_SIZE = 150.0;
  private static final double MIN_EFFICIENCY = 0.5;
  private static final double MAX_EFFICIENCY = 4.5;
  private static final double MIN_SOC = 0.15;
  private static final double MAX_SOC = 1.0;

  // Temperature Threshold Constants
  private static final double TEMP_LOWER = 65.0;
  private static final double TEMP_UPPER = 77.0;
  private static final double MAX_EFFICIENCY_LOSS = 0.50;

  // Fields
  private String name;
  private double batterySize;
  private double stateOfCharge;
  private double currentEfficiency;
  private final double defaultEfficiency;

  /**
   *
   * @param name               the name of the vehicle
   * @param batterySize        battery capacity measured in kWh (clamped to 10.0-150.0)
   * @param stateOfCharge      charge level as decimal (clamped to 0.15-1.0)
   * @param defaultEfficiency  rated efficiency in miles/kWh (clamped to 0.5-4.5)
   */

  // Constructor
  public ElectricVehicle(String name, double batterySize, double stateOfCharge,
      double defaultEfficiency){

    if (name == null || name.isEmpty()){
      this.name = "unknown EV";
    } else {
      this.name = name;
    }

    // Clamp all the values to thresholds provided
    this.batterySize = clamp(batterySize, MIN_BATTERY_SIZE, MAX_BATTERY_SIZE);
    this.stateOfCharge = clamp(stateOfCharge, MIN_SOC, MAX_SOC);
    this.defaultEfficiency = clamp(defaultEfficiency, MIN_EFFICIENCY, MAX_EFFICIENCY);

    // Current Efficiency starts at default efficiency
    this.currentEfficiency = this.defaultEfficiency;
  }

  /**
   * Calculates the current range of the vehicles in miles
   *
   * @return range in miles (currentEfficieny * stateOfCharge * batterySize)
   */

  public double range(){
    return currentEfficiency * stateOfCharge * batterySize;
  }

  /**
   * Updates the current Efficiency based on outside temperature.
   *  - If 65°F <= current temp <= 77°F : 100% of default efficiency
   *  - If current temp > 77°F : 85% of default efficiency
   *  - If current temp < 65°F : loses 1% per degree below 65 capped at 50%
   * @param currentTemp the current temperature in Fahrenheit
   */


  public void updateEfficiency(double currentTemp){
    if (currentTemp >= TEMP_LOWER && currentTemp <= TEMP_UPPER){
      this.currentEfficiency = this.defaultEfficiency;
    } else if (currentTemp > TEMP_UPPER){
      this.currentEfficiency = 0.85 * this.defaultEfficiency;
    } else if (currentTemp < TEMP_LOWER){
      double degreesBelow = TEMP_LOWER - currentTemp;
      double efficiencyLoss = degreesBelow/100; //1% per degree

      // Cap the loss at 50%
      if (efficiencyLoss > MAX_EFFICIENCY_LOSS){
        efficiencyLoss = MAX_EFFICIENCY_LOSS;
      }

      this.currentEfficiency = this.defaultEfficiency * (1.0 - efficiencyLoss);
    }

  }

  /**
   * Returns the current efficiency of the vehicle
   *
   * @return current efficiency in miles per kWh
   */

  public double getEfficiency(){
    return this.currentEfficiency;
  }


  /**
   * Returns the battery size of the vehicle
   *
   * @return battery size in kWh
   */

  public double getBatterySize(){
    return this.batterySize;
  }

  /**
   * Returns the state of charge of the vehicle
   *
   * @return state of charge as decimal (0.15 to 1.0)
   */

  public double getStateOfCharge(){
    return this.stateOfCharge;
  }

  /**
   * Returns the name of the vehicle
   *
   * @return vehicle name
   */

  public String getName(){
    return this.name;
  }

  /**
   * Sets the state of charge and clamp to valid range
   *
   * @param stateOfCharge new soc as decimal (0.15 - 1.0)
   */
  public void setStateOfCharge(double stateOfCharge){
    this.stateOfCharge = clamp(stateOfCharge, MIN_SOC, MAX_SOC);
  }

/**
 * Returns a string representation of the vehicle.
 * Format: "Name SOC: XX.X% Range (miles): XXX.X"
 *
 * @return formatted string name, SOC percentage, and range
 */

@Override
  public String toString(){
  //Convert decimal SOC to percentage for display
  double socPercent = this.stateOfCharge * 100.0;
  double currentRange = range();

  return String.format("%s SOC: %.1f%% Range (miles): %.1f", this.name, socPercent, currentRange);
}

}
