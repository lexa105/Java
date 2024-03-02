import com.example.pes.Bouda;
import com.example.pes.Pes;

public class Application {
    public static void main(String[] args) {
        Bouda buda = new Bouda();
        buda.setHloubka(5);
        buda.setVyska(7);
        buda.setSirka(4);
        Pes dawg = new Pes(buda,"Alík", "černý", 52, true);
        System.out.println(dawg.toString());
        System.out.println(dawg.getObjemBoudy());


    }
}
