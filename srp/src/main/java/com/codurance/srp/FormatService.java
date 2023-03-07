package com.codurance.srp;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatService {

    private String dateFormat;
    private String numberFormat;

    public FormatService(String dateFormat, String numberFormat) {
        this.dateFormat = dateFormat;
        this.numberFormat = numberFormat;
    }
    public String formatDate(LocalDate date) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(this.dateFormat);
        return dateFormatter.format(date);
    }

    public String formatNumber(int amount) {
        DecimalFormat decimalFormat = new DecimalFormat(this.numberFormat, DecimalFormatSymbols.getInstance(Locale.UK));
        return decimalFormat.format(amount);
    }
}
