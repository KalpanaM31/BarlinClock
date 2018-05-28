package mainClass;
import com.ubs.opsit.interviews.Impl.BarlinClockTimeConvertor;

public class mainBarlinClock {

	public static void main(String... args)
	{
		BarlinClockTimeConvertor berlinClockLamp = new BarlinClockTimeConvertor();
		System.out.println(berlinClockLamp.convertTime(new String("12:59:39")));
	}
}
