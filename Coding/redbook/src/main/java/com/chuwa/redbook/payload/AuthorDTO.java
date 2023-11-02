package com.chuwa.redbook.payload;



public class AuthorDTO {

    private Long id;

    private String name;

    private String dateOfBirth;

    private String placeOfBirth;

    private String nationality;

    private String gender;

    private String occupation;

    private int numberOfWorks;

    private String mostFamousWork;

    private String authorBio;

    private String profilePicture;

    public AuthorDTO() {
    }

    public AuthorDTO(Long id, String name, String dateOfBirth, String placeOfBirth, String nationality, String gender, String occupation, int numberOfWorks, String mostFamousWork, String authorBio, String profilePicture) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.nationality = nationality;
        this.gender = gender;
        this.occupation = occupation;
        this.numberOfWorks = numberOfWorks;
        this.mostFamousWork = mostFamousWork;
        this.authorBio = authorBio;
        this.profilePicture = profilePicture;
    }

    public AuthorDTO(String name, String dateOfBirth, String placeOfBirth, String nationality, String gender, String occupation, int numberOfWorks, String mostFamousWork, String authorBio, String profilePicture) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.nationality = nationality;
        this.gender = gender;
        this.occupation = occupation;
        this.numberOfWorks = numberOfWorks;
        this.mostFamousWork = mostFamousWork;
        this.authorBio = authorBio;
        this.profilePicture = profilePicture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getNumberOfWorks() {
        return numberOfWorks;
    }

    public void setNumberOfWorks(int numberOfWorks) {
        this.numberOfWorks = numberOfWorks;
    }

    public String getMostFamousWork() {
        return mostFamousWork;
    }

    public void setMostFamousWork(String mostFamousWork) {
        this.mostFamousWork = mostFamousWork;
    }

    public String getAuthorBio() {
        return authorBio;
    }

    public void setAuthorBio(String authorBio) {
        this.authorBio = authorBio;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
