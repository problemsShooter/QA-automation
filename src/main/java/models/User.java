package models;

import net.bytebuddy.utility.RandomString;

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
    protected String address;
    protected String postalCod;
    protected String phone;
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
        address = "Baker 32 street, floor 3";
        postalCod = "99501";
        phone = "8(999) 99 99 99";
        mobilPhone = "8 (999) 999 99 99";
        country = COUNTRY.RUSSIA;
        cityOfLiving = CITY.VOLGOGRAD;
    }

    enum MONTH {

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

    enum CITY {
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

    public SEX getSex() {
        return sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public MONTH getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

    public String getYear() {
        return year;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getPostalCod() {
        return postalCod;
    }

    public String getPhone() {
        return phone;
    }

    public String getMobilPhone() {
        return mobilPhone;
    }

    public COUNTRY getCountry() {
        return country;
    }

    public CITY getCityOfLiving() {
        return cityOfLiving;
    }
}
