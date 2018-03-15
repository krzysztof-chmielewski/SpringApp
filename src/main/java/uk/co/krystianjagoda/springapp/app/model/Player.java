package uk.co.krystianjagoda.springapp.app.model;

import static com.google.common.base.Preconditions.checkNotNull;

public class Player {

    private String firstName;
    private String lastName;

    public Player() {
    }

    public Player(String firstName, String lastName) {
        if (firstName.isEmpty() || lastName.isEmpty()) {
            throw new IllegalArgumentException("First or last name cannot be empty");
        }
        this.firstName = checkNotNull(firstName);
        this.lastName = checkNotNull(lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;

        Player player = (Player) o;

        if (getFirstName() != null ? !getFirstName().equals(player.getFirstName()) : player.getFirstName() != null)
            return false;
        return getLastName() != null ? getLastName().equals(player.getLastName()) : player.getLastName() == null;
    }

    @Override
    public int hashCode() {
        int result = getFirstName() != null ? getFirstName().hashCode() : 0;
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Player{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}