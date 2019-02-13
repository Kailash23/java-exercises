package clock;

public class Clock {

	int hours;
	int minutes;
	int seconds;

	Clock() {
		this.hours = 12;
		this.minutes = 0;
		this.seconds = 0;
	}

	Clock(int hours, int minutes, int seconds) {
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	Clock(int seconds) {
		this.hours = (seconds / (60 * 60)) % 24;
		this.minutes = (seconds / 60) % 60;
		this.seconds = (seconds % 60);
	}

	public void setClock(int seconds) {
		this.hours = (seconds / (60 * 60)) % 24;
		this.minutes = (seconds / 60) % 60;
		this.seconds = (seconds % 60);
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		if (hours > 23) {
			this.hours = this.hours % 24;
		} else {
			this.hours = hours;
		}
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		if (minutes > 59) {
			this.minutes = this.minutes % 60;
		} else {
			this.minutes = minutes;
		}
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		if (seconds > 59) {
			this.seconds = this.seconds % 60;
		} else {
			this.seconds = seconds;
		}
	}

	void tick() {
		if (this.hours == 23 && this.minutes == 59 && this.seconds == 59) {
			this.hours = 0;
			this.minutes = 0;
			this.seconds = 0;

		} else if (this.minutes == 59 && this.seconds == 59) {
			this.hours = this.hours + 1;
			this.minutes = 0;
			this.seconds = 0;

		} else if (this.seconds == 59) {
			this.minutes = this.minutes + 1;
			this.seconds = 0;

		} else {
			this.seconds = this.seconds + 1;
		}

	}

//  Approach 1
	
//	void addClock(Clock clock) {
//		int totalSeconds = (clock.hours * 60 * 60) + (clock.minutes * 60) + clock.seconds;
//		for(int i = 0; i < totalSeconds; i++) {
//			tick();
//		}
//	}

//	Approach 2

	void addClock(Clock clock) {
		int addSeconds = (clock.hours * 60 * 60) + (clock.minutes * 60) + clock.seconds;
		int currentSeconds = (this.hours * 60 * 60) + (this.minutes * 60) + this.seconds;
		int totalSeconds = addSeconds + currentSeconds;
		setClock(totalSeconds);
	}

	public String toString() {

		String hh = null;
		if (this.hours < 10) {
			hh = "0" + this.hours;
		} else {
		    hh = String.valueOf(this.hours);
		}

		String mm = null;
		if (this.minutes < 10) {
			mm = "0" + this.minutes;
		} else {
			mm = String.valueOf(this.minutes);
		}

		String ss = null;
		if (this.seconds < 10) {
			ss = "0" + this.seconds;
		} else {
			ss = String.valueOf(this.seconds);
		}

		return hh + ":" + mm + ":" + ss;
	}
}
