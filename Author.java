package HW1;

import java.util.ArrayList;

public class Author {
  private final String name;
  private final ArrayList<Publication> Publications = new ArrayList<>();

  // CONSTRUCTOR
  public Author(String name) {
    this.name = name;
  }

  // GETTERS
  public String getName() {
    return this.name;
  }
  public void getPublications() {
    for(Publication publication : Publications) {
      System.out.println(publication);
    }
  }


  public void addPublication(Publication publication) {
    this.Publications.add(publication);
  }

  public double computeScore() {
    double score = 0;
    for (Publication publication : Publications) {
      score += publication.computeScore();
    }
    return score;
  }
}


