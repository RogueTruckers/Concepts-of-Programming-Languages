public class Cons implements ImmutableList {
    // ---BEGIN INSTANCE VARIABLES---
    public final int head;
    public final ImmutableList tail;
    // ---END INSTANCE VARIABLES---

    public Cons(final int head, final ImmutableList tail) {
        this.head = head;
        this.tail = tail;
    } // Cons

    public boolean equals(final Object other) {
        if (other instanceof Cons) {
            final Cons otherCons = (Cons) other;
            return head == otherCons.head && tail.equals(otherCons.tail);
        } else {
            return false;
        }
    } // equals

    public String toString() {
        return "Cons(" + head + ", " + tail.toString() + ")";
    } // toString

    public int hashCode() {
        return sum();
    } // hashCode

    public int length() {
        return 1 + this.tail.length();
    }

    public int sum() {
        return head + this.tail.sum();
    }

    public ImmutableList append(final ImmutableList other) {
        // create a new list. A cons list. Like addstatic from Office hours.
        ImmutableList myList = new Cons(head, this.tail.append(other));
        return myList;
    }

    public boolean contains(final int value) {
        // refer to the website. He has the hint, the only thing is to put recusrion
        // which is very similar to the append.
        return head == value || this.tail.contains(value);
    }

    public int numEqualTo(int value) {
        if (value == head) {
            return 1 + this.tail.numEqualTo(value);
        } else {
            return this.tail.numEqualTo(value);
        }
        // return 0;
        // return (1 + this.tail.numEqualTo(value)) || (this.tail.numEqualTo(value));
    }
} // Cons
