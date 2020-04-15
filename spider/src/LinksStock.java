import org.jsoup.nodes.Document;
import java.util.*;

class LinksStock {
    private final int maxCount;
    Set<String> visited = new HashSet<String>();
    CustomQueue<String> toVisit = new CustomQueue<String>();
    List<Document> pages = new LinkedList<Document>();
    public LinksStock(int max, CustomQueue<String> toVisit) {
        this.maxCount = max;
        this.toVisit.addAll(toVisit);

    }
    public boolean produce(String link) {
        if(!visited.contains(link))
        {
            toVisit.add(link);
            return true;
        }
        return false;
    }

    public String consume () {
        String s = toVisit.poll();
        System.out.println("Number of books after pull: "+toVisit.size());
        return s;
    }
    public void visit(String link, Document Dom) {
            visited.add(link);
            pages.add(Dom);
            System.out.println("Number of visited links after: " + visited.size() + " the link is:" + link);
            System.out.println("Number of visited pages after pull: " + pages.size());
    }
    public int getToVisitSize() {
        return toVisit.size();
    }
    public final int getMaxCount() {
        return maxCount;
    }
    public void printData()
    {
        System.out.println("bookCount: "+toVisit.size());
        System.out.println("maxCount: "+maxCount);
        System.out.println("consumedCount: "+visited.size());
    }
    public boolean isVisited(String URL)
    {
        return visited.contains(URL);

    }
    public int getVisitedSize()
    {
        return visited.size();
    }
}
