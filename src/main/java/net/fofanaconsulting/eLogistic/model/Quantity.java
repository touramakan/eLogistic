package net.fofanaconsulting.eLogistic.model;

public class Quantity {
  private int quantity;
  private QuantityUnit quantityUnit;
  private int pieceInUnit;

  public Quantity(int quantity, QuantityUnit quantityUnit, int pieceInUnit) {
    this.quantity = quantity;
    this.quantityUnit = quantityUnit;
    this.pieceInUnit = pieceInUnit;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public QuantityUnit getQuantityUnit() {
    return quantityUnit;
  }

  public void setQuantityUnit(QuantityUnit quantityUnit) {
    this.quantityUnit = quantityUnit;
  }

  public int getPieceInUnit() {
    return pieceInUnit;
  }

  public void setPieceInUnit(int pieceInUnit) {
    this.pieceInUnit = pieceInUnit;
  }

  @Override
  public String toString() {
    return "Quantity [quantity=" + quantity + ", quantityUnit=" + quantityUnit + ", pieceInUnit="
        + pieceInUnit + "]";
  }



}
