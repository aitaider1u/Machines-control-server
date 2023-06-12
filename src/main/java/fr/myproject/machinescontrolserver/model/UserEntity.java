package fr.myproject.machinescontrolserver.model;


import fr.myproject.machinescontrolserver.dto.RoleDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(unique = true)
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private boolean activeAccount;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable( name = "Users_Roles",
            joinColumns = @JoinColumn( name = "idUser" ),
            inverseJoinColumns = @JoinColumn( name = "idRole" ) )
    private List<Role> roles = new ArrayList<>();


    public void addRole(Role role){
        this.roles.add(role);
    }

    public void remove(Role role){
        this.roles.remove(role);
    }
}
