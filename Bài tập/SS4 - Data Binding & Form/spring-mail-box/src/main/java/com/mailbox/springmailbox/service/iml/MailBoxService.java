package com.mailbox.springmailbox.service.iml;

import com.mailbox.springmailbox.model.Mail;
import com.mailbox.springmailbox.repository.IMailBoxRepository;
import com.mailbox.springmailbox.repository.iml.MailBoxRepository;
import com.mailbox.springmailbox.service.IMailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailBoxService implements IMailBoxService {

    @Autowired
    private IMailBoxRepository mailBoxRepository;

    @Override
    public Mail getAll() {
        return mailBoxRepository.getAll();
    }

    @Override
    public void save(Mail mail) {
        mailBoxRepository.save(mail);
    }
}
