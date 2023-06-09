package fr.myproject.machinescontrolserver.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="Device")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "isOn")
    private boolean isOn;


    @Column(name = "launchedAt")
    private Date launchedAt;


    @Column(name = "operatingTime")
    private long operatingTime;

    @OneToMany(mappedBy="device")
    private List<UsageHistory> usageHistories;

}
