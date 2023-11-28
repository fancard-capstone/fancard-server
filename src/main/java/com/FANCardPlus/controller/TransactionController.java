package com.FANCardPlus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FANCardPlus.model.Facility;
import com.FANCardPlus.model.RolePermission;
import com.FANCardPlus.model.Transaction;
import com.FANCardPlus.model.TransactionCategory;
import com.FANCardPlus.model.User;
import com.FANCardPlus.model.UserRole;
import com.FANCardPlus.repository.FacilityRepository;
import com.FANCardPlus.repository.PermissionRepository;
import com.FANCardPlus.repository.RolePermissionRepository;
import com.FANCardPlus.repository.TransactionCategoryRepository;
import com.FANCardPlus.repository.TransactionRepository;
import com.FANCardPlus.repository.UserRepository;
import com.FANCardPlus.repository.UserRoleRepository;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionCategoryRepository transactionCategoryRepository;
    private final TransactionRepository transactionRepository;
    private final FacilityRepository facilityRepository;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PermissionRepository permissionRepository;
    private final RolePermissionRepository rolePermissionRepository;


    @Autowired
    public TransactionController(
        TransactionRepository transactionRepository, 
        TransactionCategoryRepository transactionCategoryRepository, 
        FacilityRepository facilityRepository, 
        UserRepository userRepository,
        UserRoleRepository userRoleRepository,
        PermissionRepository permissionRepository,
        RolePermissionRepository rolePermissionRepository
        ) {
        this.transactionRepository = transactionRepository;
        this.transactionCategoryRepository = transactionCategoryRepository;
        this.facilityRepository = facilityRepository;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.permissionRepository = permissionRepository;
        this.rolePermissionRepository = rolePermissionRepository;
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @PostMapping("/{userId}")
    public ResponseEntity<String> createTransactionByUser(@RequestBody Transaction transaction, @PathVariable Long userId) {
        Optional<TransactionCategory> checkCategory = transactionCategoryRepository.findById(transaction.getTransactionCategory().getTansactionCategoryId());
        Optional<User> checkUser = userRepository.findById(userId);
        Optional<Facility> checkFacility = facilityRepository.findById(transaction.getFacility().getFacilityId()); 
        
        if (hasPermission(checkUser.get(), checkFacility.get())) {
            if (checkUser.isPresent() && checkCategory.isPresent() && checkFacility.isPresent()) {
                transaction.setUser(checkUser.get());
                transactionRepository.save(transaction);
                return ResponseEntity.ok("Transaction added");
            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Transaction failed");
            }
        } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Transaction failed");
        }
    }

    private boolean hasPermission(User user, Facility facility){
        Optional<UserRole> checkUserRole = userRoleRepository.findById(user.getUserId());
        List<RolePermission> checkPermission = rolePermissionRepository.findByPermissionPermissionId(facility.getPermission().getPermissionId());
        // System.out.println(checkPermission.getRole().getRoleId());

        if (checkPermission.contains(checkUserRole.get())) {
            return true;
        } else {
            return false;
        }
    };

    @GetMapping("/{userId}")
    public ResponseEntity<List<Transaction>> getTransactionsByUser(@PathVariable Long userId) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            List<Transaction> transactionsByUser = transactionRepository.findByUser(user.get());
            return ResponseEntity.ok(transactionsByUser);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}