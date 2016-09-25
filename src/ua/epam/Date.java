package ua.epam;

/**
 * Created by Dmytro_Rybin on 9/22/2016.
 */
public class Date {

    protected int day;
    protected int mounth;
    protected int year;

    public Date() {
        this(1, 1, 1900);
    }

    public Date(int day, int mounth, int year) {
        if(checkDate(day, mounth, year)) {
            this.day = day;
            this.mounth = mounth;
            this.year = year;
        }
        else {
            this.day = 1;
            this.mounth = 1;
            this.year = 1900;
            System.out.println("default date is set");
        }

    }

    private boolean checkDate(int day, int mounth, int year) {
        if (day <= 31 && day >= 1) {
            if (mounth <= 12 && mounth >= 1) {
                if (year <= 2016  && year >= 1900) {
                    return true;
                }
            }
        }
            return  false;
    }

    @Override
    @MyAnnotation
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", mounth=" + mounth +
                ", year=" + year +
                '}';
    }

    public void print() {
        System.out.println(day + "." + mounth + "." + year);
    }

    public int getDay() {
        return day;
    }

    public int getMounth() {
        return mounth;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMounth(int mounth) {
        this.mounth = mounth;
    }

    public void setYear(int year) {
        this.year = year;
    }



}
