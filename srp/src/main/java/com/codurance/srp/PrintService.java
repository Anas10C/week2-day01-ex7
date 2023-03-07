package com.codurance.srp;

import java.text.MessageFormat;
import java.text.Normalizer;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.toCollection;

public class PrintService {
    private Console console;
    private FormatService formatter;
    private String header;

    public PrintService(FormatService formatter, Console console, String header) {
        this.formatter = formatter;
        this.console = console;
        this.header = header;
    }
    public void printStatement(List<Transaction> transactions) {
        printHeader(header);
        printTransactions(transactions);
    }

    private void printHeader(String header) {
        printLine(header);
    }


    private void  printTransactions(List<Transaction> transactions) {
        //List<Transaction> transactions = transactionRepository.all();
        final AtomicInteger balance = new AtomicInteger(0);
        transactions.stream()
                .map(transaction -> statementLine(transaction, balance.addAndGet(transaction.amount())))
                .collect(toCollection(LinkedList::new))
                .descendingIterator()
                .forEachRemaining(this::printLine);
    }

    private String statementLine(Transaction transaction, int balance) {
        return MessageFormat.format("{0} | {1} | {2}", formatter.formatDate(transaction.date()), formatter.formatNumber(transaction.amount()), formatter.formatNumber(balance));
    }

    private void printLine(String line) {
        console.printLine(line);
    }

}
