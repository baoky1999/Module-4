package com.mailbox.springmailbox.repository;

import com.mailbox.springmailbox.model.Mail;

import java.util.List;

public interface IMailBoxRepository {
    Mail getAll();

    void save(Mail mail);
}
