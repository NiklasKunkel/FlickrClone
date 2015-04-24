package photoshare;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class NewUserBean {
    private String email = "";
    private String password1 = "";
    private String password2 = "";
    private String firstName;
    private String lastName;
    private String dateOfBirth = " ";
    private String userGender = " ";
    private String currentCity = "";
    private String currentState = "";
    private String currentCountry = "";
    private String homeCity = "";
    private String homeState = "";
    private String homeCountry = "";
    private String schoolName = "";
    private String schoolMajor = "";
    private String schoolYear = "";

    public String saySomething() {
    System.out.println("Hello!");
    return "Test";
  }
  
  public String getEmail() {
    return email;
  }

  public String getPassword1() {
    return password1;
  }

  public String getPassword2() {
    return password2;
  }

  public String getFirstName(){
    return firstName;
  }
  
  public String getLastName(){
    return lastName;
  }
  
    public String getBirth(){
	return dateOfBirth;
    }

  public String getGender(){
    return userGender;
  }

  public String getCurrentCity(){
    return currentCity;
  }

  public String getCurrentState(){
    return currentState;
  }

  public String getCurrentCountry(){
    return currentCountry;
  }

  public String getHomeCity(){
    return homeCity;
  }
  public String getHomeState(){
    return homeState;
  }
  public String getHomeCountry(){
    return homeCountry;
  }
  public String getSchoolName(){
    return schoolName;
  }
  public String getSchoolMajor(){
    return schoolMajor;
  }
  public String getSchoolYear(){
    return schoolYear;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword1(String password1) {
    this.password1 = password1;
  }

  public void setPassword2(String password2) {
    this.password2 = password2;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
  public void setBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }
  
  public void setGender(String userGender) {
    this.userGender = userGender;
  }
  
  public void setCurrentCity(String currentCity) {
    this.currentCity = currentCity;
  }

  public void setCurrentState(String currentState) {
    this.currentState = currentState;
  }

  public void setCurrentCountry(String currentCountry) {
    this.currentCountry = currentCountry;
  }

  public void setHomeCity(String homeCity){
    this.homeCity = homeCity;
  }

  public void setHomeState(String homeState){
    this.homeState = homeState;
  }

  public void setHomeCountry(String homeCountry){
    this.homeCountry = homeCountry;
  }

  public void setSchoolName(String schoolName){
    this.schoolName = schoolName;
  }

  public void setSchoolMajor(String schoolMajor){
    this.schoolMajor = schoolMajor;
  }

  public void setSchoolYear(String schoolYear){
    this.schoolYear = schoolYear;
  }
}