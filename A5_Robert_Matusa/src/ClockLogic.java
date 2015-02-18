public class ClockLogic implements ClockInterface {

	private DigitalClockGUI clockGUI;
	private int alarmHour;
	private int alarmMinute;
	private int realHour;
	private int realMinute;

	public ClockLogic(DigitalClockGUI clockin) {
		this.clockGUI = clockin;
		Thread t = new ClockThread(this);
		t.start();
	}

	public void setAlarm(int hours, int minute) {
		alarmHour = hours;
		alarmMinute = minute;

		if (alarmHour == realHour && alarmMinute == realMinute) {
			clockGUI.alarm(true);
		} else {

		}

	}

	public void clearAlarm() {

	}

	public void update(int hours, int minutes, int seconds) {

		String hourZero = "";
		String minuteZero = "";
		String secondZero = "";

		if (hours < 10) {
			hourZero = "0";
		}
		if (minutes < 10) {
			minuteZero = "0";
		}
		if (seconds < 10) {
			secondZero = "0";
		}

		String hourString = hourZero + Integer.toString(hours);
		String minuteString = minuteZero + Integer.toString(minutes);
		String secondString = secondZero + Integer.toString(seconds);

		String masterString = hourString + ":" + minuteString + ":"
				+ secondString;

		clockGUI.setTimeOnLabel(masterString);

		realHour = hours;
		realMinute = minutes;

		if (alarmHour == realHour && alarmMinute == realMinute) {
			clockGUI.alarm(true);
		} else {

		}

	}

}