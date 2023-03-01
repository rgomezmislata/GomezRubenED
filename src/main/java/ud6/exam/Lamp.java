package ud6.exam;

/**
 * Esta clase representa una Lampara
 * @author Rubén Gómez 1DAMS
 * @version 1.0 2023-03-01
 */
public class Lamp {
    /**
     * Estado de la lampara encendida o apgado
     */
    private boolean isOn;
    /**
     * Consumo en de la Lampara en kWh
     */
    private final double consumption;

    /**
     * Crea una Lampara especificando el consumo que tiene y por defecto esta apagada
     * @param consumption Consumo de la Lampara creada
     */
    public Lamp(double consumption) {
        this.consumption = consumption;
        this.isOn = false;
    }

    /**
     * Esstado de la lampara
     * @return devuelve el estado de la lampara (True=Encendida/False=Apagada)
     */
    public boolean isOn(){
        return this.isOn;
    }

    /**
     * Enciende la lampara
     */
    public void turnOn() {
        this.isOn = true;
    }

    /**
     * Apaga la lampara
     */
    public void turnOff() {
        this.isOn = false;
    }

    /**
     * Intercambia el estado de la lampara
     */
    public void toggle() {
        this.isOn = !this.isOn;
    }

    /**
     * Consumo en uso de la lampara especifiando los segundos de uso
     * @param seconds segundos en funcionamiento de la lampara
     * @return devuelve el consumo en valor double en KW del uso que ha tenido en kW
     */
    public double computeConsumption(double seconds) {
        if (!this.isOn) {
            return 0.0;
        }
        double hours = seconds / 3600.0;
        return this.consumption * hours;
    }
    /**
     * @since 1.2
     */
}

