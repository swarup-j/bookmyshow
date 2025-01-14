package com.application.nextshow.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Many;
import org.hibernate.metamodel.internal.StandardEmbeddableInstantiator;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class VenueScreen {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    //@OneToMany
    private UUID venueId;
    private String name;
    //@ManyToOne
    private UUID layoutId;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updated;

}
