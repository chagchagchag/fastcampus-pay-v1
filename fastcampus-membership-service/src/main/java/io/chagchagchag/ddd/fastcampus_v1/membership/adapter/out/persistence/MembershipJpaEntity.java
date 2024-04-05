package io.chagchagchag.ddd.fastcampus_v1.membership.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "membership")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MembershipJpaEntity {
  @Id @GeneratedValue
  private Long membershipId;
  private String name;
  private String address;
  private String email;

  private boolean isValid;

  private String aggregateIdentifier;

  public MembershipJpaEntity(String name, String address, String email, boolean isValid, String aggregateIdentifier) {
    this.name = name;
    this.address = address;
    this.email = email;
    this.isValid = isValid;
    this.aggregateIdentifier = aggregateIdentifier;
  }

  @Override
  public String toString() {
    return "MembershipJpaEntity{" +
        "membershipId=" + membershipId +
        ", name='" + name + '\'' +
        ", address='" + address + '\'' +
        ", email='" + email + '\'' +
        ", isValid=" + isValid +
        ", aggregateIdentifier='" + aggregateIdentifier + '\'' +
        '}';
  }
}
