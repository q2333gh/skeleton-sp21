package deque;

public interface Deque<Item> extends Iterable{

  public void addFirst(Item item);

  public void addLast(Item item);

  public int size();

  public boolean isEmpty();

  public void printDeque();

  public Item removeFirst();

  public Item removeLast();

  public Node<Item> get(int index);
}
