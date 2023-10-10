package HW1;

import java.util.GregorianCalendar;

public abstract class Publication {
  private final String name;
  private final GregorianCalendar apparition;
  private final int numberOfAuthors;

  // CONSTRUCTOR
  public Publication(String name, GregorianCalendar apparition, int numberOfAuthors) {
    this.name = name;
    this.apparition = apparition;
    this.numberOfAuthors = numberOfAuthors;
  }
  
  // GETTERS
  public String getName() {
    return this.name;
  }
  public GregorianCalendar getApparition() {
    return this.apparition;
  }
  public int getNumberOfAuthors() {
    return this.numberOfAuthors;
  }
  
  public abstract double computeScore();

}