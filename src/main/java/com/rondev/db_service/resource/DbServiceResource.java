package com.rondev.db_service.resource;

import com.rondev.db_service.model.*;
import com.rondev.db_service.repository.QuotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/db")
public class DbServiceResource {

    @Autowired
    private QuotesRepository quotesRepo;

    /**
     * Get a List of all the current quotes for a user
     * @param username
     * @return A List of all the quotes for a given user as Strings
     */
    @GetMapping("/{username}")
    public List<String> getQuotes(@PathVariable("username") String username) {

        return quotesRepo.findByUserName(username)
                .stream().map(Quote::getQuote)
                .collect(Collectors.toList());
    }

    /**
     * Add a quote to the database
     * @param quotes
     * @return A List of all the quotes for a given user as Strings
     */
    @PostMapping("/add_quotes")
    public List<String> addQuote(@RequestBody Quotes quotes){
        quotes.getQuotes()
                .stream()
                .map(quote -> new Quote(quotes.getUserName(), quote))
                .forEach(quote -> quotesRepo.save(quote));

        return getQuotesByUserName(quotes.getUserName());
    }

    /**
     * Remove all the quotes for a user
     * @param userName
     * @return A List of all the quotes for a given user as Strings
     */
    @DeleteMapping("/delete_quotes/{username}")
    public List<String> deleteQuotesByUserName(@PathVariable("username") String userName){
        List<Quote> allQuotes = quotesRepo.findByUserName(userName);
        quotesRepo.deleteAll(allQuotes);

        return quotesRepo.findByUserName(userName)
                .stream().map(Quote::getQuote)
                .collect(Collectors.toList());
    }

    /**
     * Utility method to create custom return data
     * @param username
     * @return List of stocks for the given user.
     */
    private List<String> getQuotesByUserName(@PathVariable("username") String username) {

        return quotesRepo.findByUserName(username)
                .stream().map(Quote::getQuote)
                .collect(Collectors.toList());

    }
}
