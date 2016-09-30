package ua.app;

/**
 * Created by Dmytro_Rybin on 9/22/2016.
 */
public final class Time extends Date {

    private int hour;
    private int minute;
    private int second;

    public Time() {
        this(12, 0, 0);
    }

    public Time(int hour, int minute, int second) {
        if(checkTime(hour, minute, second)) {
            this.hour = day;
            this.minute = mounth;
            this.second = second;
        }
        else {
            this.hour = 12;
            this.minute = 0;
            this.second = 0;
            System.out.println("default time is set");
        }
    }

    private boolean checkTime(int hour, int minute, int second) {
        if (hour <= 24 && hour >= 1) {
            if (minute <= 60 && minute >= 0) {
                if (second <= 60  && second >= 0) {
                    return true;
                }
            }
        }
        return  false;
    }

    @Override
    public String toString() {
        return "Time{" +
                "hour=" + hour +
                ", minute=" + minute +
                ", second=" + second +
                '}';
    }

    @Override
    public void print() {
        System.out.println(hour + ":" + minute + ":" + second);
    }

    @MyAnnotation
    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setSecond(int second) {
        this.second = second;
    }
}
