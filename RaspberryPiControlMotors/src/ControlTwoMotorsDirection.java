import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;

/**
 * Controls motor direction of a two DC motors
 * @author https://javatutorial.net
 */
public class ControlTwoMotorsDirection {

	public static void main(String[] args) throws InterruptedException {
		// get a handle to the GPIO controller
		final GpioController gpio = GpioFactory.getInstance();

		final GpioPinDigitalOutput motor1pinA = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "m1A");
		final GpioPinDigitalOutput motor1pinB = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "m1B");
		final GpioPinDigitalOutput motor1pinE = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, "m1E");
		final GpioPinDigitalOutput motor2pinA = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "m2A");
		final GpioPinDigitalOutput motor2pinB = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "m2B");
		final GpioPinDigitalOutput motor2pinE = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "m2E");

		System.out.println("rotate both motors clockwise for 3 seconds");
		motor1pinA.high();
		motor1pinB.low();
		motor1pinE.high();
		motor2pinA.high();
		motor2pinB.low();
		motor2pinE.high();

		// wait 3 seconds
		Thread.sleep(3000);

		System.out.println("rotate motor 1 in oposite derection for 3 seconds "
				+ "and motor 2 in oposite direction for 6 seconds");
		motor1pinA.low();
		motor1pinB.high();
		motor2pinA.low();
		motor2pinB.high();

		// wait 3 seconds
		Thread.sleep(3000);
		System.out.println("Stopping motor 1");
		motor1pinE.low();

		// wait 3 seconds
		Thread.sleep(3000);
		System.out.println("Stopping motor 2");
		motor2pinE.low();

		gpio.shutdown();
	}
}
