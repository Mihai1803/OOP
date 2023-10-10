package HW1;

import java.util.GregorianCalendar;

public class ConferenceProceeding extends Publication {
  private final String volumeName;
  private final boolean indexed;

  // CONSTRUCTOR
  public ConferenceProceeding(boolean indexed, String name, GregorianCalendar apparition, int numberOfAuthors) {
    super(name, apparition, numberOfAuthors);
    this.volumeName = name;
    this.indexed = indexed;
  }

  // GETTERS
  public String getVolumeName() {
    return this.volumeName;
  }
  public boolean getIndexed() {
    return this.indexed;
  }

  @Override
  public double computeScore() {
    int numberOfAuthors = getNumberOfAuthors();
    return this.indexed ? 0.25 / numberOfAuthors : 0.2 / numberOfAuthors;
  }
}
