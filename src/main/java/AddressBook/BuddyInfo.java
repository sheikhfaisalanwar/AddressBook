package AddressBook;

import javax.persistence.*;
@Entity
public class BuddyInfo {

    private String name;
    private String address;
    private String address1;
    private String phoneNumber;


    private Long id;

    private AddressBook addressBook;


    public BuddyInfo() {
    }

    public BuddyInfo(String name){
        this.name = name;
        this.address = "";
        this.address1 = "";
        this.phoneNumber = "";
    }

    public BuddyInfo(String name, String addr){
        this.name = name;
        this.address = addr;
        this.address1 = "";
        this.phoneNumber = "";
    }

    public BuddyInfo(String name, String addr, String num){
        this.name = name;
        this.address = addr;
        this.address1 = "";
        this.phoneNumber = num;
    }

    public BuddyInfo(String name, String addr, String addr2, String num){
        this.name = name;
        this.address = addr;
        this.address1 = addr2;
        this.phoneNumber = num;
    }





    /***************GETTERS****************************/
    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @ManyToOne
    public AddressBook getAddressBook() {
        return addressBook;
    }

    /***************SETTERS****************************/
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhoneNumber(String phone){
        this.phoneNumber = phone;
    }
    public void setId(Long buddyID) {
        this.id = buddyID;
    }

    public void setAddressBook(AddressBook addressBook){
        this.addressBook = addressBook;
    }

    @Override
    public String toString(){
        return "BuddyID: " +this.getId() + ", Name: " +this.name + ", Address: " + this.address + ", Phone Number: " + this.phoneNumber;
    }
}