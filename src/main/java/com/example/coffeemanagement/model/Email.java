package com.example.coffeemanagement.model;

import lombok.Getter;
import org.springframework.util.Assert;

import java.util.Objects;
import java.util.regex.Pattern;

@Getter
public class Email {

    private final String address;

    public Email(String address) {
        Assert.notNull(address, "address should not be null");
        Assert.isTrue(address.length() >= 4 && address.length()<=50, "address length must be between 4 and 50 characters.");  //validation
        Assert.isTrue(checkAddress(address), "Invalid email address");//message format이 email이 맞는지 검증
        this.address = address;
    }

    /**
     * email 정규표현식 regex//regexr.com 참조
     * @param address String
     * @return 매개변수로 받은 param이 regex에 match되는지 반환
     */
    private static boolean checkAddress(String address) {
        return Pattern.matches("\\b[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}\\b", address);  //pattern이 match 되는지 반환  //email 정규표현식 regex//regexr.com 참조
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(address, email.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Email{");
        sb.append("address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
