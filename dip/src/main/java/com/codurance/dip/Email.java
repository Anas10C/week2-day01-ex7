package com.codurance.dip;

public class Email implements EmailInterface {
    private final String to;
    private final String subject;
    private final String message;

    Email(String to, String subject, String message) {
        this.to = to;
        this.subject = subject;
        this.message = message;
    }

    /*public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }*/

    public void send() {
        System.out.print("To:"+this.to+", Subject: "+this.subject+", Message: "+this.message);
    }

}
