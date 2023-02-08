package io.springRan.api.resource;

import io.springRan.api.model.Account;
import io.springRan.api.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/accounts")
public class AccountResource {
    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount (@RequestBody Account account) {
        Account newAccount = accountService.createAccount(account);
        return ResponseEntity.created(EmployeeResource.getLocation(newAccount.getId().intValue())).body(newAccount);
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAccounts(){
        return ResponseEntity.ok(accountService.getAccounts());
    }
}
