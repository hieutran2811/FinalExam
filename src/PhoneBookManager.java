import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookManager {
    List<PhoneBook> phoneBookList = new ArrayList<>();
    public void show(){
        for (PhoneBook phonebook:phoneBookList) {
            System.out.println(phonebook.toString());
        }

    }
    public void add(String name, String phoneNumber, String address, String group, String gender, String dateOfBirth){
        PhoneBook phoneBook = new PhoneBook(name,phoneNumber,address,group,gender,dateOfBirth);
        phoneBookList.add(phoneBook);
    }
    public void edit(String name, String phoneNumber, String address, String group, String gender, String dateOfBirth){
        for (PhoneBook phonebook:phoneBookList) {
            if (phoneNumber.equals(phonebook.getPhoneNumber())){
                phonebook.setName(name);
                phonebook.setPhoneNumber(phoneNumber);
                phonebook.setAddress(address);
                phonebook.setGroup(group);
                phonebook.setGender(gender);
                phonebook.setDateOfBirth(dateOfBirth);
            }
        }
    }
    public boolean checkPhoneNumber(String editPhoneNumber){
        boolean check=false;
        for (PhoneBook phonebook:phoneBookList) {
            if (editPhoneNumber.equals(phonebook.getPhoneNumber())) {
                check = true;
                break;
            }
        }
        return check;
    }
    public void delete(String deletePhoneNumber){
        for (PhoneBook phonebook:phoneBookList) {
            if (deletePhoneNumber.equals(phonebook.getPhoneNumber())) {
                phoneBookList.remove(phonebook);
            }
        }
    }
    public void findName(String name ){
        for (PhoneBook phonebook:phoneBookList) {
            if (name.equals(phonebook.getName())) {
                System.out.println( phonebook.toString());
            }
        }
    }
    public void findPhoneNumber(String phoneNumber ){
        for (PhoneBook phonebook:phoneBookList) {
            if (phoneNumber.equals(phonebook.getPhoneNumber())) {
                System.out.println( phonebook.toString());
            }
        }
    }
    public void read(){
        String fileName = "C:\\Users\\tran\\IdeaProjects\\FinalExam\\src\\PhoneBookList.txt";
        phoneBookList.removeAll(phoneBookList);
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                String[] results=line.split(",");
                PhoneBook phoneBook = new PhoneBook(results[0],results[1],results[2],results[3],results[4],results[5]);
                phoneBookList.add(phoneBook);
            }
            br.close();
        } catch (IOException var6) {
            System.err.format("IOException: %s%n", var6);
        }
    }
    public void save(){
        String fileName = "C:\\Users\\tran\\IdeaProjects\\FinalExam\\src\\PhoneBookList.txt";
        try {
            FileWriter writer = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(writer);
            for(PhoneBook phoneBook:phoneBookList) {
                String accountInfo = phoneBook.toString();
                bw.write(accountInfo);
                bw.newLine();
            }
            bw.close();
        } catch (IOException var6) {
            System.err.format("IOException: %s%n", var6);
        }
    }
}
