package com.basic.myspringboot.repository;

import com.basic.myspringboot.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;

    @Test
    //Rollback 하지 마세요
    @Rollback(value = false)
    void save_find() {
//        Customer customer = new Customer();
//        customer.setAge(16);
//        customer.setEmail("spring@aa2.com");
//        Customer saved = customerRepository.save(customer);
//        assertThat(saved).isNotNull();
//        assertThat(saved.getEmail()).isEqualTo("spring@aa2.com");

        // 조회
        Optional<Customer> optionalById =
                customerRepository.findById(1L);//Optional<Customer>
//        assertThat(optionalById).isNotEmpty();
        if(optionalById.isPresent()){
            Customer exist = optionalById.get();
            assertThat(exist.getAge()).isEqualTo(16);
            //update는 setter만 호출해도 업데이트가 됩니다.
            exist.setEmail("spring@aa29.com");
            //delete
//            customerRepository.delete(exist);
        }
    }
}