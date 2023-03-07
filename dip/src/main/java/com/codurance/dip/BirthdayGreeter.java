package com.codurance.dip;

import java.time.MonthDay;

public class BirthdayGreeter {
    private final EmployeeRepository employeeRepository;
    private final Clock clock;

    public BirthdayGreeter(EmployeeRepository employeeRepository, Clock clock) {
        this.employeeRepository = employeeRepository;
        this.clock = clock;
    }

    public void sendGreetings() {
        MonthDay today = clock.monthDay();
        employeeRepository.findEmployeesBornOn(today)
                .stream()
                .map(employee -> emailFor(employee))
                .forEach(email -> email.send());
    }

    private EmailInterface emailFor(Employee employee) {
        String message = String.format("Happy birthday, dear %s!", employee.getFirstName());
        EmailInterface email = new Email(employee.getEmail(), "Happy birthday!", message);
        return email;
    }

}