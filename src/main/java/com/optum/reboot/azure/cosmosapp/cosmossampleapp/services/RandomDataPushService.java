package com.optum.reboot.azure.cosmosapp.cosmossampleapp.services;

import com.optum.reboot.azure.cosmosapp.cosmossampleapp.entities.Employee;
import com.optum.reboot.azure.cosmosapp.cosmossampleapp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

@Service
public class RandomDataPushService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void pushData() {
        IntStream.range(0, 1000000)
                .boxed()
                .parallel()
                .map( i -> getEmployee())
                .forEach(employeeRepository::save);
    }


    // class variable
    final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";

    final java.util.Random rand = new java.util.Random();

    ZoneId defaultZoneId = ZoneId.systemDefault();

    final List<String> states = List.of("AL", "AK", "AZ", "AR", "CA", "CZ", "CO", "CT", "DE", "DC");
    final List<String> emailExt = List.of("@gmail.com", "@gmail.co.uk", "@yahoo.com", "@yahoo.co.uk", "@gmail.ca", "@yahoo.ca");


    // consider using a Map<String,Boolean> to say whether the identifier is being used or not
    final Set<String> identifiers = new HashSet<String>();

    public String randomIdentifier() {
        StringBuilder builder = new StringBuilder();
        while(builder.toString().length() == 0) {
            int length = rand.nextInt(5)+5;
            for(int i = 0; i < length; i++) {
                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
            }
            if(identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }

    private int getYear() {
        return rand.nextInt(2000 - 1950 + 1)  + 1950;
    }

    private int getMonth() {
        return rand.nextInt(10 - 1 + 1)  + 1;
    }

    private int getDate() {
        return rand.nextInt(28 - 1 + 1)  + 1;
    }

    private Employee getEmployee() {
        String fname = randomIdentifier();
        String lname = randomIdentifier();
        return new Employee(fname,
                lname,
                (fname + "." + lname + emailExt.get(rand.nextInt(5 - 1 + 1) + 1)),
                Date.from(LocalDate.of(getYear(), getMonth(), getDate()).atStartOfDay(defaultZoneId).toInstant()),
                states.get(rand.nextInt(9 - 1 + 1)  + 1));
    }
}
