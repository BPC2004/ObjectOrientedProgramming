package factory;

public interface EnergyConsumer {
    double getVoltage();
    double getCurrent();

    default double yearlyPower() {
        return getVoltage() * getCurrent() * 24 * 365 * (1.0 / 1000);
    }
}
