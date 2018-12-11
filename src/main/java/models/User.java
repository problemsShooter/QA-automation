package models;

import lombok.*;
import net.bytebuddy.utility.RandomString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    protected SEX sex;
    protected String firstName;
    protected String secondName;
    protected String email;
    protected String password;
    protected MONTH month;
    protected String day;
    protected String year;
    protected String city;
    protected STATE state;
    protected String company;
    protected String address;
    protected String additionalAddress;
    protected String postalCod;
    protected String additionalInformation;
    protected String homePhone;
    protected String mobilPhone;
    protected COUNTRY country;
    protected CITY cityOfLiving;


    public User(SEX sex, String firstName, String secondName) {
        RandomString rs = new RandomString(10);
        this.sex = sex;
        this.firstName = firstName;
        this.secondName = secondName;
        email = rs.nextString() + "@gmail.com";
        password = rs.nextString();
        month = MONTH.JANUARY;
        day = "1";
        year = "1996";
        city = "Volgograd";
        state = STATE.ARIZONA;
        company = "new Company";
        address = "Baker 32 street, floor 3";
        additionalAddress = "Baker 33 street, floor 2";
        postalCod = "99501";
        additionalInformation = "likes red colour";
        homePhone = "8(999) 99 99 99";
        mobilPhone = "8 (999) 999 99 99";
        country = COUNTRY.RUSSIA;
        cityOfLiving = CITY.VOLGOGRAD;
    }

    public enum STATE {//is it good to do enum public?
        ALASKA("Alaska"),
        ARIZONA("Arizona"),
        ALABAMA("Alabama");
        private String state;

        STATE(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }

    public enum MONTH {

        JANUARY("january"),
        FEBRUARY("february"),
        MARCH("march"),
        APRIL("april"),
        MAY("may"),
        JUNE("june"),
        JULY("july"),
        AUGUST("august"),
        SEPTEMBER("september"),
        OCTOBER("october"),
        NOVEMBER("november"),
        DECEMBER("december");

        private String month;

        MONTH(String month) {
            this.month = month;
        }

        public String getMonth() {
            return month;
        }
    }

    public enum SEX {
        MR("Mr"),
        MRS("Mrs");

        private String sex;

        SEX(String sex) {
            this.sex = sex;
        }

        public String getSex() {
            return sex;
        }
    }

    enum COUNTRY {
        RUSSIA("Russia"),
        UNITED_STATES("United States");

        private String country;

        COUNTRY(String country) {
            this.country = country;
        }

        public String getCountry() {
            return country;
        }
    }

    public enum CITY {
        VOLGOGRAD("Volgograd"),
        ROSTOV("Rostov"),
        MOSCOW("Moscow");
        private String city;

        CITY(String city) {
            this.city = city;
        }

        public String getCity() {
            return city;
        }
    }

    public String getFullName() {
        return firstName + " " + secondName;
    }
}
