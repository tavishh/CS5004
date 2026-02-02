import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit tests for the ElectricVehicle Class
 * Testing constructor, clamping, efficiency updates, and range calculations
 */

class ElectricVehicleTest {

  ElectricVehicle testEV;

  /**
   * Sets up a standard test EV before each test
   */
  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    testEV = new ElectricVehicle("Ford MachE", 100.0, 0.5, 3.5);
  }

  /**
   * Test range calculation: efficiency * SOC * battery size
   * Also tests range after efficiency update due to temperature
   */

  @org.junit.jupiter.api.Test
  void range() {
    // 3.5 * 0.5 * 100 = 175.0 miles
    assertEquals(175.0, testEV.range(), 0.001);

    // Test range at full charge: 3.5 * 1.0 * 100.0 = 350.0 miles
    testEV.setStateOfCharge(1.0);
    assertEquals(350.0,testEV.range(), 0.001);

    // Test range after temperature causes drop: 2.975 * 1.0 * 100.0 = 297.5 miles
    testEV.updateEfficiency(90.0);
    assertEquals(297.5, testEV.range(),0.001);
  }


  /**
   * Test efficiency updates based on temperature
   * Optimal: 65-77°F (100%), Hot: >77°F (85%), Cold: <65°F (1% loss per degree, max 50%)
   */
  @org.junit.jupiter.api.Test
  void updateEfficiency() {
    // Optimal temperature of 70°F: 100% of default
    testEV.updateEfficiency(70.0);
    assertEquals(3.5, testEV.getEfficiency(), 0.001);

    // Lower boundary of optimal (65°F): 100% of default
    testEV.updateEfficiency(65.0);
    assertEquals(3.5, testEV.getEfficiency(), 0.001);


    // Upper boundary of optimal (77°F): 100% of default
    testEV.updateEfficiency(77.0);
    assertEquals(3.5, testEV.getEfficiency(), 0.001);

    // Hot weather(90°F): 85% of default = 3.5 * 0.85 = 2.975
    testEV.updateEfficiency(90.0);
    assertEquals(2.975, testEV.getEfficiency(), 0.001);

    // Cold: 1 degree below (64°F): 99% = 3.5 * 0.99 = 3.465
    testEV.updateEfficiency(64.0);
    assertEquals(3.465, testEV.getEfficiency(), 0.001);

    // Cold: fractional (64.1°F): 99.1% = 3.5 * 0.991 = 3.4685
    testEV.updateEfficiency(64.1);
    assertEquals(3.4685, testEV.getEfficiency(), 0.001);

    // Cold: max loss at 15°F (50 degrees below): 50% = 3.5 * 0.5 = 1.75
    testEV.updateEfficiency(15.0);
    assertEquals(1.75, testEV.getEfficiency(), 0.001);

    // Extreme cold (0°F): still capped at 50% loss = 1.75
    testEV.updateEfficiency(0.0);
    assertEquals(1.75, testEV.getEfficiency(), 0.001);

  }

  /**
   * Tests efficiency returns current efficiency
   * Also tests that efficiency clamping works in constructor
   */

  @org.junit.jupiter.api.Test
  void getEfficiency() {
    // Normal case: current efficiency equals default after construction
    assertEquals(3.5, testEV.getEfficiency(), 0.001);

    // Efficiency clamped to min (0.5)
    ElectricVehicle lowEff = new ElectricVehicle("Test", 100.0, 0.5, 0.1);
    assertEquals(0.5, lowEff.getEfficiency(), 0.001);

    // Efficiency clamped to max (4.5)
    ElectricVehicle highEff = new ElectricVehicle("Test", 100.0, 0.5, 5.0);
    assertEquals(4.5, highEff.getEfficiency(), 0.001);
  }

  /**
   * Tests getBatterySize returns correct value
   * Also tests battery size clamping in constructor
   */

  @org.junit.jupiter.api.Test
  void getBatterySize() {
    // Normal case
    assertEquals(100.0, testEV.getBatterySize(), 0.001);

    // Clamped to min (10.0)
    ElectricVehicle smallBattery = new ElectricVehicle("Test", 5.0, 0.5, 3.5);
    assertEquals(10.0, smallBattery.getBatterySize(), 0.001);

    // Clamped to max (150.0)
    ElectricVehicle largeBattery = new ElectricVehicle("Test", 200.0, 0.5, 3.5);
    assertEquals(150.0, largeBattery.getBatterySize(), 0.001);

    // At min boundary
    ElectricVehicle minBattery = new ElectricVehicle("Test", 10.0, 0.5, 3.5);
    assertEquals(10.0, minBattery.getBatterySize(), 0.001);

    // At max boundary
    ElectricVehicle maxBattery = new ElectricVehicle("Test", 150.0, 0.5, 3.5);
    assertEquals(150.0, maxBattery.getBatterySize(), 0.001);

  }

  /**
   * Tests getStateOfCharge returns correct value
   * Also tests SOC clamping in constructor
   */

  @org.junit.jupiter.api.Test
  void getStateOfCharge() {
    // Normal case
    assertEquals(0.5, testEV.getStateOfCharge(), 0.001);

    // Clamped to min (0.15)
    ElectricVehicle lowSoc = new ElectricVehicle("Test", 100.0, 0.05, 3.5);
    assertEquals(0.15, lowSoc.getStateOfCharge(), 0.001);

    // Clamped to max (1.0)
    ElectricVehicle highSoc = new ElectricVehicle("Test", 100.0, 1.5, 3.5);
    assertEquals(1.0, highSoc.getStateOfCharge(), 0.001);
  }

  /**
   * Tests getName returns correct value
   * Also tests name validation (null and empty string)
   */
  @org.junit.jupiter.api.Test
  void getName() {
    // Normal case
    assertEquals("Ford MachE", testEV.getName());

    // Null name defaults to "unknown EV"
    ElectricVehicle nullName = new ElectricVehicle(null, 100.0, 0.5, 3.5);
    assertEquals("unknown EV", nullName.getName());

    // Empty string defaults to "unknown EV"
    ElectricVehicle emptyName = new ElectricVehicle("", 100.0, 0.5, 3.5);
    assertEquals("unknown EV", emptyName.getName());
  }

  /**
   * Tests setStateOfCharge updates value correctly
   * Also tests clamping in the setter
   */
  @org.junit.jupiter.api.Test
  void setStateOfCharge() {
    // Valid update
    testEV.setStateOfCharge(0.75);
    assertEquals(0.75, testEV.getStateOfCharge(), 0.001);

    // Clamped to min
    testEV.setStateOfCharge(0.0);
    assertEquals(0.15, testEV.getStateOfCharge(), 0.001);

    // Clamped to max
    testEV.setStateOfCharge(2.0);
    assertEquals(1.0, testEV.getStateOfCharge(), 0.001);
  }

  /**
   * Tests toString format: "Name SOC: XX.X% Range (miles): XXX.X"
   */

  @org.junit.jupiter.api.Test
  void testToString() {
    // Match the example from assignment: "Ford MachE SOC: 50.0% Range (miles): 131.8"
    ElectricVehicle ev = new ElectricVehicle("Ford MachE", 100.0, 0.5, 2.636);
    assertEquals("Ford MachE SOC: 50.0% Range (miles): 131.8", ev.toString());

    // Test with full charge
    testEV.setStateOfCharge(1.0);
    assertEquals("Ford MachE SOC: 100.0% Range (miles): 350.0", testEV.toString());

    // Test with unknown EV name
    ElectricVehicle unknown = new ElectricVehicle(null, 50.0, 0.2, 2.0);
    assertEquals("unknown EV SOC: 20.0% Range (miles): 20.0", unknown.toString());

  }
}