package models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import net.bytebuddy.utility.RandomString;
import processing.data.JSONObject;

import java.io.File;
import java.io.IOException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements FromJson<User> {

    protected SEX sex;
    protected String firstName;
    protected String secondName;
    protected String email;
    protected String password;
    protected MONTH month;
    protected String day;
    protected String year;
    protected boolean signUpForOurNewsletter;
    protected boolean receiveSpecialOffersFromOurPartners;
    protected String company;
    protected String address;
    protected String additionalAddress;
    protected String city;
    protected STATE state;
    protected String postalCod;
    protected COUNTRY country;
    protected String additionalInformation;
    protected String homePhone;
    protected String mobilPhone;
    protected String assignAnAddressAliasForFutureReference;

    public boolean isSignUpForOurNewsletter() {
        return signUpForOurNewsletter;
    }

    public boolean isReceiveSpecialOffersFromOurPartners() {
        return receiveSpecialOffersFromOurPartners;
    }

    public User fromJson(JSONObject json) {
        String str = json.toString();
        ObjectMapper objectMapper = new ObjectMapper();
        User user = null;
        try {
            user = objectMapper.readValue(str, User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

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
        country = COUNTRY.NON;
        assignAnAddressAliasForFutureReference = "Volgograd";
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    public enum STATE {//is it good to do enum public?
        NON("-"),
        ALABAMA("Alabama"),
        ALASKA("Alaska"),
        ARIZONA("Arizona");

        private String state;

        STATE(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }
    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    public enum MONTH {
        NON("nothing"),
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
    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
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
    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    public enum COUNTRY {
        NON("-"),
        UNITED_STATES("United States");

        private String country;

        COUNTRY(String country) {
            this.country = country;
        }

        public COUNTRY getCountry(String string) {//it would better to rewrite it
            int i;
            if (string.equals("Russia")) i = 0;
            else if (string.equals("United States")) i = 1;
            else i = 1;
            switch (i) {
                case 0:
                    return NON;
                case 1:
                    return UNITED_STATES;
                default:
                    return UNITED_STATES;
            }
        }

        public String getCountry() {
            return country;
        }
    }

    public String getFullName() {
        return firstName + " " + secondName;
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "name='" + firstName + '\'' +
//                ", surname='" + secondName + '\'' +
//               // ", sex='" + sex.getSex() + '\'' +
//                ", day='" + day + '\'' +
//                '}';
//    }

    @Override
    public String toString() {
        return "User{" +
                "sex=" + sex +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", month=" + month +
                ", day='" + day + '\'' +
                ", year='" + year + '\'' +
                ", company='" + company + '\'' +
                ", address='" + address + '\'' +
                ", additionalAddress='" + additionalAddress + '\'' +
                ", city='" + city + '\'' +
                ", state=" + state +
                ", postalCod='" + postalCod + '\'' +
                ", country=" + country +
                ", additionalInformation='" + additionalInformation + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", mobilPhone='" + mobilPhone + '\'' +
                ", assignAnAddressAliasForFutureReference='" + assignAnAddressAliasForFutureReference + '\'' +
                '}';
    }
}
