package com.mailbox.springmailbox.repository.iml;

import com.mailbox.springmailbox.model.Mail;
import com.mailbox.springmailbox.repository.IMailBoxRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MailBoxRepository implements IMailBoxRepository {

    private static Mail mails = new Mail("Vietnamese", 25, true, "Bao Ky");




    @Override
    public Mail getAll() {
        return mails;
    }

    @Override
    public void save(Mail mail) {
        mails.setLanguage(mail.getLanguage());
        mails.setSize(mail.getSize());
        mails.setSpam(mail.isSpam());
        mails.setSignature(mail.getSignature());
    }
}
