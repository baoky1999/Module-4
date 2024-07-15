package com.customerlist.repository.iml;

import com.customerlist.model.Customer;
import com.customerlist.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomerRepository implements ICustomerRepository {

    private static List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer(1,"Bảo Kỳ", "ky123@gmail.com", "Tứ Hạ,Huế"));
        customers.add(new Customer(2,"Phong", "phong123@gmail.com", "Tứ Hạ,Huế"));
        customers.add(new Customer(3,"Hiếu", "hieu123@gmail.com", "Đông Hà,Quảng Trị"));
        customers.add(new Customer(4,"Thanh", "thanh123@gmail.com", "Bố Trạch,Quảng Bình"));
    }


    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findById(int id) {
        for (Customer c : customers) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void save(Customer customer) {
        Customer customerUpdate = findById(customer.getId());
        customerUpdate.setName(customer.getName());
        customerUpdate.setEmail(customer.getEmail());
        customerUpdate.setAddress((customer.getAddress()));
    }

}
