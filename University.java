package HW1;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class University {
  private final String name;
  private final String location;
  private final ArrayList<Author> Authors = new ArrayList<>();

  // CONSTRUCTOR
  public University(String name, String location) {
    this.name = name;
    this.location = location;
  }

  // GETTERS
  public String getName() {
    return this.name;
  }
  public String getLocation() {
    return this.location;
  }
  public void getAuthors()  {
    for(Author author : Authors) {
      System.out.println(author);
    }
  }

  
  public void addAuthor(Author author) {
    this.Authors.add(author);
  }

  public double computeScore() {
    double score = 0;
    for (Author author : Authors) {
      score += author.computeScore();
    }
    return score;
  }


  public static void main(String[] args) {
    
    GregorianCalendar date = new GregorianCalendar(2023, Calendar.APRIL, 10);
    
    // First author + 2 journals + 2 publication
    Author Mihai = new Author("Mihai");
    Journal mihaiFirstJournal = new Journal(3, "First Journal", date, 1);
    Journal mihaiSecondJournal = new Journal(4, "Second Journal", date, 1);
    ConferenceProceeding mihaiFirstConference = new ConferenceProceeding(false, "First Volume", date, 1);
    ConferenceProceeding mihaiSecondConference = new ConferenceProceeding(true, "Second Volume", date, 1);
    Mihai.addPublication(mihaiFirstJournal);
    Mihai.addPublication(mihaiSecondJournal);
    Mihai.addPublication(mihaiFirstConference);
    Mihai.addPublication(mihaiSecondConference);


    // Second author + 2 journals + 2 publication
    Author Vlad = new Author("Vlad");
    Journal vladFirstJournal = new Journal(3, "First Journal", date, 1);
    Journal vladSecondJournal = new Journal(4, "Second Journal", date, 1);
    ConferenceProceeding vladFirstConference = new ConferenceProceeding(false, "First Volume", date, 1);
    ConferenceProceeding vladSecondConference = new ConferenceProceeding(true, "Second Volume", date, 1);
    Vlad.addPublication(vladFirstJournal);
    Vlad.addPublication(vladSecondJournal);
    Vlad.addPublication(vladFirstConference);
    Vlad.addPublication(vladSecondConference);

    // University
    University Politehnica = new University("Politehnica", "Bucuresti");
    Politehnica.addAuthor(Mihai);
    Politehnica.addAuthor(Vlad);


    // Author score and university score
    double firstAuthorScore = Mihai.computeScore();
    double secondAuthorScore = Vlad.computeScore();
    double UniversityScore = Politehnica.computeScore();

    // firstAuthorScore and secondAuthorScore should be the same because I used the same inputs
    System.out.println(firstAuthorScore + " " + secondAuthorScore + " " + UniversityScore);

  }

}


