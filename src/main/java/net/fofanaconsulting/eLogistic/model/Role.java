package net.fofanaconsulting.eLogistic.model;

public enum Role {

  ADMIN("ADMIN"), USER("USER"), MAGASINIER("MAGASINER");

  private String name;

  Role(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }
}
