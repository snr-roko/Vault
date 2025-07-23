package com.rokoinc.Vault.customer;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CustomerService {

    public final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers(String sort) {
        String order = "ASC";
        String sortField = "updatedAt";

        if (sort != null ) {
            if (sort.startsWith("-")) {
                sort = sort.substring(1);
                order = "DESC";
            }

            if (isValidSortField(sort)) {
                sortField = sort;
            }
        } else {
            order = "DESC";
        }

        return customerRepository.findAll(Sort.by(Sort.Direction.valueOf(order), sortField));
    }

    private boolean isValidSortField(String fieldName) {
        Set<String> allowedFields = Set.of(
                "firstName", "lastName", "createdAt", "updatedAt", "city", "region"
        );

        return allowedFields.stream().anyMatch(fieldName::equals);
    }
}
