import com.example.people.Person;

public class Application
{
    public static void main (String[] args) {

        // Deklarace a inicializace objektu karel typu com.example.people.Person
        //  (typ importován na řádku 1, proto zde již netřeba uvádět celý jeho název)
        Person arnost = new Person("Arnošt", "Houžvička");

        // Má Arnošt Houžvička pas?
        System.out.println(arnost.hasPassport());

        // Pořízení pasu (tzn. vytvoření instance objektu Passport uvnitř třídy Person)
        arnost.obtainPassport(20230221);

        // A teď, má Arnošt Houžvička pas?
        System.out.println(arnost.hasPassport());

        // Zjištění čísla pasu
        int passportIdentifier = arnost.getPassportIdentifier();
        System.out.println(passportIdentifier);

        // Výpis objektu arnost pomocí metody toString()
        System.out.println(arnost);
    }
}

