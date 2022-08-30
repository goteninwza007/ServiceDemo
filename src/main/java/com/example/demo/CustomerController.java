package com.example.demo;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
public class CustomerController {
    private ArrayList<Customer> customer = new ArrayList<Customer>();
    public  CustomerController(){
        this.customer.add(new Customer("1010", "John", true, 25));
        this.customer.add(new Customer("1018", "Peter", true, 24));
        this.customer.add(new Customer("1019", "Sara", false, 23));
        this.customer.add(new Customer("1110", "Rose", false, 23));
        this.customer.add(new Customer("1001", "Emma", false, 30));
    }
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ArrayList<Customer> getCustomer() {
        return customer;
    }
    @RequestMapping(value = "/customerbyid/{id}", method = RequestMethod.GET)
    public Customer getCustomerByID(@PathVariable("id") String ID) {
        for (int i = 0; i < customer.size(); i++) {
            if(customer.get(i).getID().equals(ID)){
                return customer.get(i);
            }
        }
        return null;
    }
    @RequestMapping(value = "/customerbyname/{n}", method = RequestMethod.GET)
    public Customer getCustomerByName(@PathVariable("n") String n) {
        for (int i = 0; i < customer.size(); i++) {
            if(customer.get(i).getName().equals(n)){
                return customer.get(i);
            }
        }
        return null;
    }
    @RequestMapping(value = "/customerDelByid/{id}", method = RequestMethod.DELETE)
    public boolean delCustomerByID(@PathVariable("id") String ID) {
        for (int i = 0; i < customer.size(); i++) {
            if(customer.get(i).getID().equals(ID)){
                customer.remove(i);
                return true;
            }
        }
        return false;
    }
    @RequestMapping(value = "/customerDelByname/{n}", method = RequestMethod.DELETE)
    public boolean delCustomerByName(@PathVariable("n") String n) {
        for (int i = 0; i < customer.size(); i++) {
            if(customer.get(i).getName().equals(n)){
                customer.remove(i);
                return true;
            }
        }
        return false;
    }
    @RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
    public boolean addCustomer(@RequestParam("id") String ID,@RequestParam("name") String n,@RequestParam("age") int a,@RequestParam("sex") String s) {
        if(s.equals("Male") || s.equals("male")){
            this.customer.add(new Customer(ID, n,true, a));
            return true;
        }
        else if(s.equals("Female") || s.equals("female")){
            this.customer.add(new Customer(ID, n,false, a));
            return true;
        }
        return false;
    }
    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public boolean addCustomer2(@RequestParam("id") String ID,@RequestParam("name") String n,@RequestParam("age") int a,@RequestParam("sex") String s) {
        if(s.equals("Male") || s.equals("male")){
            this.customer.add(new Customer(ID, n,true, a));
            return true;
        }
        else if(s.equals("Female") || s.equals("female")){
            this.customer.add(new Customer(ID, n,false, a));
            return true;
        }
        return false;
    }
}
