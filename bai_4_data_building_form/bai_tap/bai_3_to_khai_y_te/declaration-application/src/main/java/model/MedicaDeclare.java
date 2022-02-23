package model;

public class MedicaDeclare {
    private String name;
    private String yearOfBirth;
    private String gender;
    private String country;
    private String identity;
    private String vehicle;
    private String seriVehicle;
    private String seriChair;
    private String dateStart;
    private String dateEnd;
    private String haveGoCountry;
    private String contact;
    private String address;
    private String phone;
    private String email;
    private Symptom symptom;
    private String goToFarm;
    private String tangent;

    public MedicaDeclare() {
    }

    public MedicaDeclare(String name, String yearOfBirth, String gender, String country, String identity, String vehicle, String seriVehicle, String seriChair, String dateStart, String dateEnd, String haveGoCountry, String contact, String address, String phone, String email, Symptom symptom, String goToFarm, String tangent) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.country = country;
        this.identity = identity;
        this.vehicle = vehicle;
        this.seriVehicle = seriVehicle;
        this.seriChair = seriChair;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.haveGoCountry = haveGoCountry;
        this.contact = contact;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.symptom = symptom;
        this.goToFarm = goToFarm;
        this.tangent = tangent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getSeriVehicle() {
        return seriVehicle;
    }

    public void setSeriVehicle(String seriVehicle) {
        this.seriVehicle = seriVehicle;
    }

    public String getSeriChair() {
        return seriChair;
    }

    public void setSeriChair(String seriChair) {
        this.seriChair = seriChair;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getHaveGoCountry() {
        return haveGoCountry;
    }

    public void setHaveGoCountry(String haveGoCountry) {
        this.haveGoCountry = haveGoCountry;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Symptom getSymptom() {
        return symptom;
    }

    public void setSymptom(Symptom symptom) {
        this.symptom = symptom;
    }

    public String getGoToFarm() {
        return goToFarm;
    }

    public void setGoToFarm(String goToFarm) {
        this.goToFarm = goToFarm;
    }

    public String getTangent() {
        return tangent;
    }

    public void setTangent(String tangent) {
        this.tangent = tangent;
    }
}
