package com.user.electricity;


import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;
public class Utilities {
    static String CustomersFilename = "customers.txt";
    static String OperatorsFilename = "operators.txt";
    static String AdminFilename = "admins.txt";
    static String ComplaintsFilename = "complaints.txt";
    static String BillsFilename = "bills.txt";
    static int UserCount =0;
    static int CurrentUserID;
    static double tarrif = 0.14;
    final static double chargeConstant = 5.5;

    public static String generateMeterCode(String region){
        return  region.charAt(0)+ String.valueOf(UserCount);
    }

    // for ID
    public static void readNumbers(String filename) throws IOException {
        try {
            Scanner scanner = new Scanner(new File(filename));
            UserCount = scanner.nextInt();
            FileWriter file = new FileWriter(filename);
            file.write(String.valueOf(++UserCount));
            file.close();
        } catch (Exception e) {
            writeNumbers(filename);
        }
    }
    public static void writeNumbers(String filename) throws IOException {
        FileWriter file = new FileWriter(filename);
        file.write(String.valueOf(UserCount));
        file.close();
    }
    public static boolean validate_login (Person person, String filename) throws IOException, ClassNotFoundException {
        boolean login = false;
        ArrayList<Person> people = FileHandler.read_people(filename);
        for (Person c:  people) {
            if (c.getUsername().equals(person.getUsername()) && c.getPassword().equals(person.getPassword())) {
                login = true;
                Utilities.CurrentUserID = c.getId();
            }
        }
        return login;
    }
    public static void sendEmail(Customer customer, String text){
        String from = "pl2project1@gmail.com";
        String to = customer.getEmail();
        String host = "smtp.gmail.com";
        final String username = from;
        final String password = "admin_admin";

        Properties props =System.getProperties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
//        props.put("mail.smtp.ssl.enable", true);
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.port", "465");
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });
        try {
            MimeMessage m = new MimeMessage(session);
            m.setFrom(new InternetAddress(from));
            m.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
            m.setSubject("Electricity Billing System");
            m.setText(text);
            Transport.send(m);

        } catch (MessagingException e){
            e.printStackTrace();;
        }

    }


    public static double calculateCharge(double consumption){
        double charge = consumption * Utilities.chargeConstant;
        charge += Utilities.tarrif*charge;
        return charge;
    }


}