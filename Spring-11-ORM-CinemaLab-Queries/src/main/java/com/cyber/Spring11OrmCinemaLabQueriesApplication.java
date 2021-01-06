package com.cyber;

import com.cyber.enums.UserRole;
import com.cyber.repository.AccountRepository;
import com.cyber.repository.CinemaRepository;
import com.cyber.repository.MovieCinemaRepository;
import com.cyber.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@SpringBootApplication
public class Spring11OrmCinemaLabQueriesApplication {

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	CinemaRepository cinemaRepository;
	@Autowired
	MovieCinemaRepository movieCinemaRepository;
	@Autowired
	TicketRepository ticketRepository;

	public static void main(String[] args) {
		SpringApplication.run(Spring11OrmCinemaLabQueriesApplication.class, args);
	}

	@PostConstruct
	public void testEmployee(){
		System.out.println("---------------");
		System.out.println(accountRepository.findAllAdminAccounts(UserRole.USER));

		System.out.println("---------------");

		System.out.println(accountRepository.findAllAccounts());
		System.out.println(accountRepository.findByOrderByAgeDesc());
		System.out.println(accountRepository.findAllAccounts());

		System.out.println("---------------");
		System.out.println(cinemaRepository.distinctBySponsoredName());
		System.out.println(movieCinemaRepository.countByCinemaIdNativeQuery(4L));

		System.out.println("---------------");
		System.out.println(ticketRepository.fetchAllTicketsByUserJPQL(4l));
		System.out.println(ticketRepository.fetchAllTicketsWithRangeDates(LocalDateTime.now().minusDays(35),
				LocalDateTime.now()));

		System.out.println("---------------");
		System.out.println(ticketRepository.retrieveAllBySearchCriteria("it"));
	}

}
