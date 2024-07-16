package com.mailbox.springmailbox.service;

import com.mailbox.springmailbox.model.Mail;

import java.util.List;

public interface IMailBoxService {
    Mail getAll();

    void save(Mail mail);
}
