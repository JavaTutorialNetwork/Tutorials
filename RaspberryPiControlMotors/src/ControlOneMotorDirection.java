import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;

/**
 * Controls motor direction of a single motor
 * @author https://javatutorial.net
 */
public class ControlOneMotorDirection {

	public static void main(String[] args) throws InterruptedException {
		// get a handle to the GPIO controller
		final GpioController gpio = GpioFactory.getInstance();

		final GpioPinDigitalOutput pinA = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "PinA");
		final GpioPinDigitalOutput pinB = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "PinB");
		final GpioPinDigitalOutput pinE = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, "PinE");

		System.out.println("rotate motor clock-wise for 3 seconds");
		pinA.high();
		pinB.low();
		pinE.high();

		// wait 3 seconds
		Thread.sleep(3000);

		System.out.println("rotate motor in oposite derection for 6 seconds");
		pinA.low();
		pinB.high();

		// wait 6 seconds
		Thread.sleep(6000);

		// stop motor
		System.out.println("Stopping motor");
		pinE.low();

		gpio.shutdown();
	}
}
