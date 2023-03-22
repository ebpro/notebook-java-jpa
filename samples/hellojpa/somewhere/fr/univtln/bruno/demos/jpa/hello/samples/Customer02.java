// Generated by delombok at Fri Mar 17 11:01:30 UTC 2023
package fr.univtln.bruno.demos.jpa.hello.samples;

import jakarta.persistence.*;

import java.time.*;

import lombok.*;

@Entity
@Table(name = "CUSTOMER_02")
public class Customer02 {
    @Column(updatable = false)
    private final LocalDateTime creationDate = LocalDateTime.now();
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private long id;
    @Column(length = 50, nullable = false, unique = true)
    @NonNull
    private String email;
    @Column(length = 50, nullable = false)
    private String name;
    @Transient
    private int age;
    private LocalDate birthDate;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] photo;

    @java.lang.SuppressWarnings("all")
    private Customer02(@NonNull final String email) {
        if (email == null) {
            throw new java.lang.NullPointerException("email is marked non-null but is null");
        }
        this.email = email;
    }

    @java.lang.SuppressWarnings("all")
    public Customer02() {
    }

    @java.lang.SuppressWarnings("all")
    public static Customer02 of(@NonNull final String email) {
        return new Customer02(email);
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof Customer02)) return false;
        final Customer02 other = (Customer02) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        if (this.getAge() != other.getAge()) return false;
        final java.lang.Object this$email = this.getEmail();
        final java.lang.Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final java.lang.Object this$name = this.getName();
        final java.lang.Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final java.lang.Object this$birthDate = this.getBirthDate();
        final java.lang.Object other$birthDate = other.getBirthDate();
        if (this$birthDate == null ? other$birthDate != null : !this$birthDate.equals(other$birthDate)) return false;
        final java.lang.Object this$creationDate = this.getCreationDate();
        final java.lang.Object other$creationDate = other.getCreationDate();
        if (this$creationDate == null ? other$creationDate != null : !this$creationDate.equals(other$creationDate))
            return false;
        if (!java.util.Arrays.equals(this.getPhoto(), other.getPhoto())) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof Customer02;
    }

    @java.lang.SuppressWarnings("all")
    public long getId() {
        return this.id;
    }

    @java.lang.SuppressWarnings("all")
    public int getAge() {
        return this.age;
    }

    @NonNull
    @java.lang.SuppressWarnings("all")
    public String getEmail() {
        return this.email;
    }

    @java.lang.SuppressWarnings("all")
    public String getName() {
        return this.name;
    }

    @java.lang.SuppressWarnings("all")
    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        age = Period.between(birthDate, LocalDate.now()).getYears();
    }

    @java.lang.SuppressWarnings("all")
    public LocalDateTime getCreationDate() {
        return this.creationDate;
    }

    @java.lang.SuppressWarnings("all")
    public byte[] getPhoto() {
        return this.photo;
    }

    @java.lang.SuppressWarnings("all")
    public void setPhoto(final byte[] photo) {
        this.photo = photo;
    }

    @java.lang.SuppressWarnings("all")
    public void setName(final String name) {
        this.name = name;
    }

    @java.lang.SuppressWarnings("all")
    public void setEmail(@NonNull final String email) {
        if (email == null) {
            throw new java.lang.NullPointerException("email is marked non-null but is null");
        }
        this.email = email;
    }

    @java.lang.SuppressWarnings("all")
    public void setAge(final int age) {
        this.age = age;
    }

    @java.lang.SuppressWarnings("all")
    public void setId(final long id) {
        this.id = id;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        result = result * PRIME + this.getAge();
        final java.lang.Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final java.lang.Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final java.lang.Object $birthDate = this.getBirthDate();
        result = result * PRIME + ($birthDate == null ? 43 : $birthDate.hashCode());
        final java.lang.Object $creationDate = this.getCreationDate();
        result = result * PRIME + ($creationDate == null ? 43 : $creationDate.hashCode());
        result = result * PRIME + java.util.Arrays.hashCode(this.getPhoto());
        return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public java.lang.String toString() {
        return "Customer02(id=" + this.getId() + ", email=" + this.getEmail() + ", name=" + this.getName() + ", age=" + this.getAge() + ", birthDate=" + this.getBirthDate() + ", creationDate=" + this.getCreationDate() + ", photo=" + java.util.Arrays.toString(this.getPhoto()) + ")";
    }
}