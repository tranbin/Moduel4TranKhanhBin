package service;

import model.Email;

import java.util.List;

public class EmailService {
    private static List<Email> emailList;

    public void saveEmail(Email email) {
        emailList.add(email);
    }
    public List<Email> getAllEmail(){
        return emailList;
    }
}
