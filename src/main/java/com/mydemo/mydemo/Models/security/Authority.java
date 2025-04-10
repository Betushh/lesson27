package com.mydemo.mydemo.Models.security;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String authority;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
