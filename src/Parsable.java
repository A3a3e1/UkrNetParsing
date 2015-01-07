import java.util.Set;

/**
 * Created by paulvoropaiev on 1/4/15.
 */
public interface Parsable {

    public abstract Set<String> parse(int x);
    public abstract void printNewItems();

}
