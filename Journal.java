package HW1;

import java.util.GregorianCalendar;

public class Journal extends Publication {

  private final String journalName;
  private final double impactFactor;

  // CONSTRUCTOR
  public Journal(double impactFactor, String name, GregorianCalendar apparition, int numberOfAuthors) {
    super(name, apparition, numberOfAuthors);
    this.journalName = name;
    this.impactFactor = impactFactor;
  }

  // GETTERS
  public String getJournalName() {
    return this.journalName;
  }
  public double getImpactFactor() {
    return this.impactFactor;
  }

  @Override
  public double computeScore() {
    int numberOfAuthors = getNumberOfAuthors();
    return (this.impactFactor * 0.5) / numberOfAuthors;
  }
}
