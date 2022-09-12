package domain;

import base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Passenger extends BaseEntity {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
}

