package fr.myproject.machinescontrolserver.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Table(name="UsageHistory")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsageHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "actionDate")
    private Date actionDate;

    @Column(name = "isOn")
    private boolean isOn;

    @ManyToOne
    @JoinColumn(name="deviceId", nullable=false)
    @JsonBackReference
    private Device device;
}
