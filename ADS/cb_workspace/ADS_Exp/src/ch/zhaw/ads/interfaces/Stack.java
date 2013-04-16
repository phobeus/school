package ch.zhaw.ads.interfaces;
/**
  Interface f�r Abstrakten Datentyp (ADT) Stack
*/
public interface Stack<E> {
  /**
    Legt eine neues Objekt auf den Stack, falls noch nicht voll.
    @param x ist das Objekt, das dazugelegt wird.
   */
  public void push (E x) throws StackOverflowError;

  /**
    Entfernt das oberste und damit das zuletzt eingef�gte Objekt.
    Ist der Stack leer, wird null zur�ckgegeben.
    @return Gibt das oberste Objekt zur�ck oder null, falls leer.
  */
  public E pop ();

  /**
    Testet, ob der Stack leer ist.
    @return Gibt true zur�ck, falls der Stack leer ist.
  */
  public boolean isEmpty();

  /**
    Gibt das oberste Objekt zur�ck, ohne es zu entfernen.
    Ist der Stack leer, wird null zur�ckgegeben.
    @return Gibt das oberste Objekt zur�ck oder null, falls leer.
  */
  public E peek ();

  /**
    Entfernt alle Objekte vom Stack. Ein Aufruf von isEmpty() 
    ergibt nachher mit Sicherheit true.
  */
  public void makeEmpty ();

  /**
    Testet, ob der Stack voll ist.
    @return Gibt true zur�ck, falls der Stack voll ist.
  */
  public boolean isFull();
}

