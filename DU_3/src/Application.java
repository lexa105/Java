import com.example.catalog.Catalog;
import com.example.document.Book;
import com.example.document.Document;
import com.example.document.Interview;
import com.example.document.WebPage;

public class Application {
     public static void main(String[] args) {
          Catalog catalog = new Catalog();

          Book book = new Book(
                  "Dášenka čili život štěněte",
                  "561561321846",
                  "Knižní klub",
                  "2009",
                  80
          );

          WebPage page = new WebPage(
                  "https://fis.vse.cz",
                  "FIS VŠE",
                  "bla bla hovna"
          );

          Document document = new Document(
                  "198229-2/OAM-2022",
                  "Rozhodnutí o udělení stipendia",
                  "Dne 27.02.2023 Vám bylo uděleno stipendium."
          );

          Interview interview = new Interview(
                  "Karel Čapek",
                  "Josef Čapek",
                  "KČ: Dobrý den. JČ: Ahoj., ...",
                  27
          );

          catalog.setStoredItem1(book);
          catalog.setStoredItem2(page);
          catalog.setStoredItem3(document);
          catalog.setStoredItem4(interview);

          String query = "Vám";
          String result = catalog.find(query);
          System.out.println(result);
     }
}
