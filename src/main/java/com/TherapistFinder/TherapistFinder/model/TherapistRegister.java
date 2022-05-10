package com.TherapistFinder.TherapistFinder.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;


@Builder
@Entity(name = "TherapistRegister")
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TherapistRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, fetch =FetchType.EAGER)
    @JoinColumn(name = "therapist_id")
    private List<Therapist> therapist;

    @OneToOne(cascade = CascadeType.ALL, fetch =FetchType.EAGER )
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;




}
