package com.differentdoors.colengo.dal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class RefreshToken {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique=true)
    private String name;
    @Column( length = 1000 )
    private String refreshToken;
    private Date updated_at;
}
